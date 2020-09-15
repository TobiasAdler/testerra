// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

public interface ErrorContextOrBuilder extends
    // @@protoc_insertion_point(interface_extends:data.ErrorContext)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string readable_error_message = 1;</code>
   * @return The readableErrorMessage.
   */
  java.lang.String getReadableErrorMessage();
  /**
   * <code>string readable_error_message = 1;</code>
   * @return The bytes for readableErrorMessage.
   */
  com.google.protobuf.ByteString
      getReadableErrorMessageBytes();

  /**
   * <code>string additional_error_message = 2;</code>
   * @return The additionalErrorMessage.
   */
  java.lang.String getAdditionalErrorMessage();
  /**
   * <code>string additional_error_message = 2;</code>
   * @return The bytes for additionalErrorMessage.
   */
  com.google.protobuf.ByteString
      getAdditionalErrorMessageBytes();

  /**
   * <code>.data.StackTrace stack_trace = 3;</code>
   * @return Whether the stackTrace field is set.
   */
  boolean hasStackTrace();
  /**
   * <code>.data.StackTrace stack_trace = 3;</code>
   * @return The stackTrace.
   */
  eu.tsystems.mms.tic.testframework.report.model.StackTrace getStackTrace();
  /**
   * <code>.data.StackTrace stack_trace = 3;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.StackTraceOrBuilder getStackTraceOrBuilder();

  /**
   * <code>string error_fingerprint = 6;</code>
   * @return The errorFingerprint.
   */
  java.lang.String getErrorFingerprint();
  /**
   * <code>string error_fingerprint = 6;</code>
   * @return The bytes for errorFingerprint.
   */
  com.google.protobuf.ByteString
      getErrorFingerprintBytes();

  /**
   * <code>.data.ScriptSource script_source = 7;</code>
   * @return Whether the scriptSource field is set.
   */
  boolean hasScriptSource();
  /**
   * <code>.data.ScriptSource script_source = 7;</code>
   * @return The scriptSource.
   */
  eu.tsystems.mms.tic.testframework.report.model.ScriptSource getScriptSource();
  /**
   * <code>.data.ScriptSource script_source = 7;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ScriptSourceOrBuilder getScriptSourceOrBuilder();

  /**
   * <code>.data.ScriptSource execution_object_source = 8;</code>
   * @return Whether the executionObjectSource field is set.
   */
  boolean hasExecutionObjectSource();
  /**
   * <code>.data.ScriptSource execution_object_source = 8;</code>
   * @return The executionObjectSource.
   */
  eu.tsystems.mms.tic.testframework.report.model.ScriptSource getExecutionObjectSource();
  /**
   * <code>.data.ScriptSource execution_object_source = 8;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ScriptSourceOrBuilder getExecutionObjectSourceOrBuilder();
}