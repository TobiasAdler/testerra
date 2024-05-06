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

package eu.tsystems.mms.tic.testframework.pageobjects.internal.core;

import eu.tsystems.mms.tic.testframework.pageobjects.Locator;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.WebElementActions;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.UiElementBaseAssertion;

/**
 * Contains basic GuiElement features which every GuiElement needs to have.
 * @author Mike Reiche
 */
public interface UiElementBase extends WebElementActions {
    /**
     * The same linke {@link #waitFor(int)} with default timeout
     */
    default UiElementBaseAssertion waitFor() {
        return waitFor(-1);
    }
    /**
     * Doesn't throw any {@link AssertionError}
     */
    UiElementBaseAssertion waitFor(int seconds);
    /**
     * Throws {@link AssertionError} when condition not matched
     */
    UiElementBaseAssertion expect();
    /**
     * Another name for {@link #expect()}
     */
    default UiElementBaseAssertion assertThat() {
        return expect();
    }
    /**
     * Creates a xpath of the given {@link Locator} hierarchy NOT the actual element hierarchy
     */
    String createXPath();
    Locator getLocator();
}
