/*
 * Testerra
 *
 * (C) 2020, Peter Lehmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
 *
 */
 package eu.tsystems.mms.tic.testframework.webdrivermanager;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.constants.TesterraProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TimingConstants {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimingConstants.class);

    public static final int WATCHDOG_THREAD_POLL_INTERVAL_SECONDS = 10;

    public static final int WEBDRIVER_COMMAND_TIMEOUT_SECONDS = PropertyManager.getIntProperty(TesterraProperties.WATCHDOG_TIMEOUT_SECONDS, 6 * 60);
    public static final int WATCHDOG_FIRST_ANNOUNCEMENT_SECONDS; // calculated
    public static final int WATCHDOG_THREAD_HANGING_TIMEOUT_SECONDS; // calculated
    public static final int WATCHDOG_FORCE_QUIT_TIMEOUT_SECONDS; // calculated

    private TimingConstants() {

    }

    static {
        if (WEBDRIVER_COMMAND_TIMEOUT_SECONDS < 2 * 60) {
            String msg = "\n\nWatchDog timeout to low: " + WEBDRIVER_COMMAND_TIMEOUT_SECONDS + " Set at least to 2 minutes.\n\n";
            System.err.println(msg);
            throw new RuntimeException(msg);
        }
        WATCHDOG_FIRST_ANNOUNCEMENT_SECONDS = WEBDRIVER_COMMAND_TIMEOUT_SECONDS / 2;
        WATCHDOG_THREAD_HANGING_TIMEOUT_SECONDS = WEBDRIVER_COMMAND_TIMEOUT_SECONDS - 20;
        WATCHDOG_FORCE_QUIT_TIMEOUT_SECONDS = WEBDRIVER_COMMAND_TIMEOUT_SECONDS + 60; // + 1 min

        LOGGER.info("WatchDog Timings:" +
                "\n FlagUp:    " + WATCHDOG_THREAD_HANGING_TIMEOUT_SECONDS + "s" +
                "\n SelfStop:  " + WEBDRIVER_COMMAND_TIMEOUT_SECONDS + "s" +
                "\n ForceQuit: " + WATCHDOG_FORCE_QUIT_TIMEOUT_SECONDS + "s");
    }

}
