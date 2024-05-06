/*
 * Testerra
 *
 * (C) 2021, Mike Reiche, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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

package eu.tsystems.mms.tic.testframework.test.utils;

import eu.tsystems.mms.tic.testframework.AbstractTestSitesTest;
import eu.tsystems.mms.tic.testframework.pageobjects.Locate;
import eu.tsystems.mms.tic.testframework.pageobjects.Locator;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElementFinder;
import eu.tsystems.mms.tic.testframework.pageobjects.XPath;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.DefaultLocator;
import eu.tsystems.mms.tic.testframework.testing.UiElementFinderFactoryProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorTest extends AbstractTestSitesTest implements UiElementFinderFactoryProvider {

    private final String textToFind = "This link has some text!";

    private UiElementFinder getFinder() {
        return UI_ELEMENT_FINDER_FACTORY.create(getClassExclusiveWebDriver());
    }

    @Test
    public void locateByClass() {
        UiElementFinder finder = getFinder();
        UiElement div = finder.find(XPath.from("div").classes("element", "multiple"));
        div.expect().text().contains("This element has multiple classes");
    }

    @Test(expectedExceptions = AssertionError.class)
    public void locateByText_fails() {
        UiElementFinder finder = getFinder();
        UiElement realA = finder.findByQa("action/linkWithFormattedText");
        UiElement a = finder.find(XPath.from("a").text().is(textToFind));
        a.expect().text().is(realA.waitFor().text().getActual());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void locateByTextContains_fails() {
        UiElementFinder finder = getFinder();
        UiElement realA = finder.findByQa("action/linkWithFormattedText");
        UiElement a = finder.find(XPath.from("a").text().contains(textToFind));
        a.expect().text().is(realA.waitFor().text().getActual());
    }

    @Test
    public void locateByWords() {
        UiElementFinder finder = getFinder();
        UiElement realA = finder.findByQa("action/linkWithFormattedText");
        UiElement a = finder.find(XPath.from("a").text().hasWords(textToFind.split("\\s+")));
        a.expect().text().is(realA.waitFor().text().getActual());
    }

    @Test
    public void locateByContains() {
        UiElementFinder finder = getFinder();
        UiElement realA = finder.findByQa("action/linkWithFormattedText");
        UiElement a = finder.find(
            XPath.from("a")
                .text().hasWords("This link has some text!")
                .encloses("span")
                    .text().hasWords("Subtext")
        );
        a.expect().text().is(realA.waitFor().text().getActual());
    }

    @Test(expectedExceptions = AssertionError.class)
    public void locateByClassName_fails() {
        UiElementFinder finder = getFinder();
        UiElement div = finder.find(By.className("header"));
        div.expect().text().is("You found me");
    }

    @Test
    public void testLocateByClassWord() {
        UiElementFinder finder = getFinder();
        UiElement div = finder.find(XPath.from("*").classes("header","large"));
        div.expect().text().is("You found me");
    }

    @Test
    public void testLocatePosition() {
        UiElementFinder finder = getFinder();
        UiElement li;
        li = finder.find(XPath.from("ul").classes("list-group").select("li",1));
        li.expect().text().is("Affe");

        li = finder.find(XPath.from("ul").classes("list-group").select("li",2));
        li.expect().text().is("Katze");

        li = finder.find(XPath.from("ul").classes("list-group").select("li",-1));
        li.expect().text().is("Kuh");
    }

    @Test
    public void testLocateByWords() {
        UiElementFinder finder = getFinder();
        UiElement div = finder.find(XPath.from("*").text().hasWords("Login", "here"));
        div.expect().attribute("data-qa").is("action/login");
    }

    /**
     * This feature is not necessary anymore
     */
    @Test(enabled = false)
    public void test_cloneLocateWithNewBy() {
        DefaultLocator locator = (DefaultLocator)Locate.by(By.xpath("//body")).displayed().unique();
        DefaultLocator clonedLocator = (DefaultLocator)Locate.by(By.xpath("//head"), locator);

        Assert.assertSame(clonedLocator.getFilter(), locator.getFilter());
        Assert.assertEquals("By.xpath: //head", clonedLocator.getBy().toString());
        Assert.assertTrue(clonedLocator.isUnique());
    }
}
