// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: framework.proto

package eu.tsystems.mms.tic.testframework.report.model;

public interface TestStepActionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:data.TestStepAction)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   *    string id = 2;
   * </pre>
   *
   * <code>int64 timestamp = 3;</code>
   * @return The timestamp.
   */
  long getTimestamp();

  /**
   * <pre>
   *    repeated string screenshot_names = 4 [deprecated = true];
   * </pre>
   *
   * <code>repeated .data.ClickPathEvent clickpath_events = 5;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.ClickPathEvent> 
      getClickpathEventsList();
  /**
   * <pre>
   *    repeated string screenshot_names = 4 [deprecated = true];
   * </pre>
   *
   * <code>repeated .data.ClickPathEvent clickpath_events = 5;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ClickPathEvent getClickpathEvents(int index);
  /**
   * <pre>
   *    repeated string screenshot_names = 4 [deprecated = true];
   * </pre>
   *
   * <code>repeated .data.ClickPathEvent clickpath_events = 5;</code>
   */
  int getClickpathEventsCount();
  /**
   * <pre>
   *    repeated string screenshot_names = 4 [deprecated = true];
   * </pre>
   *
   * <code>repeated .data.ClickPathEvent clickpath_events = 5;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.ClickPathEventOrBuilder> 
      getClickpathEventsOrBuilderList();
  /**
   * <pre>
   *    repeated string screenshot_names = 4 [deprecated = true];
   * </pre>
   *
   * <code>repeated .data.ClickPathEvent clickpath_events = 5;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ClickPathEventOrBuilder getClickpathEventsOrBuilder(
      int index);

  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @return A list containing the screenshotIds.
   */
  java.util.List<java.lang.String>
      getScreenshotIdsList();
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @return The count of screenshotIds.
   */
  int getScreenshotIdsCount();
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @param index The index of the element to return.
   * @return The screenshotIds at the given index.
   */
  java.lang.String getScreenshotIds(int index);
  /**
   * <code>repeated string screenshot_ids = 6;</code>
   * @param index The index of the value to return.
   * @return The bytes of the screenshotIds at the given index.
   */
  com.google.protobuf.ByteString
      getScreenshotIdsBytes(int index);

  /**
   * <code>repeated .data.LogMessage log_messages = 7;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.LogMessage> 
      getLogMessagesList();
  /**
   * <code>repeated .data.LogMessage log_messages = 7;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.LogMessage getLogMessages(int index);
  /**
   * <code>repeated .data.LogMessage log_messages = 7;</code>
   */
  int getLogMessagesCount();
  /**
   * <code>repeated .data.LogMessage log_messages = 7;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.LogMessageOrBuilder> 
      getLogMessagesOrBuilderList();
  /**
   * <code>repeated .data.LogMessage log_messages = 7;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.LogMessageOrBuilder getLogMessagesOrBuilder(
      int index);

  /**
   * <code>repeated .data.ErrorContext optional_assertions = 8;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.ErrorContext> 
      getOptionalAssertionsList();
  /**
   * <code>repeated .data.ErrorContext optional_assertions = 8;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ErrorContext getOptionalAssertions(int index);
  /**
   * <code>repeated .data.ErrorContext optional_assertions = 8;</code>
   */
  int getOptionalAssertionsCount();
  /**
   * <code>repeated .data.ErrorContext optional_assertions = 8;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.ErrorContextOrBuilder> 
      getOptionalAssertionsOrBuilderList();
  /**
   * <code>repeated .data.ErrorContext optional_assertions = 8;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ErrorContextOrBuilder getOptionalAssertionsOrBuilder(
      int index);

  /**
   * <code>repeated .data.ErrorContext collected_assertions = 9;</code>
   */
  java.util.List<eu.tsystems.mms.tic.testframework.report.model.ErrorContext> 
      getCollectedAssertionsList();
  /**
   * <code>repeated .data.ErrorContext collected_assertions = 9;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ErrorContext getCollectedAssertions(int index);
  /**
   * <code>repeated .data.ErrorContext collected_assertions = 9;</code>
   */
  int getCollectedAssertionsCount();
  /**
   * <code>repeated .data.ErrorContext collected_assertions = 9;</code>
   */
  java.util.List<? extends eu.tsystems.mms.tic.testframework.report.model.ErrorContextOrBuilder> 
      getCollectedAssertionsOrBuilderList();
  /**
   * <code>repeated .data.ErrorContext collected_assertions = 9;</code>
   */
  eu.tsystems.mms.tic.testframework.report.model.ErrorContextOrBuilder getCollectedAssertionsOrBuilder(
      int index);
}
