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
 package eu.tsystems.mms.tic.testframework.execution.worker.start;

import com.google.common.eventbus.Subscribe;
import eu.tsystems.mms.tic.testframework.events.MethodStartEvent;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.useragents.BrowserInformation;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManagerUtils;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverSessionsManager;
import java.util.LinkedList;
import org.openqa.selenium.WebDriver;

import java.util.List;
import org.openqa.selenium.WebDriver;

public class WebDriverLoggingStartWorker implements MethodStartEvent.Listener, Loggable {

    @Override
    @Subscribe
    public void onMethodStart(MethodStartEvent event) {
        if (event.getTestMethod().isTest()) {
            /*
             * Log already opened wd sessions
             */
            List<String> statusLog = new LinkedList<>();
            WebDriverSessionsManager.readSessionContexts()
                    .forEach(sessionContext -> {
                        StringBuilder statusLogEntry = new StringBuilder();
                        sessionContext.getActualBrowserName().ifPresent(statusLogEntry::append);
                        sessionContext.getActualBrowserVersion().ifPresent(s -> statusLogEntry.append(":").append(s));
                        sessionContext.getNodeUrl().ifPresent(url -> statusLogEntry.append(" on ").append(url));
                        statusLog.add(statusLogEntry.toString());
                    });

            if (statusLog.size() > 0) {
                log().info("Already opened webdriver sessions:\n" + String.join("\n", statusLog));
            }
        }
    }
}
