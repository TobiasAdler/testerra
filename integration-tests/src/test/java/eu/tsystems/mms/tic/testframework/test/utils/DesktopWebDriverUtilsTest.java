/*
 * Testerra
 *
 * (C) 2020, Martin Großmann, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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

package eu.tsystems.mms.tic.testframework.test.utils;

import eu.tsystems.mms.tic.testframework.pageobjects.GuiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.Locator;
import eu.tsystems.mms.tic.testframework.test.guielement.AbstractGuiElementTest;
import eu.tsystems.mms.tic.testframework.webdrivermanager.DesktopWebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DesktopWebDriverUtilsTest extends AbstractGuiElementTest {

    /**
     * Test the clickJS method of DesktopWebDriverUtils
     */
    @Test
    public void testT01_DesktopWebDriverUtils_clickJS() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        GuiElement element = getClickableElement();
        GuiElement out = getLoggerTableElement();

        element.mouseOver();
        utils.clickJS(element);
        out.asserts().assertTextContains("Form 16 submit");
    }

    /**
     * Test the doubleClickJS method of DesktopWebDriverUtils
     */
    @Test
    public void testT02_DesktopWebDriverUtils_doubleClickJS() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        final GuiElement element = getSelectableElement();

        utils.doubleClickJS(element);
        getLoggerTableElement().asserts().assertTextContains("Input 3 Double clicked");
    }

    /**
     * Test the rightClickJS method of DesktopWebDriverUtils
     */
    @Test
    public void testT03_DesktopWebDriverUtils_rightClickJS() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        GuiElement element = getClickableElement();

        utils.rightClickJS(element);    // How can we assert a right click?
    }

    /**
     * Test the mouseOverJS method of DesktopWebDriverUtils
     */
    @Test
    public void testT04_DesktopWebDriverUtils_mouseOverJS() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        GuiElement element = getTextBoxElement();
        GuiElement out = getLoggerTableElement();

        utils.mouseOverJS(element);
        out.asserts().assertTextContains("Input 5 Mouse over");
    }

    /**
     * Test the clickAbsolute method of DesktopWebDriverUtils
     */
    @Test
    public void testT05_DesktopWebDriverUtils_clickAbsolute() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        GuiElement element = getClickableElement();
        GuiElement out = getLoggerTableElement();

        element.mouseOver();
        utils.clickAbsolute(element);
        out.asserts().assertTextContains("Form 16 submit");
    }

    /**
     * Test the mouseOverAbsolute2Axis method of DesktopWebDriverUtils
     */
    @Test
    public void testT06_DesktopWebDriverUtils_mouseOverAbsolute2Axis() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();
        GuiElement element = getTextBoxElement();
        GuiElement out = getLoggerTableElement();

        utils.mouseOverAbsolute2Axis(element);      // How can we assert this special mouse over?
    }

    /**
     * Test the mouseOverByImage method of DesktopWebDriverUtils
     */
    @Test
    public void testT07_mouseOverByImage() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();

        String fileName = "byImage/input_field.png";
        utils.mouseOverByImage(getWebDriver(), fileName);
        getLoggerTableElement().expect().text().isContaining("Input 5 Mouse over");
    }

    /**
     * Test the clickOverByImage method of DesktopWebDriverUtils
     */
    @Test
    public void testT08_clickByImage() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();

        String fileName = "byImage/submit_button.png";
        utils.clickByImage(getWebDriver(), fileName);
        getLoggerTableElement().expect().text().isContaining("Form 16 submit");
    }

    /**
     * Test the clickOverByImage method of DesktopWebDriverUtils for an element that is not in the current viewport
     */
    @Test
    public void testT09_clickByImageWithScrolling() {
        DesktopWebDriverUtils utils = new DesktopWebDriverUtils();

        String fileName = "byImage/click_me_button.png";
        utils.clickByImage(getWebDriver(), fileName);
        getClickPosition().expect().text().isContaining("center center");
    }

    public GuiElement getGuiElementBy(Locator locator) {
        WebDriver driver = getWebDriver();
        return new GuiElement(driver, locator);
    }

}
