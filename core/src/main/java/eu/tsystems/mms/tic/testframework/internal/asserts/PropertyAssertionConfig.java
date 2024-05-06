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

package eu.tsystems.mms.tic.testframework.internal.asserts;

import eu.tsystems.mms.tic.testframework.execution.testng.Assertion;

/**
 * Configuration for implementations of {@link AbstractPropertyAssertion}
 * @todo Make this package private
 */
public class PropertyAssertionConfig {
    public boolean throwErrors = false;
    /**
     * @deprecated This is only required for {@link LegacyGuiElementAssertWrapper}
     * and can be removed with these interface features.
     */
    @Deprecated
    public Assertion useAssertion;
    public int useTimeout = -1;
}
