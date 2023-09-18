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

package eu.tsystems.mms.tic.testframework.execution.testng;

import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.interop.TestEvidenceCollector;
import eu.tsystems.mms.tic.testframework.report.Report;
import eu.tsystems.mms.tic.testframework.report.model.context.Screenshot;
import eu.tsystems.mms.tic.testframework.report.utils.IExecutionContextController;

import java.util.List;

/**
 * Collects {@link AssertionError} on failed assertion
 */
public class DefaultCollectedAssertion extends AbstractAssertion implements CollectedAssertion {

    @Override
    public void fail(Error error) {
        IExecutionContextController executionContextController = Testerra.getInjector().getInstance(IExecutionContextController.class);
        executionContextController.getCurrentMethodContext().ifPresent(methodContext -> {
            methodContext.addError(error);
            // get screenshots
            List<Screenshot> screenshots = TestEvidenceCollector.collectScreenshots();
            Report report = Testerra.getInjector().getInstance(Report.class);
            screenshots.forEach(screenshot -> {
                methodContext.addScreenshot(screenshot);
                report.addScreenshot(screenshot, Report.FileMode.MOVE);
            });
        });
    }
}
