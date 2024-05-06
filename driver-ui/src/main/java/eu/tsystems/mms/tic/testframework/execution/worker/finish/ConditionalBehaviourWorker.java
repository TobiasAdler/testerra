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
 package eu.tsystems.mms.tic.testframework.execution.worker.finish;

import com.google.common.eventbus.Subscribe;
import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.constants.TesterraProperties;
import eu.tsystems.mms.tic.testframework.events.MethodEndEvent;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.report.TesterraListener;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;

public class ConditionalBehaviourWorker implements Loggable, MethodEndEvent.Listener {

    @Override
    @Subscribe
    public void onMethodEnd(MethodEndEvent event) {
        if (event.getTestMethod().isTest() && event.isFailed()) {
            // check state condition: skip test methods
            boolean skipFollowingTests = PropertyManager.getBooleanProperty(
                    TesterraProperties.ON_STATE_TESTFAILED_SKIP_FOLLOWING_TESTS, false);
            if (skipFollowingTests) {
                log().info(TesterraProperties.ON_STATE_TESTFAILED_SKIP_FOLLOWING_TESTS + " : true, skipping all tests from now on");
                TesterraListener.skipAllTests();
            }
        }
    }
}
