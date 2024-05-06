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

package eu.tsystems.mms.tic.testframework.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import eu.tsystems.mms.tic.testframework.execution.testng.RetryAnalyzer;
import eu.tsystems.mms.tic.testframework.hooks.ModuleHook;
import eu.tsystems.mms.tic.testframework.webdriver.WebDriverFactory;
import eu.tsystems.mms.tic.testframework.webdrivermanager.DesktopWebDriverFactory;
import eu.tsystems.mms.tic.testframework.execution.testng.SeleniumRetryAnalyzer;

public class DriverUi_Desktop extends AbstractModule implements ModuleHook {

    @Override
    protected void configure() {
        Multibinder<WebDriverFactory> webDriverFactoryBinder = Multibinder.newSetBinder(binder(), WebDriverFactory.class);
        webDriverFactoryBinder.addBinding().to(DesktopWebDriverFactory.class).in(Scopes.SINGLETON);
    }

    @Override
    public void init() {
        RetryAnalyzer.registerAdditionalRetryAnalyzer(new SeleniumRetryAnalyzer());
    }

    @Override
    public void terminate() {

    }
}
