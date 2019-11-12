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
package eu.tsystems.mms.tic.testframework.core.test.utils;

import eu.tsystems.mms.tic.testframework.AbstractTest;
import eu.tsystems.mms.tic.testframework.exceptions.TesterraRuntimeException;
import eu.tsystems.mms.tic.testframework.exceptions.TimeoutException;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.transfer.ThrowablePackedResponse;
import eu.tsystems.mms.tic.testframework.utils.Timer;
import eu.tsystems.mms.tic.testframework.utils.TimerUtils;
import org.testng.annotations.Test;

/**
 * Created by nigr on 04.09.2015.
 */
public class TimerTest extends AbstractTest implements Loggable {

    public static final int DURATION_IN_MS = 1000;
    public static final int SLEEP_TIME_IN_MS = 50;
    public static final int UPPER_BOUND_IN_MS = 200;

    private final String msgMinimumTime = "Timer need at least " + DURATION_IN_MS + " ms to pass";
    private final String msgMaximumTime = "Sequence execution timed out within variance";

    private final String msgCorrectPass = "Timer passed sequence correctly";
    private final String msgCorrectResponse = "Response was returned correctly";
    private final String msgCorrectThrowable = "Throwable was returned correctly";

    private final String msgTimeout = "Sequence execution timed out " + DURATION_IN_MS + " ms (polling every " + SLEEP_TIME_IN_MS + " ms)";
    private final String msgTimeoutExceptionThrown = "TimeoutException was thrown";

    private final String msgTesterraRuntimeException = "TesterraRuntimeException Message";
    private final String msgTesterraRuntimeExceptionThrown = "TesterraRuntimeException was thrown";

    @Test
    public void testT01_ExecuteSequence() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();

        ThrowablePackedResponse<String> out = timer.executeSequence(new Timer.Sequence<String>() {
            @Override
            public void run() {
            }
        });

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;

        Assert.assertFalse(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration < UPPER_BOUND_IN_MS, "Timer passed sequence in less than 200ms");
    }

    @Test
    public void testT02_ExecuteSequence_PassStateTrue() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();

        ThrowablePackedResponse<String> out = timer.executeSequence(new Timer.Sequence<String>() {
            @Override
            public void run() {
                setPassState(true);
            }
        });

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;

        Assert.assertFalse(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration < UPPER_BOUND_IN_MS, "Timer passed sequence in less than 200ms");
    }

    @Test
    public void testT03_ExecuteSequence_PassStateTrueAndReturningObject() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();

        ThrowablePackedResponse<String> out = timer.executeSequence(new Timer.Sequence<String>() {
            @Override
            public void run() {
                setReturningObject("huhu");
                setPassState(true);
            }
        });

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;
        String response = out.getResponse();

        Assert.assertFalse(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration < UPPER_BOUND_IN_MS, "Timer passed sequence in less than 200ms");
        Assert.assertNotNull(response, msgCorrectResponse);
        Assert.assertEquals(response, "huhu", msgCorrectResponse);
    }

    @Test
    public void testT04_ExecuteSequence_WithException() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();

        Throwable throwable = new Throwable();
        ThrowablePackedResponse<String> out = new ThrowablePackedResponse<String>(null, throwable, false, new TimeoutException(throwable));
        TimeoutException timeoutException = null;
        TesterraRuntimeException testerraRuntimeException;

        try {
            out = timer.executeSequence(new Timer.Sequence<String>() {
                @Override
                public void run() {
                    setReturningObject("huhu");
                    throw new TesterraRuntimeException(msgTesterraRuntimeException);
                }
            });
        } catch (TimeoutException e) {
            timeoutException = e;
        }

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;
        String response = out.getResponse();

        Assert.assertTrue(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration >= DURATION_IN_MS, msgMinimumTime);
        Assert.assertTrue(timeMillisDuration <= DURATION_IN_MS + UPPER_BOUND_IN_MS, msgMaximumTime);
        Assert.assertNull(response, msgCorrectResponse);
        Assert.assertNotNull(timeoutException, msgTimeoutExceptionThrown);

        testerraRuntimeException = (TesterraRuntimeException) timeoutException.getCause();

        Assert.assertNotNull(testerraRuntimeException, msgTesterraRuntimeExceptionThrown);
        Assert.assertEquals(testerraRuntimeException.getMessage(), msgTesterraRuntimeException, msgTesterraRuntimeExceptionThrown);
    }

    @Test
    public void testT05_ExecuteSequence_PassStateFalse() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();

        Throwable throwable = new Throwable();
        ThrowablePackedResponse<String> out = new ThrowablePackedResponse<String>(null, throwable, false, new TimeoutException(throwable));
        TimeoutException timeoutException = null;

        try {
            out = timer.executeSequence(new Timer.Sequence<String>() {
                @Override
                public void run() {
                    setPassState(false);
                }
            });
        } catch (TimeoutException e) {
            timeoutException = e;
        }

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;
        String response = out.getResponse();

        Assert.assertTrue(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration >= DURATION_IN_MS, msgMinimumTime);
        Assert.assertTrue(timeMillisDuration <= DURATION_IN_MS + UPPER_BOUND_IN_MS, msgMaximumTime);
        Assert.assertNotNull(timeoutException, msgTimeoutExceptionThrown);
        Assert.assertEquals(timeoutException.getMessage(), msgTimeout);
        Assert.assertNull(response, msgCorrectResponse);
    }

    @Test
    public void testT06_ExecuteSequence_PassStateFalseAndReturningObject() throws Exception {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);

        final long timeMillisBegin = System.currentTimeMillis();
        boolean isTimeoutExceptionThrown = false;

        Throwable throwable = new Throwable();
        ThrowablePackedResponse<String> out = new ThrowablePackedResponse<String>(null, throwable, false, new TimeoutException(throwable));

        try {
            out = timer.executeSequence(new Timer.Sequence<String>() {
                @Override
                public void run() {
                    setReturningObject("huhu");
                    setPassState(false);
                }
            });
        } catch (TimeoutException e) {
            isTimeoutExceptionThrown = true;
        }

        final long timeMillisDuration = System.currentTimeMillis() - timeMillisBegin;
        String response = out.getResponse();

        Assert.assertTrue(timer.isTimeOver(), msgCorrectPass);
        Assert.assertTrue(timeMillisDuration >= DURATION_IN_MS, msgMinimumTime);
        Assert.assertTrue(timeMillisDuration <= DURATION_IN_MS + UPPER_BOUND_IN_MS, msgMaximumTime);
        Assert.assertFalse(isTimeoutExceptionThrown, msgTimeoutExceptionThrown);
        Assert.assertNotNull(response, msgCorrectResponse);
        Assert.assertEquals(response, "huhu", msgCorrectResponse);
    }

    @Test
    public void testT07_ExecuteSequence_SkipThrowingException() {
        Timer timer = new Timer(SLEEP_TIME_IN_MS, DURATION_IN_MS);
        Throwable throwable = new Throwable();
        ThrowablePackedResponse<String> out = new ThrowablePackedResponse<String>(null, throwable, false, new TimeoutException(throwable));
        TesterraRuntimeException testerraRuntimeException;

        boolean isTimeoutExceptionThrown = false;

        try {
            out = timer.executeSequence(new Timer.Sequence<String>() {
                @Override
                public void run() {
                    setSkipThrowingException(true);
                    setReturningObject("huhu");
                    throw new TesterraRuntimeException(msgTesterraRuntimeException);
                }
            });
        } catch (TimeoutException e) {
            isTimeoutExceptionThrown = true;
        }

        String response = out.getResponse();
        testerraRuntimeException = (TesterraRuntimeException) out.getThrowable();

        Assert.assertFalse(isTimeoutExceptionThrown, msgTimeoutExceptionThrown);
        Assert.assertNotNull(response, msgCorrectResponse);
        Assert.assertNotNull(testerraRuntimeException, msgCorrectThrowable);
        Assert.assertEquals(response, "huhu", msgCorrectResponse);
        Assert.assertEquals(testerraRuntimeException.getMessage(), msgTesterraRuntimeException, msgCorrectThrowable);
    }

    @Test
    public void testT08_ExecuteSequenceInThread() {

        final Timer.Sequence<Object> sequenceToRun = new Timer.Sequence<Object>() {

            int count = 0;

            @Override
            public void run() {

                if (count == 5) {
                    setPassState(true);
                    setReturningObject("Green!");
                    return;
                }

                TimerUtils.sleep(1500, "InnerSequence Run " + count);
                setPassState(false);
                count++;
            }
        };

        final Timer timer = new Timer(500, 15_000);
        timer.executeSequenceThread(sequenceToRun);

        log().info("Outer Sequence Step 1");
        TimerUtils.sleep(5_000);
        log().info("Outer Sequence Step 2");
        TimerUtils.sleep(5_000);
        log().info("Outer Sequence Step 3");
        TimerUtils.sleep(5_000);

        final String returningObject = (String) sequenceToRun.getReturningObject();
        Assert.assertEquals(returningObject, "Green!");
    }

    @Test
    public void testT09_ExecuteSequenceInThreadHittingTimeout() {

        final Timer.Sequence<Object> sequenceToRun = new Timer.Sequence<Object>() {

            int count = 0;

            @Override
            public void run() {

                if (count == 5) {
                    setPassState(true);
                    return;
                }

                TimerUtils.sleep(1500, "InnerSequence Run " + count);
                setPassState(false);
                setReturningObject("False!");
                count++;
            }
        };

        final Timer timer = new Timer(500, 5_000);
        timer.executeSequenceThread(sequenceToRun);

        log().info("Outer Sequence Step 1");
        TimerUtils.sleep(5_000);
        log().info("Outer Sequence Step 2");
        TimerUtils.sleep(5_000);
        log().info("Outer Sequence Step 3");
        TimerUtils.sleep(5_000);

        final String returningObject = (String) sequenceToRun.getReturningObject();
        Assert.assertEquals(returningObject, "False!");
    }
}
