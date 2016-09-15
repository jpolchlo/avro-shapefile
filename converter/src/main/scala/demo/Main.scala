package demo

import com.vividsolutions.jts.geom.{LineString}
import com.vividsolutions.jts.io.WKBReader
import org.apache.avro._
import org.apache.avro.file._
import org.apache.avro.generic._
import org.apache.avro.io._
import org.geotools.data.{DefaultTransaction, FeatureWriter, Transaction}
import org.geotools.data.shapefile._
import org.geotools.data.simple.{SimpleFeatureSource, SimpleFeatureStore}
import org.geotools.feature.{AttributeTypeBuilder, DefaultFeatureCollection, FeatureCollections}
import org.geotools.feature.simple._
import org.geotools.referencing.crs.DefaultGeographicCRS
import org.opengis.feature.simple.{SimpleFeature, SimpleFeatureType}
import org.opengis.geometry.Geometry

import java.io.{File, FileOutputStream}
import java.nio.ByteBuffer
import java.util.HashMap
import scala.util.Try

object Main {
  
  case class Config(schemaFileName: String = "",
                    avroFiles: Seq[String] = Nil)

  val parser = new scopt.OptionParser[Config]("avro-to-shapefile") {
    head("avro-to-shapefile", "0.1")
    
    opt[String]('s',"schema")
      .action( (s, conf) => conf.copy(schemaFileName = s) )
      .required
      .text("Avro schema file name")
    help("help").text("Print this usage text")
    arg[String]("<file> ...")
      .unbounded
      .action( (f, conf) => conf.copy(avroFiles = conf.avroFiles :+ f) )
      .text("List of .avro files for conversion")
  }

  def generatedTrackSFT() = {
    val builder = new SimpleFeatureTypeBuilder
    val attr = new AttributeTypeBuilder

    builder.setName("generated-track")
    builder.setCRS(DefaultGeographicCRS.WGS84)

    builder.add(attr.binding(classOf[LineString]).nillable(false).buildDescriptor("the_geom"))
    builder.add(attr.binding(classOf[Integer]).nillable(false).buildDescriptor("numPoints"))
    builder.add(attr.binding(classOf[java.lang.Long]).nillable(false).buildDescriptor("datetime"))
    builder.add(attr.binding(classOf[String]).nillable(false).buildDescriptor("key"))
    builder.add(attr.binding(classOf[java.lang.Double]).nillable(false).buildDescriptor("pathLength"))

    builder.buildFeatureType
  }

  def convertToSimpleFeature(record: GenericRecord, sft: SimpleFeatureType) = {
    val simpleFeatureCollection = record.get(1).asInstanceOf[GenericData.Array[GenericRecord]].get(0)
    val values = simpleFeatureCollection.get("values").asInstanceOf[GenericData.Array[ByteBuffer]]
    val geometry = values.get(0).array
    val timeStamp = values.get(1).array // serialized java.util.Date
    val key = values.get(2).array // String
    val totalDistance = values.get(3).array // java.lang.Double
    val numTrackPoints = values.get(4).array // Integer

    val linestring = (new WKBReader).read(geometry).asInstanceOf[LineString]

    val buf: ByteBuffer = ByteBuffer.allocate(8)
    val millis: java.lang.Long = buf.put(timeStamp).flip.asInstanceOf[ByteBuffer].getLong
    val trackDate = new java.util.Date(millis)

    val keyString = key.map(_.toChar).mkString

    val pathLength: java.lang.Double = buf.flip.asInstanceOf[ByteBuffer].put(totalDistance).flip.asInstanceOf[ByteBuffer].getDouble

    val buf4: ByteBuffer = ByteBuffer.allocate(4)
    val numPts: java.lang.Integer = buf4.put(numTrackPoints).flip.asInstanceOf[ByteBuffer].getInt

    if (linestring.getNumPoints != numPts)
      println(s"LineString point number disagreement")

    val builder = new SimpleFeatureBuilder(generatedTrackSFT)

    builder.set("the_geom", linestring)
    builder.set("numPoints", numPts)
    builder.set("datetime", millis)
    builder.set("key", keyString)
    builder.set("pathLength", pathLength)

    val result = builder.buildFeature(null)

    if (((result.getAttribute("the_geom")).asInstanceOf[LineString]).getNumPoints != numPts)
      println(s"SimpleFeature geometry point number disagreement")

    result
  }

  def addFeature(feature: SimpleFeature,
                 writer: FeatureWriter[SimpleFeatureType, SimpleFeature]) = {

    val toWrite: SimpleFeature = writer.next
    for (i <- 0 until toWrite.getType.getAttributeCount) {
        val name = toWrite.getType.getDescriptor(i).getLocalName
        toWrite.setAttribute(name, feature.getAttribute(name))
    }

    // copy over the user data
    if (feature.getUserData.size > 0) {
        toWrite.getUserData.putAll(feature.getUserData())
    }

    // perform the write
    writer.write();
}  

  def main(args: Array[String]) = {
    val config = parser.parse(args, Config()) match {
      case Some(cfg) => cfg
      case None => {
        java.lang.System.exit(0)
        Config()
      }
    }

    val schema = (new Schema.Parser).parse(new File(config.schemaFileName))
    val datumReader = new GenericDatumReader[GenericRecord](schema)
    val sft = generatedTrackSFT
    val shpDSFactory = new ShapefileDataStoreFactory

    config.avroFiles.foreach 
      { avrofile =>
        val dfr = new DataFileReader[GenericRecord](new File(avrofile), datumReader)
        println(s"Opened $avrofile for reading.")

        val shpFile = new File(avrofile.replace(".avro", ".shp"))
        val params = new HashMap[String, java.io.Serializable]
        params.put("url", shpFile.toURI.toURL)
        params.put("create spatial index", true)
        println(s"Opening ${shpFile.toURI.toURL} for writing...")

        val dataStore = shpDSFactory.createDataStore(params).asInstanceOf[ShapefileDataStore]
        dataStore.createSchema(sft)

        // val transaction = new DefaultTransaction("create")

        // val writerOpt = Try(dataStore.getFeatureWriter(transaction))
        // if (writerOpt.isFailure) {
        //   transaction.close
        //   java.lang.System.exit(-1)
        // }
        // val writer = writerOpt.get

        var count = 0
        val collection = new DefaultFeatureCollection(null, sft)
        while (dfr.hasNext) {
          count += 1
          val record = dfr.next
          val feature = convertToSimpleFeature(record, sft)
          // addFeature(feature, writer)
          collection.add(feature)
          if (count%1000 == 0) {
            println(s"Read $count records")
          }
        }
        println(s"$avrofile has $count entries")
        println(s"DefaultFeatureCollection contains ${collection.size} entries")

        // writer.close

        val featureStore = dataStore.getFeatureSource(dataStore.getTypeNames()(0)).asInstanceOf[SimpleFeatureStore]
        featureStore.setTransaction(Transaction.AUTO_COMMIT)
        featureStore.addFeatures(collection)

        // transaction.commit
        // transaction.close
      }
  }
  
}
