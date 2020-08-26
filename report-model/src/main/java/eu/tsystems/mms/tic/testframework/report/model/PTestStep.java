// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf type {@code data.PTestStep}
 */
public  final class PTestStep extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:data.PTestStep)
    PTestStepOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PTestStep.newBuilder() to construct.
  private PTestStep(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PTestStep() {
    name_ = "";
    id_ = "";
    testStepActions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PTestStep();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PTestStep(
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
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              testStepActions_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction>();
              mutable_bitField0_ |= 0x00000001;
            }
            testStepActions_.add(
                input.readMessage(eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.parser(), extensionRegistry));
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
        testStepActions_ = java.util.Collections.unmodifiableList(testStepActions_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_PTestStep_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_PTestStep_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            eu.tsystems.mms.tic.testframework.report.model.PTestStep.class, eu.tsystems.mms.tic.testframework.report.model.PTestStep.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 2;</code>
   * @return The id.
   */
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 2;</code>
   * @return The bytes for id.
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TEST_STEP_ACTIONS_FIELD_NUMBER = 3;
  private java.util.List<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction> testStepActions_;
  /**
   * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
   */
  public java.util.List<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction> getTestStepActionsList() {
    return testStepActions_;
  }
  /**
   * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
   */
  public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder> 
      getTestStepActionsOrBuilderList() {
    return testStepActions_;
  }
  /**
   * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
   */
  public int getTestStepActionsCount() {
    return testStepActions_.size();
  }
  /**
   * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.PTestStepAction getTestStepActions(int index) {
    return testStepActions_.get(index);
  }
  /**
   * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder getTestStepActionsOrBuilder(
      int index) {
    return testStepActions_.get(index);
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
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, id_);
    }
    for (int i = 0; i < testStepActions_.size(); i++) {
      output.writeMessage(3, testStepActions_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, id_);
    }
    for (int i = 0; i < testStepActions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, testStepActions_.get(i));
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
    if (!(obj instanceof eu.tsystems.mms.tic.testframework.report.model.PTestStep)) {
      return super.equals(obj);
    }
    eu.tsystems.mms.tic.testframework.report.model.PTestStep other = (eu.tsystems.mms.tic.testframework.report.model.PTestStep) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (!getTestStepActionsList()
        .equals(other.getTestStepActionsList())) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    if (getTestStepActionsCount() > 0) {
      hash = (37 * hash) + TEST_STEP_ACTIONS_FIELD_NUMBER;
      hash = (53 * hash) + getTestStepActionsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep parseFrom(
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
  public static Builder newBuilder(eu.tsystems.mms.tic.testframework.report.model.PTestStep prototype) {
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
   * Protobuf type {@code data.PTestStep}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:data.PTestStep)
      eu.tsystems.mms.tic.testframework.report.model.PTestStepOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_PTestStep_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_PTestStep_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              eu.tsystems.mms.tic.testframework.report.model.PTestStep.class, eu.tsystems.mms.tic.testframework.report.model.PTestStep.Builder.class);
    }

    // Construct using eu.tsystems.mms.tic.testframework.report.model.PTestStep.newBuilder()
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
        getTestStepActionsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      name_ = "";

      id_ = "";

      if (testStepActionsBuilder_ == null) {
        testStepActions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        testStepActionsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_PTestStep_descriptor;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.PTestStep getDefaultInstanceForType() {
      return eu.tsystems.mms.tic.testframework.report.model.PTestStep.getDefaultInstance();
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.PTestStep build() {
      eu.tsystems.mms.tic.testframework.report.model.PTestStep result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.PTestStep buildPartial() {
      eu.tsystems.mms.tic.testframework.report.model.PTestStep result = new eu.tsystems.mms.tic.testframework.report.model.PTestStep(this);
      int from_bitField0_ = bitField0_;
      result.name_ = name_;
      result.id_ = id_;
      if (testStepActionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          testStepActions_ = java.util.Collections.unmodifiableList(testStepActions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.testStepActions_ = testStepActions_;
      } else {
        result.testStepActions_ = testStepActionsBuilder_.build();
      }
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
      if (other instanceof eu.tsystems.mms.tic.testframework.report.model.PTestStep) {
        return mergeFrom((eu.tsystems.mms.tic.testframework.report.model.PTestStep)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(eu.tsystems.mms.tic.testframework.report.model.PTestStep other) {
      if (other == eu.tsystems.mms.tic.testframework.report.model.PTestStep.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (testStepActionsBuilder_ == null) {
        if (!other.testStepActions_.isEmpty()) {
          if (testStepActions_.isEmpty()) {
            testStepActions_ = other.testStepActions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTestStepActionsIsMutable();
            testStepActions_.addAll(other.testStepActions_);
          }
          onChanged();
        }
      } else {
        if (!other.testStepActions_.isEmpty()) {
          if (testStepActionsBuilder_.isEmpty()) {
            testStepActionsBuilder_.dispose();
            testStepActionsBuilder_ = null;
            testStepActions_ = other.testStepActions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            testStepActionsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTestStepActionsFieldBuilder() : null;
          } else {
            testStepActionsBuilder_.addAllMessages(other.testStepActions_);
          }
        }
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
      eu.tsystems.mms.tic.testframework.report.model.PTestStep parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (eu.tsystems.mms.tic.testframework.report.model.PTestStep) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 2;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
     * @param value The bytes for id to set.
     * @return This builder for chaining.
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private java.util.List<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction> testStepActions_ =
      java.util.Collections.emptyList();
    private void ensureTestStepActionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        testStepActions_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction>(testStepActions_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.PTestStepAction, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder, eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder> testStepActionsBuilder_;

    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction> getTestStepActionsList() {
      if (testStepActionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(testStepActions_);
      } else {
        return testStepActionsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public int getTestStepActionsCount() {
      if (testStepActionsBuilder_ == null) {
        return testStepActions_.size();
      } else {
        return testStepActionsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.PTestStepAction getTestStepActions(int index) {
      if (testStepActionsBuilder_ == null) {
        return testStepActions_.get(index);
      } else {
        return testStepActionsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder setTestStepActions(
        int index, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction value) {
      if (testStepActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTestStepActionsIsMutable();
        testStepActions_.set(index, value);
        onChanged();
      } else {
        testStepActionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder setTestStepActions(
        int index, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder builderForValue) {
      if (testStepActionsBuilder_ == null) {
        ensureTestStepActionsIsMutable();
        testStepActions_.set(index, builderForValue.build());
        onChanged();
      } else {
        testStepActionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder addTestStepActions(eu.tsystems.mms.tic.testframework.report.model.PTestStepAction value) {
      if (testStepActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTestStepActionsIsMutable();
        testStepActions_.add(value);
        onChanged();
      } else {
        testStepActionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder addTestStepActions(
        int index, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction value) {
      if (testStepActionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTestStepActionsIsMutable();
        testStepActions_.add(index, value);
        onChanged();
      } else {
        testStepActionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder addTestStepActions(
        eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder builderForValue) {
      if (testStepActionsBuilder_ == null) {
        ensureTestStepActionsIsMutable();
        testStepActions_.add(builderForValue.build());
        onChanged();
      } else {
        testStepActionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder addTestStepActions(
        int index, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder builderForValue) {
      if (testStepActionsBuilder_ == null) {
        ensureTestStepActionsIsMutable();
        testStepActions_.add(index, builderForValue.build());
        onChanged();
      } else {
        testStepActionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder addAllTestStepActions(
        java.lang.Iterable<? extends eu.tsystems.mms.tic.testframework.report.model.PTestStepAction> values) {
      if (testStepActionsBuilder_ == null) {
        ensureTestStepActionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, testStepActions_);
        onChanged();
      } else {
        testStepActionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder clearTestStepActions() {
      if (testStepActionsBuilder_ == null) {
        testStepActions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        testStepActionsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public Builder removeTestStepActions(int index) {
      if (testStepActionsBuilder_ == null) {
        ensureTestStepActionsIsMutable();
        testStepActions_.remove(index);
        onChanged();
      } else {
        testStepActionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder getTestStepActionsBuilder(
        int index) {
      return getTestStepActionsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder getTestStepActionsOrBuilder(
        int index) {
      if (testStepActionsBuilder_ == null) {
        return testStepActions_.get(index);  } else {
        return testStepActionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder> 
         getTestStepActionsOrBuilderList() {
      if (testStepActionsBuilder_ != null) {
        return testStepActionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(testStepActions_);
      }
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder addTestStepActionsBuilder() {
      return getTestStepActionsFieldBuilder().addBuilder(
          eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.getDefaultInstance());
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder addTestStepActionsBuilder(
        int index) {
      return getTestStepActionsFieldBuilder().addBuilder(
          index, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.getDefaultInstance());
    }
    /**
     * <code>repeated .data.PTestStepAction test_step_actions = 3;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder> 
         getTestStepActionsBuilderList() {
      return getTestStepActionsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.PTestStepAction, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder, eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder> 
        getTestStepActionsFieldBuilder() {
      if (testStepActionsBuilder_ == null) {
        testStepActionsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            eu.tsystems.mms.tic.testframework.report.model.PTestStepAction, eu.tsystems.mms.tic.testframework.report.model.PTestStepAction.Builder, eu.tsystems.mms.tic.testframework.report.model.PTestStepActionOrBuilder>(
                testStepActions_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        testStepActions_ = null;
      }
      return testStepActionsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:data.PTestStep)
  }

  // @@protoc_insertion_point(class_scope:data.PTestStep)
  private static final eu.tsystems.mms.tic.testframework.report.model.PTestStep DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new eu.tsystems.mms.tic.testframework.report.model.PTestStep();
  }

  public static eu.tsystems.mms.tic.testframework.report.model.PTestStep getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PTestStep>
      PARSER = new com.google.protobuf.AbstractParser<PTestStep>() {
    @java.lang.Override
    public PTestStep parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PTestStep(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PTestStep> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PTestStep> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.PTestStep getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

