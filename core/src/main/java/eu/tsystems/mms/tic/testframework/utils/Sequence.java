/*
 * Testerra
 *
 * (C) 2020, Mike Reiche, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
 *
 * Deutsche Telekom AG and all other contributors /
 * copyright owners license this file to you under the Apache
 * License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package eu.tsystems.mms.tic.testframework.utils;

import eu.tsystems.mms.tic.testframework.logging.Loggable;
import java.util.function.Supplier;

/**
 * A lightweight sequence
 * @author Mike Reiche
 */
public class Sequence implements Loggable {
    private long pauseMs = 0;
    private long timeoutMs = 0;
    private long startTime;
    private long endTime;

    public long getStartTimeMs() {
        return startTime;
    }

    public long getEndTimeMs() {
        return endTime;
    }

    public long getPauseMs() {
        return pauseMs;
    }

    public Sequence setPauseMs(long pauseMs) {
        this.pauseMs = pauseMs;
        return this;
    }

    public long getTimeoutMs() {
        return timeoutMs;
    }

    public Sequence setTimeoutMs(long timeoutMs) {
        this.timeoutMs = timeoutMs;
        return this;
    }

    public long getDurationMs() {
        return endTime - startTime;
    }

    /**
     * Runs the supplier in a timer loop and when it returns true, the sequence stops
     */
    public Sequence run(Supplier<Boolean> runnable) {
        try {
            startTime = System.currentTimeMillis();
            endTime = startTime;
            do {
                if (runnable.get()) {
                    break;
                }
                Thread.sleep(pauseMs);
                endTime = System.currentTimeMillis();
            } while (getDurationMs() < timeoutMs);

        } catch (InterruptedException e) {
            log().error(e.getMessage(), e);
        }
        return this;
    }
}
