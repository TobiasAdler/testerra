/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann
 *     pele
 */
package eu.tsystems.mms.tic.testframework.report.model.steps;

import eu.tsystems.mms.tic.testframework.report.BaseLoggingActor;
import eu.tsystems.mms.tic.testframework.report.model.LogMessage;
import eu.tsystems.mms.tic.testframework.report.model.Serial;
import eu.tsystems.mms.tic.testframework.report.model.context.Screenshot;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by piet on 11.03.16.
 */
public class TestStepAction implements Serializable {

    private static final long serialVersionUID = Serial.SERIAL;

    private String name;
    private int number;

    private List<TestStepActionEntry> testStepActionEntries = Collections.synchronizedList(new LinkedList<TestStepActionEntry>());

    public TestStepAction(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public List<TestStepActionEntry> getTestStepActionEntries() {
        return testStepActionEntries;
    }

    public int getNewEntryNumber() {
        return testStepActionEntries.size() + 1;
    }

    public void addLogMessage(LogMessage logMessage) {
        final TestStepActionEntry testStepActionEntry = new TestStepActionEntry(getNewEntryNumber());
        testStepActionEntry.logMessage = logMessage;
        testStepActionEntries.add(testStepActionEntry);
    }

    public void addScreenshots(final Screenshot beforeShot, final Screenshot afterShot) {
        final TestStepActionEntry testStepActionEntry = new TestStepActionEntry(getNewEntryNumber());
        testStepActionEntry.beforeScreenshot = beforeShot;
        testStepActionEntry.afterScreenshot = afterShot;
        testStepActionEntries.add(testStepActionEntry);
    }

    public void addFailingLogMessage(final String msg) {
        String date = BaseLoggingActor.SIMPLE_DATE_FORMAT.format(new Date());
        LogMessage logMessage = new LogMessage(
                "ERROR",
                date,
                Thread.currentThread().getName(),
                "Test Failed",
                msg);
        final TestStepActionEntry testStepActionEntry = new TestStepActionEntry(getNewEntryNumber());
        testStepActionEntry.logMessage = logMessage;
        testStepActionEntries.add(testStepActionEntry);
    }
}

