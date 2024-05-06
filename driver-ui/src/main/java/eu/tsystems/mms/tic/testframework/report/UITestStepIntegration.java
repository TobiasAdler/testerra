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
 package eu.tsystems.mms.tic.testframework.report;

import eu.tsystems.mms.tic.testframework.internal.utils.ExceptionUtils;
import eu.tsystems.mms.tic.testframework.report.model.context.LogMessage;
import eu.tsystems.mms.tic.testframework.report.model.steps.TestStepController;
import eu.tsystems.mms.tic.testframework.report.model.steps.TestStepHandler;
import org.apache.logging.log4j.core.LogEvent;

public class UITestStepIntegration implements TestStepHandler {

    private static boolean init = false;

    public static void init() {
        if (init) {
            return;
        }

        TestStepController.addHandler(new UITestStepIntegration());
        init = true;
    }

    @Override
    public String getTestStepActionContext(LogMessage logEvent) {
        return ExceptionUtils.getPageContextFromThrowable(new Throwable());
    }
}
