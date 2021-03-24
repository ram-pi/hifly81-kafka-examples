/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.hifly.saga.payment.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderAction extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2096385958159897722L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderAction\",\"namespace\":\"org.hifly.saga.payment.model\",\"fields\":[{\"name\":\"TX_ID\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"TX_ACTION\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"ACCOUNT\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"ITEMS\",\"type\":[\"null\",{\"type\":\"array\",\"items\":[\"null\",\"string\"]}],\"default\":null},{\"name\":\"ORDER\",\"type\":[\"null\",\"string\"],\"default\":null}],\"connect.name\":\"org.hifly.saga.payment.model.OrderAction\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderAction> ENCODER =
      new BinaryMessageEncoder<OrderAction>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderAction> DECODER =
      new BinaryMessageDecoder<OrderAction>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderAction> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderAction> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderAction> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderAction>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderAction to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderAction from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderAction instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderAction fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence TX_ID;
  @Deprecated public java.lang.Integer TX_ACTION;
  @Deprecated public java.lang.CharSequence ACCOUNT;
  @Deprecated public java.util.List<java.lang.CharSequence> ITEMS;
  @Deprecated public java.lang.CharSequence ORDER;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderAction() {}

  /**
   * All-args constructor.
   * @param TX_ID The new value for TX_ID
   * @param TX_ACTION The new value for TX_ACTION
   * @param ACCOUNT The new value for ACCOUNT
   * @param ITEMS The new value for ITEMS
   * @param ORDER The new value for ORDER
   */
  public OrderAction(java.lang.CharSequence TX_ID, java.lang.Integer TX_ACTION, java.lang.CharSequence ACCOUNT, java.util.List<java.lang.CharSequence> ITEMS, java.lang.CharSequence ORDER) {
    this.TX_ID = TX_ID;
    this.TX_ACTION = TX_ACTION;
    this.ACCOUNT = ACCOUNT;
    this.ITEMS = ITEMS;
    this.ORDER = ORDER;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return TX_ID;
    case 1: return TX_ACTION;
    case 2: return ACCOUNT;
    case 3: return ITEMS;
    case 4: return ORDER;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: TX_ID = (java.lang.CharSequence)value$; break;
    case 1: TX_ACTION = (java.lang.Integer)value$; break;
    case 2: ACCOUNT = (java.lang.CharSequence)value$; break;
    case 3: ITEMS = (java.util.List<java.lang.CharSequence>)value$; break;
    case 4: ORDER = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'TX_ID' field.
   * @return The value of the 'TX_ID' field.
   */
  public java.lang.CharSequence getTXID() {
    return TX_ID;
  }


  /**
   * Sets the value of the 'TX_ID' field.
   * @param value the value to set.
   */
  public void setTXID(java.lang.CharSequence value) {
    this.TX_ID = value;
  }

  /**
   * Gets the value of the 'TX_ACTION' field.
   * @return The value of the 'TX_ACTION' field.
   */
  public java.lang.Integer getTXACTION() {
    return TX_ACTION;
  }


  /**
   * Sets the value of the 'TX_ACTION' field.
   * @param value the value to set.
   */
  public void setTXACTION(java.lang.Integer value) {
    this.TX_ACTION = value;
  }

  /**
   * Gets the value of the 'ACCOUNT' field.
   * @return The value of the 'ACCOUNT' field.
   */
  public java.lang.CharSequence getACCOUNT() {
    return ACCOUNT;
  }


  /**
   * Sets the value of the 'ACCOUNT' field.
   * @param value the value to set.
   */
  public void setACCOUNT(java.lang.CharSequence value) {
    this.ACCOUNT = value;
  }

  /**
   * Gets the value of the 'ITEMS' field.
   * @return The value of the 'ITEMS' field.
   */
  public java.util.List<java.lang.CharSequence> getITEMS() {
    return ITEMS;
  }


  /**
   * Sets the value of the 'ITEMS' field.
   * @param value the value to set.
   */
  public void setITEMS(java.util.List<java.lang.CharSequence> value) {
    this.ITEMS = value;
  }

  /**
   * Gets the value of the 'ORDER' field.
   * @return The value of the 'ORDER' field.
   */
  public java.lang.CharSequence getORDER() {
    return ORDER;
  }


  /**
   * Sets the value of the 'ORDER' field.
   * @param value the value to set.
   */
  public void setORDER(java.lang.CharSequence value) {
    this.ORDER = value;
  }

  /**
   * Creates a new OrderAction RecordBuilder.
   * @return A new OrderAction RecordBuilder
   */
  public static org.hifly.saga.payment.model.OrderAction.Builder newBuilder() {
    return new org.hifly.saga.payment.model.OrderAction.Builder();
  }

  /**
   * Creates a new OrderAction RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderAction RecordBuilder
   */
  public static org.hifly.saga.payment.model.OrderAction.Builder newBuilder(org.hifly.saga.payment.model.OrderAction.Builder other) {
    if (other == null) {
      return new org.hifly.saga.payment.model.OrderAction.Builder();
    } else {
      return new org.hifly.saga.payment.model.OrderAction.Builder(other);
    }
  }

  /**
   * Creates a new OrderAction RecordBuilder by copying an existing OrderAction instance.
   * @param other The existing instance to copy.
   * @return A new OrderAction RecordBuilder
   */
  public static org.hifly.saga.payment.model.OrderAction.Builder newBuilder(org.hifly.saga.payment.model.OrderAction other) {
    if (other == null) {
      return new org.hifly.saga.payment.model.OrderAction.Builder();
    } else {
      return new org.hifly.saga.payment.model.OrderAction.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderAction instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderAction>
    implements org.apache.avro.data.RecordBuilder<OrderAction> {

    private java.lang.CharSequence TX_ID;
    private java.lang.Integer TX_ACTION;
    private java.lang.CharSequence ACCOUNT;
    private java.util.List<java.lang.CharSequence> ITEMS;
    private java.lang.CharSequence ORDER;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.hifly.saga.payment.model.OrderAction.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.TX_ID)) {
        this.TX_ID = data().deepCopy(fields()[0].schema(), other.TX_ID);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.TX_ACTION)) {
        this.TX_ACTION = data().deepCopy(fields()[1].schema(), other.TX_ACTION);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.ACCOUNT)) {
        this.ACCOUNT = data().deepCopy(fields()[2].schema(), other.ACCOUNT);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.ITEMS)) {
        this.ITEMS = data().deepCopy(fields()[3].schema(), other.ITEMS);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ORDER)) {
        this.ORDER = data().deepCopy(fields()[4].schema(), other.ORDER);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderAction instance
     * @param other The existing instance to copy.
     */
    private Builder(org.hifly.saga.payment.model.OrderAction other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.TX_ID)) {
        this.TX_ID = data().deepCopy(fields()[0].schema(), other.TX_ID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.TX_ACTION)) {
        this.TX_ACTION = data().deepCopy(fields()[1].schema(), other.TX_ACTION);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.ACCOUNT)) {
        this.ACCOUNT = data().deepCopy(fields()[2].schema(), other.ACCOUNT);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ITEMS)) {
        this.ITEMS = data().deepCopy(fields()[3].schema(), other.ITEMS);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ORDER)) {
        this.ORDER = data().deepCopy(fields()[4].schema(), other.ORDER);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'TX_ID' field.
      * @return The value.
      */
    public java.lang.CharSequence getTXID() {
      return TX_ID;
    }


    /**
      * Sets the value of the 'TX_ID' field.
      * @param value The value of 'TX_ID'.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder setTXID(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.TX_ID = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'TX_ID' field has been set.
      * @return True if the 'TX_ID' field has been set, false otherwise.
      */
    public boolean hasTXID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'TX_ID' field.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder clearTXID() {
      TX_ID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'TX_ACTION' field.
      * @return The value.
      */
    public java.lang.Integer getTXACTION() {
      return TX_ACTION;
    }


    /**
      * Sets the value of the 'TX_ACTION' field.
      * @param value The value of 'TX_ACTION'.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder setTXACTION(java.lang.Integer value) {
      validate(fields()[1], value);
      this.TX_ACTION = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'TX_ACTION' field has been set.
      * @return True if the 'TX_ACTION' field has been set, false otherwise.
      */
    public boolean hasTXACTION() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'TX_ACTION' field.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder clearTXACTION() {
      TX_ACTION = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'ACCOUNT' field.
      * @return The value.
      */
    public java.lang.CharSequence getACCOUNT() {
      return ACCOUNT;
    }


    /**
      * Sets the value of the 'ACCOUNT' field.
      * @param value The value of 'ACCOUNT'.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder setACCOUNT(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.ACCOUNT = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'ACCOUNT' field has been set.
      * @return True if the 'ACCOUNT' field has been set, false otherwise.
      */
    public boolean hasACCOUNT() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'ACCOUNT' field.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder clearACCOUNT() {
      ACCOUNT = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'ITEMS' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getITEMS() {
      return ITEMS;
    }


    /**
      * Sets the value of the 'ITEMS' field.
      * @param value The value of 'ITEMS'.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder setITEMS(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[3], value);
      this.ITEMS = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'ITEMS' field has been set.
      * @return True if the 'ITEMS' field has been set, false otherwise.
      */
    public boolean hasITEMS() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'ITEMS' field.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder clearITEMS() {
      ITEMS = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ORDER' field.
      * @return The value.
      */
    public java.lang.CharSequence getORDER() {
      return ORDER;
    }


    /**
      * Sets the value of the 'ORDER' field.
      * @param value The value of 'ORDER'.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder setORDER(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.ORDER = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ORDER' field has been set.
      * @return True if the 'ORDER' field has been set, false otherwise.
      */
    public boolean hasORDER() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ORDER' field.
      * @return This builder.
      */
    public org.hifly.saga.payment.model.OrderAction.Builder clearORDER() {
      ORDER = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderAction build() {
      try {
        OrderAction record = new OrderAction();
        record.TX_ID = fieldSetFlags()[0] ? this.TX_ID : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.TX_ACTION = fieldSetFlags()[1] ? this.TX_ACTION : (java.lang.Integer) defaultValue(fields()[1]);
        record.ACCOUNT = fieldSetFlags()[2] ? this.ACCOUNT : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.ITEMS = fieldSetFlags()[3] ? this.ITEMS : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[3]);
        record.ORDER = fieldSetFlags()[4] ? this.ORDER : (java.lang.CharSequence) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderAction>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderAction>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderAction>
    READER$ = (org.apache.avro.io.DatumReader<OrderAction>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.TX_ID == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.TX_ID);
    }

    if (this.TX_ACTION == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeInt(this.TX_ACTION);
    }

    if (this.ACCOUNT == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.ACCOUNT);
    }

    if (this.ITEMS == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.ITEMS.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (java.lang.CharSequence e0: this.ITEMS) {
        actualSize0++;
        out.startItem();
        if (e0 == null) {
          out.writeIndex(0);
          out.writeNull();
        } else {
          out.writeIndex(1);
          out.writeString(e0);
        }
      }
      out.writeArrayEnd();
      if (actualSize0 != size0)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");
    }

    if (this.ORDER == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.ORDER);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.TX_ID = null;
      } else {
        this.TX_ID = in.readString(this.TX_ID instanceof Utf8 ? (Utf8)this.TX_ID : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.TX_ACTION = null;
      } else {
        this.TX_ACTION = in.readInt();
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ACCOUNT = null;
      } else {
        this.ACCOUNT = in.readString(this.ACCOUNT instanceof Utf8 ? (Utf8)this.ACCOUNT : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ITEMS = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<java.lang.CharSequence> a0 = this.ITEMS;
        if (a0 == null) {
          a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("ITEMS").schema().getTypes().get(1));
          this.ITEMS = a0;
        } else a0.clear();
        SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
            if (in.readIndex() != 1) {
              in.readNull();
              e0 = null;
            } else {
              e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
            }
            a0.add(e0);
          }
        }
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.ORDER = null;
      } else {
        this.ORDER = in.readString(this.ORDER instanceof Utf8 ? (Utf8)this.ORDER : null);
      }

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.TX_ID = null;
          } else {
            this.TX_ID = in.readString(this.TX_ID instanceof Utf8 ? (Utf8)this.TX_ID : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.TX_ACTION = null;
          } else {
            this.TX_ACTION = in.readInt();
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ACCOUNT = null;
          } else {
            this.ACCOUNT = in.readString(this.ACCOUNT instanceof Utf8 ? (Utf8)this.ACCOUNT : null);
          }
          break;

        case 3:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ITEMS = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<java.lang.CharSequence> a0 = this.ITEMS;
            if (a0 == null) {
              a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("ITEMS").schema().getTypes().get(1));
              this.ITEMS = a0;
            } else a0.clear();
            SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
                if (in.readIndex() != 1) {
                  in.readNull();
                  e0 = null;
                } else {
                  e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
                }
                a0.add(e0);
              }
            }
          }
          break;

        case 4:
          if (in.readIndex() != 1) {
            in.readNull();
            this.ORDER = null;
          } else {
            this.ORDER = in.readString(this.ORDER instanceof Utf8 ? (Utf8)this.ORDER : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










