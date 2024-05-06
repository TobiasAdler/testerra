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
package eu.tsystems.mms.tic.testframework.exceptions;

import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;

/**
 * Runtime Exception, stating that a {@link UiElement} is missing.
 */
public class ElementNotFoundException extends UiElementException {

    /**
     * @deprecated Use {@link ElementNotFoundException(UiElement)} instead
     */
    public ElementNotFoundException(String message) {
        super(message);
    }

    public ElementNotFoundException(UiElement uiElement) {
       this(uiElement, null);
    }

    public ElementNotFoundException(UiElement uiElement, Throwable cause) {
        super(uiElement, "not found", cause);
    }
}
