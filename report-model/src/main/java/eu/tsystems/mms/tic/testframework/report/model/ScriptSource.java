// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf type {@code data.ScriptSource}
 */
public  final class ScriptSource extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:data.ScriptSource)
    ScriptSourceOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ScriptSource.newBuilder() to construct.
  private ScriptSource(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ScriptSource() {
    fileName_ = "";
    methodName_ = "";
    lines_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ScriptSource();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ScriptSource(
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

            fileName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            methodName_ = s;
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              lines_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine>();
              mutable_bitField0_ |= 0x00000001;
            }
            lines_.add(
                input.readMessage(eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.parser(), extensionRegistry));
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
        lines_ = java.util.Collections.unmodifiableList(lines_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_ScriptSource_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_ScriptSource_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            eu.tsystems.mms.tic.testframework.report.model.ScriptSource.class, eu.tsystems.mms.tic.testframework.report.model.ScriptSource.Builder.class);
  }

  public static final int FILE_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object fileName_;
  /**
   * <code>string file_name = 1;</code>
   * @return The fileName.
   */
  public java.lang.String getFileName() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fileName_ = s;
      return s;
    }
  }
  /**
   * <code>string file_name = 1;</code>
   * @return The bytes for fileName.
   */
  public com.google.protobuf.ByteString
      getFileNameBytes() {
    java.lang.Object ref = fileName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fileName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int METHOD_NAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object methodName_;
  /**
   * <code>string method_name = 2;</code>
   * @return The methodName.
   */
  public java.lang.String getMethodName() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      methodName_ = s;
      return s;
    }
  }
  /**
   * <code>string method_name = 2;</code>
   * @return The bytes for methodName.
   */
  public com.google.protobuf.ByteString
      getMethodNameBytes() {
    java.lang.Object ref = methodName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      methodName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LINES_FIELD_NUMBER = 3;
  private java.util.List<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine> lines_;
  /**
   * <code>repeated .data.ScriptSourceLine lines = 3;</code>
   */
  public java.util.List<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine> getLinesList() {
    return lines_;
  }
  /**
   * <code>repeated .data.ScriptSourceLine lines = 3;</code>
   */
  public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder> 
      getLinesOrBuilderList() {
    return lines_;
  }
  /**
   * <code>repeated .data.ScriptSourceLine lines = 3;</code>
   */
  public int getLinesCount() {
    return lines_.size();
  }
  /**
   * <code>repeated .data.ScriptSourceLine lines = 3;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine getLines(int index) {
    return lines_.get(index);
  }
  /**
   * <code>repeated .data.ScriptSourceLine lines = 3;</code>
   */
  public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder getLinesOrBuilder(
      int index) {
    return lines_.get(index);
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
    if (!getFileNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fileName_);
    }
    if (!getMethodNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, methodName_);
    }
    for (int i = 0; i < lines_.size(); i++) {
      output.writeMessage(3, lines_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getFileNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fileName_);
    }
    if (!getMethodNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, methodName_);
    }
    for (int i = 0; i < lines_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, lines_.get(i));
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
    if (!(obj instanceof eu.tsystems.mms.tic.testframework.report.model.ScriptSource)) {
      return super.equals(obj);
    }
    eu.tsystems.mms.tic.testframework.report.model.ScriptSource other = (eu.tsystems.mms.tic.testframework.report.model.ScriptSource) obj;

    if (!getFileName()
        .equals(other.getFileName())) return false;
    if (!getMethodName()
        .equals(other.getMethodName())) return false;
    if (!getLinesList()
        .equals(other.getLinesList())) return false;
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
    hash = (37 * hash) + FILE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getFileName().hashCode();
    hash = (37 * hash) + METHOD_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getMethodName().hashCode();
    if (getLinesCount() > 0) {
      hash = (37 * hash) + LINES_FIELD_NUMBER;
      hash = (53 * hash) + getLinesList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource parseFrom(
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
  public static Builder newBuilder(eu.tsystems.mms.tic.testframework.report.model.ScriptSource prototype) {
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
   * Protobuf type {@code data.ScriptSource}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:data.ScriptSource)
      eu.tsystems.mms.tic.testframework.report.model.ScriptSourceOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_ScriptSource_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_ScriptSource_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              eu.tsystems.mms.tic.testframework.report.model.ScriptSource.class, eu.tsystems.mms.tic.testframework.report.model.ScriptSource.Builder.class);
    }

    // Construct using eu.tsystems.mms.tic.testframework.report.model.ScriptSource.newBuilder()
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
        getLinesFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      fileName_ = "";

      methodName_ = "";

      if (linesBuilder_ == null) {
        lines_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        linesBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return eu.tsystems.mms.tic.testframework.report.model.Framework.internal_static_data_ScriptSource_descriptor;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSource getDefaultInstanceForType() {
      return eu.tsystems.mms.tic.testframework.report.model.ScriptSource.getDefaultInstance();
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSource build() {
      eu.tsystems.mms.tic.testframework.report.model.ScriptSource result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSource buildPartial() {
      eu.tsystems.mms.tic.testframework.report.model.ScriptSource result = new eu.tsystems.mms.tic.testframework.report.model.ScriptSource(this);
      int from_bitField0_ = bitField0_;
      result.fileName_ = fileName_;
      result.methodName_ = methodName_;
      if (linesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          lines_ = java.util.Collections.unmodifiableList(lines_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.lines_ = lines_;
      } else {
        result.lines_ = linesBuilder_.build();
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
      if (other instanceof eu.tsystems.mms.tic.testframework.report.model.ScriptSource) {
        return mergeFrom((eu.tsystems.mms.tic.testframework.report.model.ScriptSource)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(eu.tsystems.mms.tic.testframework.report.model.ScriptSource other) {
      if (other == eu.tsystems.mms.tic.testframework.report.model.ScriptSource.getDefaultInstance()) return this;
      if (!other.getFileName().isEmpty()) {
        fileName_ = other.fileName_;
        onChanged();
      }
      if (!other.getMethodName().isEmpty()) {
        methodName_ = other.methodName_;
        onChanged();
      }
      if (linesBuilder_ == null) {
        if (!other.lines_.isEmpty()) {
          if (lines_.isEmpty()) {
            lines_ = other.lines_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureLinesIsMutable();
            lines_.addAll(other.lines_);
          }
          onChanged();
        }
      } else {
        if (!other.lines_.isEmpty()) {
          if (linesBuilder_.isEmpty()) {
            linesBuilder_.dispose();
            linesBuilder_ = null;
            lines_ = other.lines_;
            bitField0_ = (bitField0_ & ~0x00000001);
            linesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getLinesFieldBuilder() : null;
          } else {
            linesBuilder_.addAllMessages(other.lines_);
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
      eu.tsystems.mms.tic.testframework.report.model.ScriptSource parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (eu.tsystems.mms.tic.testframework.report.model.ScriptSource) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object fileName_ = "";
    /**
     * <code>string file_name = 1;</code>
     * @return The fileName.
     */
    public java.lang.String getFileName() {
      java.lang.Object ref = fileName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fileName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string file_name = 1;</code>
     * @return The bytes for fileName.
     */
    public com.google.protobuf.ByteString
        getFileNameBytes() {
      java.lang.Object ref = fileName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fileName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string file_name = 1;</code>
     * @param value The fileName to set.
     * @return This builder for chaining.
     */
    public Builder setFileName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fileName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string file_name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFileName() {
      
      fileName_ = getDefaultInstance().getFileName();
      onChanged();
      return this;
    }
    /**
     * <code>string file_name = 1;</code>
     * @param value The bytes for fileName to set.
     * @return This builder for chaining.
     */
    public Builder setFileNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fileName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object methodName_ = "";
    /**
     * <code>string method_name = 2;</code>
     * @return The methodName.
     */
    public java.lang.String getMethodName() {
      java.lang.Object ref = methodName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        methodName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string method_name = 2;</code>
     * @return The bytes for methodName.
     */
    public com.google.protobuf.ByteString
        getMethodNameBytes() {
      java.lang.Object ref = methodName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        methodName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string method_name = 2;</code>
     * @param value The methodName to set.
     * @return This builder for chaining.
     */
    public Builder setMethodName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      methodName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string method_name = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMethodName() {
      
      methodName_ = getDefaultInstance().getMethodName();
      onChanged();
      return this;
    }
    /**
     * <code>string method_name = 2;</code>
     * @param value The bytes for methodName to set.
     * @return This builder for chaining.
     */
    public Builder setMethodNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      methodName_ = value;
      onChanged();
      return this;
    }

    private java.util.List<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine> lines_ =
      java.util.Collections.emptyList();
    private void ensureLinesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        lines_ = new java.util.ArrayList<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine>(lines_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder> linesBuilder_;

    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine> getLinesList() {
      if (linesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(lines_);
      } else {
        return linesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public int getLinesCount() {
      if (linesBuilder_ == null) {
        return lines_.size();
      } else {
        return linesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine getLines(int index) {
      if (linesBuilder_ == null) {
        return lines_.get(index);
      } else {
        return linesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder setLines(
        int index, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine value) {
      if (linesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinesIsMutable();
        lines_.set(index, value);
        onChanged();
      } else {
        linesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder setLines(
        int index, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder builderForValue) {
      if (linesBuilder_ == null) {
        ensureLinesIsMutable();
        lines_.set(index, builderForValue.build());
        onChanged();
      } else {
        linesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder addLines(eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine value) {
      if (linesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinesIsMutable();
        lines_.add(value);
        onChanged();
      } else {
        linesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder addLines(
        int index, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine value) {
      if (linesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureLinesIsMutable();
        lines_.add(index, value);
        onChanged();
      } else {
        linesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder addLines(
        eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder builderForValue) {
      if (linesBuilder_ == null) {
        ensureLinesIsMutable();
        lines_.add(builderForValue.build());
        onChanged();
      } else {
        linesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder addLines(
        int index, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder builderForValue) {
      if (linesBuilder_ == null) {
        ensureLinesIsMutable();
        lines_.add(index, builderForValue.build());
        onChanged();
      } else {
        linesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder addAllLines(
        java.lang.Iterable<? extends eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine> values) {
      if (linesBuilder_ == null) {
        ensureLinesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, lines_);
        onChanged();
      } else {
        linesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder clearLines() {
      if (linesBuilder_ == null) {
        lines_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        linesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public Builder removeLines(int index) {
      if (linesBuilder_ == null) {
        ensureLinesIsMutable();
        lines_.remove(index);
        onChanged();
      } else {
        linesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder getLinesBuilder(
        int index) {
      return getLinesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder getLinesOrBuilder(
        int index) {
      if (linesBuilder_ == null) {
        return lines_.get(index);  } else {
        return linesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder> 
         getLinesOrBuilderList() {
      if (linesBuilder_ != null) {
        return linesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(lines_);
      }
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder addLinesBuilder() {
      return getLinesFieldBuilder().addBuilder(
          eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.getDefaultInstance());
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder addLinesBuilder(
        int index) {
      return getLinesFieldBuilder().addBuilder(
          index, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.getDefaultInstance());
    }
    /**
     * <code>repeated .data.ScriptSourceLine lines = 3;</code>
     */
    public java.util.List<eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder> 
         getLinesBuilderList() {
      return getLinesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder> 
        getLinesFieldBuilder() {
      if (linesBuilder_ == null) {
        linesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLine.Builder, eu.tsystems.mms.tic.testframework.report.model.ScriptSourceLineOrBuilder>(
                lines_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        lines_ = null;
      }
      return linesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:data.ScriptSource)
  }

  // @@protoc_insertion_point(class_scope:data.ScriptSource)
  private static final eu.tsystems.mms.tic.testframework.report.model.ScriptSource DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new eu.tsystems.mms.tic.testframework.report.model.ScriptSource();
  }

  public static eu.tsystems.mms.tic.testframework.report.model.ScriptSource getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ScriptSource>
      PARSER = new com.google.protobuf.AbstractParser<ScriptSource>() {
    @java.lang.Override
    public ScriptSource parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ScriptSource(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ScriptSource> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ScriptSource> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public eu.tsystems.mms.tic.testframework.report.model.ScriptSource getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

