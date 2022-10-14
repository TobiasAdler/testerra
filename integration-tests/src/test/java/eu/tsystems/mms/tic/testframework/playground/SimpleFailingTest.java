/*
 * Testerra
 *
 * (C) 2020, Eric Kubenka, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
package eu.tsystems.mms.tic.testframework.playground;

import eu.tsystems.mms.tic.testframework.annotations.Fails;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleFailingTest extends TesterraTest implements Loggable {

    @Test(groups = "passed")
    public void testPassed() {
    }

    @Test
    public void testFailing() {
        Assert.fail("This test should fail");
    }

    @Test(dependsOnMethods = "testFailing")
    public void testDependsOnFailed() {
    }

    @Test()
    @Fails(ticketString = "https://this.is.my.ticket.com/string/1234", description = "This could failed.")
    public void test_validExpectedFailed_withAll() {
        log().info("Simple info message", Loggable.prompt);
        log().warn("Simple warn message", Loggable.prompt);
        Assert.fail("This is a <a href=\"#\">HTML message</a>.");
    }

}
