// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * Protobuf enum {@code data.ClickPathEventType}
 */
public enum ClickPathEventType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>CPET_NOT_SET = 0;</code>
   */
  CPET_NOT_SET(0),
  /**
   * <code>CPET_WINDOW = 1;</code>
   */
  CPET_WINDOW(1),
  /**
   * <code>CPET_CLICK = 2;</code>
   */
  CPET_CLICK(2),
  /**
   * <code>CPET_VALUE = 3;</code>
   */
  CPET_VALUE(3),
  /**
   * <code>CPET_PAGE = 4;</code>
   */
  CPET_PAGE(4),
  /**
   * <code>CPET_URL = 5;</code>
   */
  CPET_URL(5),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>CPET_NOT_SET = 0;</code>
   */
  public static final int CPET_NOT_SET_VALUE = 0;
  /**
   * <code>CPET_WINDOW = 1;</code>
   */
  public static final int CPET_WINDOW_VALUE = 1;
  /**
   * <code>CPET_CLICK = 2;</code>
   */
  public static final int CPET_CLICK_VALUE = 2;
  /**
   * <code>CPET_VALUE = 3;</code>
   */
  public static final int CPET_VALUE_VALUE = 3;
  /**
   * <code>CPET_PAGE = 4;</code>
   */
  public static final int CPET_PAGE_VALUE = 4;
  /**
   * <code>CPET_URL = 5;</code>
   */
  public static final int CPET_URL_VALUE = 5;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static ClickPathEventType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ClickPathEventType forNumber(int value) {
    switch (value) {
      case 0: return CPET_NOT_SET;
      case 1: return CPET_WINDOW;
      case 2: return CPET_CLICK;
      case 3: return CPET_VALUE;
      case 4: return CPET_PAGE;
      case 5: return CPET_URL;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ClickPathEventType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ClickPathEventType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ClickPathEventType>() {
          public ClickPathEventType findValueByNumber(int number) {
            return ClickPathEventType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return eu.tsystems.mms.tic.testframework.report.model.Framework.getDescriptor().getEnumTypes().get(0);
  }

  private static final ClickPathEventType[] VALUES = values();

  public static ClickPathEventType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private ClickPathEventType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:data.ClickPathEventType)
}

