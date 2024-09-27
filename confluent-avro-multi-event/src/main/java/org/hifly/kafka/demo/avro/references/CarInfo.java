/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.hifly.kafka.demo.avro.references;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CarInfo extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6700885825016431999L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CarInfo\",\"namespace\":\"org.hifly.kafka.demo.avro.references\",\"fields\":[{\"name\":\"model\",\"type\":\"string\"},{\"name\":\"brand\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<CarInfo> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CarInfo> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CarInfo> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CarInfo> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CarInfo> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CarInfo to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CarInfo from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CarInfo instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CarInfo fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence model;
  private java.lang.CharSequence brand;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CarInfo() {}

  /**
   * All-args constructor.
   * @param model The new value for model
   * @param brand The new value for brand
   */
  public CarInfo(java.lang.CharSequence model, java.lang.CharSequence brand) {
    this.model = model;
    this.brand = brand;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return model;
    case 1: return brand;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: model = (java.lang.CharSequence)value$; break;
    case 1: brand = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'model' field.
   * @return The value of the 'model' field.
   */
  public java.lang.CharSequence getModel() {
    return model;
  }


  /**
   * Sets the value of the 'model' field.
   * @param value the value to set.
   */
  public void setModel(java.lang.CharSequence value) {
    this.model = value;
  }

  /**
   * Gets the value of the 'brand' field.
   * @return The value of the 'brand' field.
   */
  public java.lang.CharSequence getBrand() {
    return brand;
  }


  /**
   * Sets the value of the 'brand' field.
   * @param value the value to set.
   */
  public void setBrand(java.lang.CharSequence value) {
    this.brand = value;
  }

  /**
   * Creates a new CarInfo RecordBuilder.
   * @return A new CarInfo RecordBuilder
   */
  public static org.hifly.kafka.demo.avro.references.CarInfo.Builder newBuilder() {
    return new org.hifly.kafka.demo.avro.references.CarInfo.Builder();
  }

  /**
   * Creates a new CarInfo RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CarInfo RecordBuilder
   */
  public static org.hifly.kafka.demo.avro.references.CarInfo.Builder newBuilder(org.hifly.kafka.demo.avro.references.CarInfo.Builder other) {
    if (other == null) {
      return new org.hifly.kafka.demo.avro.references.CarInfo.Builder();
    } else {
      return new org.hifly.kafka.demo.avro.references.CarInfo.Builder(other);
    }
  }

  /**
   * Creates a new CarInfo RecordBuilder by copying an existing CarInfo instance.
   * @param other The existing instance to copy.
   * @return A new CarInfo RecordBuilder
   */
  public static org.hifly.kafka.demo.avro.references.CarInfo.Builder newBuilder(org.hifly.kafka.demo.avro.references.CarInfo other) {
    if (other == null) {
      return new org.hifly.kafka.demo.avro.references.CarInfo.Builder();
    } else {
      return new org.hifly.kafka.demo.avro.references.CarInfo.Builder(other);
    }
  }

  /**
   * RecordBuilder for CarInfo instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CarInfo>
    implements org.apache.avro.data.RecordBuilder<CarInfo> {

    private java.lang.CharSequence model;
    private java.lang.CharSequence brand;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.hifly.kafka.demo.avro.references.CarInfo.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.model)) {
        this.model = data().deepCopy(fields()[0].schema(), other.model);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.brand)) {
        this.brand = data().deepCopy(fields()[1].schema(), other.brand);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing CarInfo instance
     * @param other The existing instance to copy.
     */
    private Builder(org.hifly.kafka.demo.avro.references.CarInfo other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.model)) {
        this.model = data().deepCopy(fields()[0].schema(), other.model);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.brand)) {
        this.brand = data().deepCopy(fields()[1].schema(), other.brand);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'model' field.
      * @return The value.
      */
    public java.lang.CharSequence getModel() {
      return model;
    }


    /**
      * Sets the value of the 'model' field.
      * @param value The value of 'model'.
      * @return This builder.
      */
    public org.hifly.kafka.demo.avro.references.CarInfo.Builder setModel(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.model = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'model' field has been set.
      * @return True if the 'model' field has been set, false otherwise.
      */
    public boolean hasModel() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'model' field.
      * @return This builder.
      */
    public org.hifly.kafka.demo.avro.references.CarInfo.Builder clearModel() {
      model = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'brand' field.
      * @return The value.
      */
    public java.lang.CharSequence getBrand() {
      return brand;
    }


    /**
      * Sets the value of the 'brand' field.
      * @param value The value of 'brand'.
      * @return This builder.
      */
    public org.hifly.kafka.demo.avro.references.CarInfo.Builder setBrand(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.brand = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'brand' field has been set.
      * @return True if the 'brand' field has been set, false otherwise.
      */
    public boolean hasBrand() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'brand' field.
      * @return This builder.
      */
    public org.hifly.kafka.demo.avro.references.CarInfo.Builder clearBrand() {
      brand = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CarInfo build() {
      try {
        CarInfo record = new CarInfo();
        record.model = fieldSetFlags()[0] ? this.model : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.brand = fieldSetFlags()[1] ? this.brand : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CarInfo>
    WRITER$ = (org.apache.avro.io.DatumWriter<CarInfo>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CarInfo>
    READER$ = (org.apache.avro.io.DatumReader<CarInfo>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.model);

    out.writeString(this.brand);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.model = in.readString(this.model instanceof Utf8 ? (Utf8)this.model : null);

      this.brand = in.readString(this.brand instanceof Utf8 ? (Utf8)this.brand : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.model = in.readString(this.model instanceof Utf8 ? (Utf8)this.model : null);
          break;

        case 1:
          this.brand = in.readString(this.brand instanceof Utf8 ? (Utf8)this.brand : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










