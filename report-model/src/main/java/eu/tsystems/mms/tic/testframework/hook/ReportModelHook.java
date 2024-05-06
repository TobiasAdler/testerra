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

package eu.tsystems.mms.tic.testframework.hook;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.hooks.ModuleHook;
import eu.tsystems.mms.tic.testframework.listeners.GenerateJUnitXML2ReportListener;
import eu.tsystems.mms.tic.testframework.listeners.GenerateTestNGXmlReportListener;

public class ReportModelHook extends AbstractModule implements ModuleHook {

    @Override
    public void init() {
        // Enable XML report listener
        EventBus eventBus = Testerra.getEventBus();
        eventBus.register(new GenerateTestNGXmlReportListener());
        eventBus.register(new GenerateJUnitXML2ReportListener());
    }

    @Override
    public void terminate() {
    }
}
