/*
 * Testerra
 *
 * (C) 2022, Martin Großmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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
package eu.tsystems.mms.tic.testframework.test.guielement;

import eu.tsystems.mms.tic.testframework.AbstractExclusiveTestSitesTest;
import eu.tsystems.mms.tic.testframework.core.pageobjects.testdata.WebTestPage;
import eu.tsystems.mms.tic.testframework.pageobjects.Attribute;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.UiElementAssertion;
import eu.tsystems.mms.tic.testframework.testing.AssertProvider;
import org.testng.annotations.Test;

/**
 * Created on 04.05.2022
 *
 * @author mgn
 */
public class UiElementVisibilityTests extends AbstractExclusiveTestSitesTest<WebTestPage> implements AssertProvider {

    @Override
    public Class<WebTestPage> getPageClass() {
        return WebTestPage.class;
    }

    @Test
    public void testT01_UiElement_displayed_false() {
        WebTestPage page = getPage();
        UiElementAssertion expect = page.notDisplayedElement().expect();
        expect.attribute(Attribute.STYLE).contains("display: none").is(true);
        expect.displayed(false);
        expect.hasClasses("button").is(false);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testT02_UiElement_displayed_false_fails() {
        WebTestPage page = getPage();
        page.notDisplayedElement().expect().displayed(true);
    }

    @Test()
    public void testT03_UiElement_displayed_false_fails_withMessage() {
        WebTestPage page = getPage();
        try {
            page.notDisplayedElement().expect().displayed().is(true, "Important element visibility");
        } catch (AssertionError e) {
            ASSERT.assertContains(e.getMessage(), "Important element visibility");
        }
    }

    @Test
    public void testT04_UiElement_visible_false() {
        WebTestPage page = getPage();
        page.notVisibleElement().expect().attribute(Attribute.STYLE).contains("hidden").is(true);
        page.notVisibleElement().expect().attribute("style").contains("hidden").is(true);
        page.notVisibleElement().expect().visible(true).is(false);
        page.notVisibleElement().expect().visible(false).is(false);
        page.notVisibleElement().expect().visibleFull().is(false);
        page.notVisibleElement().expect().visiblePartial().is(false);
        page.notDisplayedElement().expect().css("display").is("none");
        page.notDisplayedElement().expect().hasClasses("mumu").is(false);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testT05_UiElement_visible_false_fails() {
        WebTestPage page = getPage();
        page.notVisibleElement().expect().visible(true).is(true);
        page.notVisibleElement().expect().visibleFull().is(true);
    }

    @Test()
    public void testT06_inexistent_UiElement_displayed_fails() {
        WebTestPage page = getPage();
        page.inexistentElement().expect().displayed().is(false);
    }
}
