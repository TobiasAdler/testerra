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

package eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts;

import eu.tsystems.mms.tic.testframework.internal.asserts.ActualProperty;
import eu.tsystems.mms.tic.testframework.internal.asserts.BinaryAssertion;
import eu.tsystems.mms.tic.testframework.internal.asserts.QuantityAssertion;
import eu.tsystems.mms.tic.testframework.pageobjects.TestableUiElement;
import org.openqa.selenium.Rectangle;

/**
 * Allows element location tests
 * @author Mike Reiche
 */
public interface RectAssertion extends ActualProperty<Rectangle> {
    BinaryAssertion<Boolean> contains(TestableUiElement guiElement);
    BinaryAssertion<Boolean> intersects(TestableUiElement guiElement);
    BinaryAssertion<Boolean> leftOf(TestableUiElement guiElement);
    BinaryAssertion<Boolean> rightOf(TestableUiElement guiElement);
    BinaryAssertion<Boolean> above(TestableUiElement guiElement);
    BinaryAssertion<Boolean> below(TestableUiElement guiElement);
    HorizontalDistanceAssertion fromRight();
    HorizontalDistanceAssertion fromLeft();
    VerticalDistanceAssertion fromTop();
    VerticalDistanceAssertion fromBottom();

    QuantityAssertion<Integer> top();
    QuantityAssertion<Integer> left();
    QuantityAssertion<Integer> width();
    QuantityAssertion<Integer> height();
}
