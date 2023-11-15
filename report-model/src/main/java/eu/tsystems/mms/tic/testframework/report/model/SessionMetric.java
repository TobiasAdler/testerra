// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf type {@code data.SessionMetric}
 */
public final class SessionMetric extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:data.SessionMetric)
    SessionMetricOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SessionMetric.newBuilder() to construct.
  private SessionMetric(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SessionMetric() {
    metricsValues_ = java.util.Collections.emptyList();
    sessionContextId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SessionMetric();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SessionMetric(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              metricsValues_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.MetricsValue>();
              mutable_bitField0_ |= 0x00000001;
            }
            metricsValues_.add(
                input.readMessage(eu.tsystems.mms.tic.testframework.report.model.MetricsValue.parser(), extensionRegistry));
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            sessionContextId_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        metricsValues_ = java.util.Collections.unmodifiableList(metricsValues_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_SessionMetric_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_SessionMetric_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            eu.tsystems.mms.tic.testframework.report.model.SessionMetric.class, eu.tsystems.mms.tic.testframework.report.model.SessionMetric.Builder.class);
  }

  public static final int METRICS_VALUES_FIELD_NUMBER = 1;
  private java.util.List<eu.tsystems.mms.tic.testframework.report.model.MetricsValue> metricsValues_;
  /**
   * <code>repeated .data.MetricsValue metrics_values = 1;</code>
   */
  @java.lang.Override
  public java.util.List<eu.tsystems.mms.tic.testframework.report.model.MetricsValue> getMetricsValuesList() {
    return metricsValues_;
  }
  /**
   * <code>repeated .data.MetricsValue metrics_values = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder> 
      getMetricsValuesOrBuilderList() {
    return metricsValues_;
  }
  /**
   * <code>repeated .data.MetricsValue metrics_values = 1;</code>
   */
  @java.lang.Override
  public int getMetricsValuesCount() {
    return metricsValues_.size();
  }
  /**
   * <code>repeated .data.MetricsValue metrics_values = 1;</code>
   */
  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.MetricsValue getMetricsValues(int index) {
    return metricsValues_.get(index);
  }
  /**
   * <code>repeated .data.MetricsValue metrics_values = 1;</code>
   */
  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder getMetricsValuesOrBuilder(
      int index) {
    return metricsValues_.get(index);
  }

  public static final int SESSION_CONTEXT_ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object sessionContextId_;
  /**
   * <code>string session_context_id = 2;</code>
   * @return The sessionContextId.
   */
  @java.lang.Override
  public java.lang.String getSessionContextId() {
    java.lang.Object ref = sessionContextId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      sessionContextId_ = s;
      return s;
    }
  }
  /**
   * <code>string session_context_id = 2;</code>
   * @return The bytes for sessionContextId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSessionContextIdBytes() {
    java.lang.Object ref = sessionContextId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      sessionContextId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < metricsValues_.size(); i++) {
      output.writeMessage(1, metricsValues_.get(i));
    }
    if (!getSessionContextIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, sessionContextId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < metricsValues_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, metricsValues_.get(i));
    }
    if (!getSessionContextIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, sessionContextId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof eu.tsystems.mms.tic.testframework.report.model.SessionMetric)) {
      return super.equals(obj);
    }
    eu.tsystems.mms.tic.testframework.report.model.SessionMetric other = (eu.tsystems.mms.tic.testframework.report.model.SessionMetric) obj;

    if (!getMetricsValuesList()
        .equals(other.getMetricsValuesList())) return false;
    if (!getSessionContextId()
        .equals(other.getSessionContextId())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMetricsValuesCount() > 0) {
      hash = (37 * hash) + METRICS_VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getMetricsValuesList().hashCode();
    }
    hash = (37 * hash) + SESSION_CONTEXT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSessionContextId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(eu.tsystems.mms.tic.testframework.report.model.SessionMetric prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code data.SessionMetric}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:data.SessionMetric)
      eu.tsystems.mms.tic.testframework.report.model.SessionMetricOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_SessionMetric_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_SessionMetric_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              eu.tsystems.mms.tic.testframework.report.model.SessionMetric.class, eu.tsystems.mms.tic.testframework.report.model.SessionMetric.Builder.class);
    }

    // Construct using eu.tsystems.mms.tic.testframework.report.model.SessionMetric.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getMetricsValuesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (metricsValuesBuilder_ == null) {
        metricsValues_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        metricsValuesBuilder_.clear();
      }
      sessionContextId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_SessionMetric_descriptor;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.SessionMetric getDefaultInstanceForType() {
      return eu.tsystems.mms.tic.testframework.report.model.SessionMetric.getDefaultInstance();
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.SessionMetric build() {
      eu.tsystems.mms.tic.testframework.report.model.SessionMetric result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.SessionMetric buildPartial() {
      eu.tsystems.mms.tic.testframework.report.model.SessionMetric result = new eu.tsystems.mms.tic.testframework.report.model.SessionMetric(this);
      int from_bitField0_ = bitField0_;
      if (metricsValuesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          metricsValues_ = java.util.Collections.unmodifiableList(metricsValues_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.metricsValues_ = metricsValues_;
      } else {
        result.metricsValues_ = metricsValuesBuilder_.build();
      }
      result.sessionContextId_ = sessionContextId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof eu.tsystems.mms.tic.testframework.report.model.SessionMetric) {
        return mergeFrom((eu.tsystems.mms.tic.testframework.report.model.SessionMetric)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(eu.tsystems.mms.tic.testframework.report.model.SessionMetric other) {
      if (other == eu.tsystems.mms.tic.testframework.report.model.SessionMetric.getDefaultInstance()) return this;
      if (metricsValuesBuilder_ == null) {
        if (!other.metricsValues_.isEmpty()) {
          if (metricsValues_.isEmpty()) {
            metricsValues_ = other.metricsValues_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMetricsValuesIsMutable();
            metricsValues_.addAll(other.metricsValues_);
          }
          onChanged();
        }
      } else {
        if (!other.metricsValues_.isEmpty()) {
          if (metricsValuesBuilder_.isEmpty()) {
            metricsValuesBuilder_.dispose();
            metricsValuesBuilder_ = null;
            metricsValues_ = other.metricsValues_;
            bitField0_ = (bitField0_ & ~0x00000001);
            metricsValuesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMetricsValuesFieldBuilder() : null;
          } else {
            metricsValuesBuilder_.addAllMessages(other.metricsValues_);
          }
        }
      }
      if (!other.getSessionContextId().isEmpty()) {
        sessionContextId_ = other.sessionContextId_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      eu.tsystems.mms.tic.testframework.report.model.SessionMetric parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (eu.tsystems.mms.tic.testframework.report.model.SessionMetric) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<eu.tsystems.mms.tic.testframework.report.model.MetricsValue> metricsValues_ =
      java.util.Collections.emptyList();
    private void ensureMetricsValuesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        metricsValues_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.MetricsValue>(metricsValues_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.MetricsValue, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder, eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder> metricsValuesBuilder_;

    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.MetricsValue> getMetricsValuesList() {
      if (metricsValuesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(metricsValues_);
      } else {
        return metricsValuesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public int getMetricsValuesCount() {
      if (metricsValuesBuilder_ == null) {
        return metricsValues_.size();
      } else {
        return metricsValuesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.MetricsValue getMetricsValues(int index) {
      if (metricsValuesBuilder_ == null) {
        return metricsValues_.get(index);
      } else {
        return metricsValuesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder setMetricsValues(
        int index, eu.tsystems.mms.tic.testframework.report.model.MetricsValue value) {
      if (metricsValuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetricsValuesIsMutable();
        metricsValues_.set(index, value);
        onChanged();
      } else {
        metricsValuesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder setMetricsValues(
        int index, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder builderForValue) {
      if (metricsValuesBuilder_ == null) {
        ensureMetricsValuesIsMutable();
        metricsValues_.set(index, builderForValue.build());
        onChanged();
      } else {
        metricsValuesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder addMetricsValues(eu.tsystems.mms.tic.testframework.report.model.MetricsValue value) {
      if (metricsValuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetricsValuesIsMutable();
        metricsValues_.add(value);
        onChanged();
      } else {
        metricsValuesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder addMetricsValues(
        int index, eu.tsystems.mms.tic.testframework.report.model.MetricsValue value) {
      if (metricsValuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMetricsValuesIsMutable();
        metricsValues_.add(index, value);
        onChanged();
      } else {
        metricsValuesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder addMetricsValues(
        eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder builderForValue) {
      if (metricsValuesBuilder_ == null) {
        ensureMetricsValuesIsMutable();
        metricsValues_.add(builderForValue.build());
        onChanged();
      } else {
        metricsValuesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder addMetricsValues(
        int index, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder builderForValue) {
      if (metricsValuesBuilder_ == null) {
        ensureMetricsValuesIsMutable();
        metricsValues_.add(index, builderForValue.build());
        onChanged();
      } else {
        metricsValuesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder addAllMetricsValues(
        java.lang.Iterable<? extends eu.tsystems.mms.tic.testframework.report.model.MetricsValue> values) {
      if (metricsValuesBuilder_ == null) {
        ensureMetricsValuesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, metricsValues_);
        onChanged();
      } else {
        metricsValuesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder clearMetricsValues() {
      if (metricsValuesBuilder_ == null) {
        metricsValues_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        metricsValuesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public Builder removeMetricsValues(int index) {
      if (metricsValuesBuilder_ == null) {
        ensureMetricsValuesIsMutable();
        metricsValues_.remove(index);
        onChanged();
      } else {
        metricsValuesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder getMetricsValuesBuilder(
        int index) {
      return getMetricsValuesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder getMetricsValuesOrBuilder(
        int index) {
      if (metricsValuesBuilder_ == null) {
        return metricsValues_.get(index);  } else {
        return metricsValuesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder> 
         getMetricsValuesOrBuilderList() {
      if (metricsValuesBuilder_ != null) {
        return metricsValuesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(metricsValues_);
      }
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder addMetricsValuesBuilder() {
      return getMetricsValuesFieldBuilder().addBuilder(
          eu.tsystems.mms.tic.testframework.report.model.MetricsValue.getDefaultInstance());
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder addMetricsValuesBuilder(
        int index) {
      return getMetricsValuesFieldBuilder().addBuilder(
          index, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.getDefaultInstance());
    }
    /**
     * <code>repeated .data.MetricsValue metrics_values = 1;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder> 
         getMetricsValuesBuilderList() {
      return getMetricsValuesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.MetricsValue, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder, eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder> 
        getMetricsValuesFieldBuilder() {
      if (metricsValuesBuilder_ == null) {
        metricsValuesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            eu.tsystems.mms.tic.testframework.report.model.MetricsValue, eu.tsystems.mms.tic.testframework.report.model.MetricsValue.Builder, eu.tsystems.mms.tic.testframework.report.model.MetricsValueOrBuilder>(
                metricsValues_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        metricsValues_ = null;
      }
      return metricsValuesBuilder_;
    }

    private java.lang.Object sessionContextId_ = "";
    /**
     * <code>string session_context_id = 2;</code>
     * @return The sessionContextId.
     */
    public java.lang.String getSessionContextId() {
      java.lang.Object ref = sessionContextId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sessionContextId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string session_context_id = 2;</code>
     * @return The bytes for sessionContextId.
     */
    public com.google.protobuf.ByteString
        getSessionContextIdBytes() {
      java.lang.Object ref = sessionContextId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sessionContextId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string session_context_id = 2;</code>
     * @param value The sessionContextId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionContextId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sessionContextId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string session_context_id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSessionContextId() {
      
      sessionContextId_ = getDefaultInstance().getSessionContextId();
      onChanged();
      return this;
    }
    /**
     * <code>string session_context_id = 2;</code>
     * @param value The bytes for sessionContextId to set.
     * @return This builder for chaining.
     */
    public Builder setSessionContextIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sessionContextId_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:data.SessionMetric)
  }

  // @@protoc_insertion_point(class_scope:data.SessionMetric)
  private static final eu.tsystems.mms.tic.testframework.report.model.SessionMetric DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new eu.tsystems.mms.tic.testframework.report.model.SessionMetric();
  }

  public static eu.tsystems.mms.tic.testframework.report.model.SessionMetric getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SessionMetric>
      PARSER = new com.google.protobuf.AbstractParser<SessionMetric>() {
    @java.lang.Override
    public SessionMetric parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SessionMetric(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SessionMetric> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SessionMetric> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.SessionMetric getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
