// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

/**
 * <pre>
 * All status elements for run and job executions
 * </pre>
 *
 * Protobuf enum {@code data.ExecStatusType}
 */
public enum ExecStatusType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>EST_NOT_SET = 0;</code>
   */
  EST_NOT_SET(0),
  /**
   * <pre>
   * Execution is new and hasn't been processed from any agent
   * </pre>
   *
   * <code>NEW = 1;</code>
   */
  NEW(1),
  /**
   * <pre>
   * Execution has been seen by the scheduler and is in waiting position for an executer
   * </pre>
   *
   * <code>PENDING = 2;</code>
   */
  PENDING(2),
  /**
   * <pre>
   * The scheduler tries to start a Kube container execution
   * </pre>
   *
   * <code>PROVISIONING = 3;</code>
   */
  PROVISIONING(3),
  /**
   * <pre>
   * Execution is currently being run by the executer
   * </pre>
   *
   * <code>RUNNING = 4;</code>
   */
  RUNNING(4),
  /**
   * <pre>
   * Execution has been finished, which is: run to completion by the executer
   * </pre>
   *
   * <code>FINISHED = 5;</code>
   */
  FINISHED(5),
  /**
   * <pre>
   * Execution has been shutdown graceful or manually or has never been executed
   * </pre>
   *
   * <code>ABORTED = 6;</code>
   */
  ABORTED(6),
  /**
   * <pre>
   * Execution ended abruptly due to system error, runtime exceptions, kernel bugs, etc.
   * </pre>
   *
   * <code>CRASHED = 7;</code>
   */
  CRASHED(7),
  /**
   * <pre>
   * Execution of tests didn't start due to failed prerequisite steps (git clone) or executed command didn't start any (no execution context exists for invalid run)
   * </pre>
   *
   * <code>INVALID = 8;</code>
   */
  INVALID(8),
  /**
   * <pre>
   * Execution of tests started but no new tests were executed (all tests were skipped, or the execution filter didn't match any (all methods were INHERITED))
   * </pre>
   *
   * <code>VOID = 9;</code>
   */
  VOID(9),
  /**
   * <pre>
   * Execution of tests is finished and artifacts uploading is in progress
   * </pre>
   *
   * <code>ARTIFACT_UPLOAD = 10;</code>
   */
  ARTIFACT_UPLOAD(10),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>EST_NOT_SET = 0;</code>
   */
  public static final int EST_NOT_SET_VALUE = 0;
  /**
   * <pre>
   * Execution is new and hasn't been processed from any agent
   * </pre>
   *
   * <code>NEW = 1;</code>
   */
  public static final int NEW_VALUE = 1;
  /**
   * <pre>
   * Execution has been seen by the scheduler and is in waiting position for an executer
   * </pre>
   *
   * <code>PENDING = 2;</code>
   */
  public static final int PENDING_VALUE = 2;
  /**
   * <pre>
   * The scheduler tries to start a Kube container execution
   * </pre>
   *
   * <code>PROVISIONING = 3;</code>
   */
  public static final int PROVISIONING_VALUE = 3;
  /**
   * <pre>
   * Execution is currently being run by the executer
   * </pre>
   *
   * <code>RUNNING = 4;</code>
   */
  public static final int RUNNING_VALUE = 4;
  /**
   * <pre>
   * Execution has been finished, which is: run to completion by the executer
   * </pre>
   *
   * <code>FINISHED = 5;</code>
   */
  public static final int FINISHED_VALUE = 5;
  /**
   * <pre>
   * Execution has been shutdown graceful or manually or has never been executed
   * </pre>
   *
   * <code>ABORTED = 6;</code>
   */
  public static final int ABORTED_VALUE = 6;
  /**
   * <pre>
   * Execution ended abruptly due to system error, runtime exceptions, kernel bugs, etc.
   * </pre>
   *
   * <code>CRASHED = 7;</code>
   */
  public static final int CRASHED_VALUE = 7;
  /**
   * <pre>
   * Execution of tests didn't start due to failed prerequisite steps (git clone) or executed command didn't start any (no execution context exists for invalid run)
   * </pre>
   *
   * <code>INVALID = 8;</code>
   */
  public static final int INVALID_VALUE = 8;
  /**
   * <pre>
   * Execution of tests started but no new tests were executed (all tests were skipped, or the execution filter didn't match any (all methods were INHERITED))
   * </pre>
   *
   * <code>VOID = 9;</code>
   */
  public static final int VOID_VALUE = 9;
  /**
   * <pre>
   * Execution of tests is finished and artifacts uploading is in progress
   * </pre>
   *
   * <code>ARTIFACT_UPLOAD = 10;</code>
   */
  public static final int ARTIFACT_UPLOAD_VALUE = 10;


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
  public static ExecStatusType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static ExecStatusType forNumber(int value) {
    switch (value) {
      case 0: return EST_NOT_SET;
      case 1: return NEW;
      case 2: return PENDING;
      case 3: return PROVISIONING;
      case 4: return RUNNING;
      case 5: return FINISHED;
      case 6: return ABORTED;
      case 7: return CRASHED;
      case 8: return INVALID;
      case 9: return VOID;
      case 10: return ARTIFACT_UPLOAD;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<ExecStatusType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      ExecStatusType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ExecStatusType>() {
          public ExecStatusType findValueByNumber(int number) {
            return ExecStatusType.forNumber(number);
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
    return eu.tsystems.mms.tic.testframework.report.model.Framework.getDescriptor().getEnumTypes().get(4);
  }

  private static final ExecStatusType[] VALUES = values();

  public static ExecStatusType valueOf(
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

  private ExecStatusType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:data.ExecStatusType)
}

