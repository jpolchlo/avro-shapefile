/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package mil.nga.giat.geowave.adapter.vector.avro;

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroSimpleFeature extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7750123400461477046L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroSimpleFeature\",\"namespace\":\"mil.nga.giat.geowave.adapter.vector.avro\",\"fields\":[{\"name\":\"featureType\",\"type\":{\"type\":\"record\",\"name\":\"FeatureDefinition\",\"fields\":[{\"name\":\"featureTypeName\",\"type\":\"string\"},{\"name\":\"attributeNames\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"attributeTypes\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"attributeDefaultClassifications\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}},{\"name\":\"value\",\"type\":{\"type\":\"record\",\"name\":\"AttributeValues\",\"fields\":[{\"name\":\"fid\",\"type\":\"string\"},{\"name\":\"values\",\"type\":{\"type\":\"array\",\"items\":\"bytes\"}},{\"name\":\"classifications\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\"}]}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition featureType;
  @Deprecated public mil.nga.giat.geowave.adapter.vector.avro.AttributeValues value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public AvroSimpleFeature() {}

  /**
   * All-args constructor.
   * @param featureType The new value for featureType
   * @param value The new value for value
   */
  public AvroSimpleFeature(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition featureType, mil.nga.giat.geowave.adapter.vector.avro.AttributeValues value) {
    this.featureType = featureType;
    this.value = value;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return featureType;
    case 1: return value;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: featureType = (mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition)value$; break;
    case 1: value = (mil.nga.giat.geowave.adapter.vector.avro.AttributeValues)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'featureType' field.
   * @return The value of the 'featureType' field.
   */
  public mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition getFeatureType() {
    return featureType;
  }

  /**
   * Sets the value of the 'featureType' field.
   * @param value the value to set.
   */
  public void setFeatureType(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition value) {
    this.featureType = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public mil.nga.giat.geowave.adapter.vector.avro.AttributeValues getValue() {
    return value;
  }

  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(mil.nga.giat.geowave.adapter.vector.avro.AttributeValues value) {
    this.value = value;
  }

  /**
   * Creates a new AvroSimpleFeature RecordBuilder.
   * @return A new AvroSimpleFeature RecordBuilder
   */
  public static mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder newBuilder() {
    return new mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder();
  }

  /**
   * Creates a new AvroSimpleFeature RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroSimpleFeature RecordBuilder
   */
  public static mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder newBuilder(mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder other) {
    return new mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder(other);
  }

  /**
   * Creates a new AvroSimpleFeature RecordBuilder by copying an existing AvroSimpleFeature instance.
   * @param other The existing instance to copy.
   * @return A new AvroSimpleFeature RecordBuilder
   */
  public static mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder newBuilder(mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature other) {
    return new mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder(other);
  }

  /**
   * RecordBuilder for AvroSimpleFeature instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroSimpleFeature>
    implements org.apache.avro.data.RecordBuilder<AvroSimpleFeature> {

    private mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition featureType;
    private mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.Builder featureTypeBuilder;
    private mil.nga.giat.geowave.adapter.vector.avro.AttributeValues value;
    private mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.Builder valueBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.featureType)) {
        this.featureType = data().deepCopy(fields()[0].schema(), other.featureType);
        fieldSetFlags()[0] = true;
      }
      if (other.hasFeatureTypeBuilder()) {
        this.featureTypeBuilder = mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.newBuilder(other.getFeatureTypeBuilder());
      }
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
      }
      if (other.hasValueBuilder()) {
        this.valueBuilder = mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.newBuilder(other.getValueBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing AvroSimpleFeature instance
     * @param other The existing instance to copy.
     */
    private Builder(mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.featureType)) {
        this.featureType = data().deepCopy(fields()[0].schema(), other.featureType);
        fieldSetFlags()[0] = true;
      }
      this.featureTypeBuilder = null;
      if (isValidValue(fields()[1], other.value)) {
        this.value = data().deepCopy(fields()[1].schema(), other.value);
        fieldSetFlags()[1] = true;
      }
      this.valueBuilder = null;
    }

    /**
      * Gets the value of the 'featureType' field.
      * @return The value.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition getFeatureType() {
      return featureType;
    }

    /**
      * Sets the value of the 'featureType' field.
      * @param value The value of 'featureType'.
      * @return This builder.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder setFeatureType(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition value) {
      validate(fields()[0], value);
      this.featureTypeBuilder = null;
      this.featureType = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'featureType' field has been set.
      * @return True if the 'featureType' field has been set, false otherwise.
      */
    public boolean hasFeatureType() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'featureType' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.Builder getFeatureTypeBuilder() {
      if (featureTypeBuilder == null) {
        if (hasFeatureType()) {
          setFeatureTypeBuilder(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.newBuilder(featureType));
        } else {
          setFeatureTypeBuilder(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.newBuilder());
        }
      }
      return featureTypeBuilder;
    }

    /**
     * Sets the Builder instance for the 'featureType' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder setFeatureTypeBuilder(mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition.Builder value) {
      clearFeatureType();
      featureTypeBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'featureType' field has an active Builder instance
     * @return True if the 'featureType' field has an active Builder instance
     */
    public boolean hasFeatureTypeBuilder() {
      return featureTypeBuilder != null;
    }

    /**
      * Clears the value of the 'featureType' field.
      * @return This builder.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder clearFeatureType() {
      featureType = null;
      featureTypeBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.AttributeValues getValue() {
      return value;
    }

    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder setValue(mil.nga.giat.geowave.adapter.vector.avro.AttributeValues value) {
      validate(fields()[1], value);
      this.valueBuilder = null;
      this.value = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'value' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.Builder getValueBuilder() {
      if (valueBuilder == null) {
        if (hasValue()) {
          setValueBuilder(mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.newBuilder(value));
        } else {
          setValueBuilder(mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.newBuilder());
        }
      }
      return valueBuilder;
    }

    /**
     * Sets the Builder instance for the 'value' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder setValueBuilder(mil.nga.giat.geowave.adapter.vector.avro.AttributeValues.Builder value) {
      clearValue();
      valueBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'value' field has an active Builder instance
     * @return True if the 'value' field has an active Builder instance
     */
    public boolean hasValueBuilder() {
      return valueBuilder != null;
    }

    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public mil.nga.giat.geowave.adapter.vector.avro.AvroSimpleFeature.Builder clearValue() {
      value = null;
      valueBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public AvroSimpleFeature build() {
      try {
        AvroSimpleFeature record = new AvroSimpleFeature();
        if (featureTypeBuilder != null) {
          record.featureType = this.featureTypeBuilder.build();
        } else {
          record.featureType = fieldSetFlags()[0] ? this.featureType : (mil.nga.giat.geowave.adapter.vector.avro.FeatureDefinition) defaultValue(fields()[0]);
        }
        if (valueBuilder != null) {
          record.value = this.valueBuilder.build();
        } else {
          record.value = fieldSetFlags()[1] ? this.value : (mil.nga.giat.geowave.adapter.vector.avro.AttributeValues) defaultValue(fields()[1]);
        }
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
