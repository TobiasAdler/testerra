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
package eu.tsystems.mms.tic.testframework.pageobjects;

import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.exceptions.ElementNotFoundException;
import eu.tsystems.mms.tic.testframework.internal.Nameable;
import eu.tsystems.mms.tic.testframework.internal.asserts.PropertyAssertionConfig;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.AbstractPage;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.DefaultPageAssertions;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.PageUiElementFinder;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.asserts.PageAssertions;
import eu.tsystems.mms.tic.testframework.report.Report;
import eu.tsystems.mms.tic.testframework.utils.TimerUtils;
import org.openqa.selenium.WebDriver;

/**
 * Represents a full web page and provides advanced {@link PageObject}.
 *
 * @author Peter Lehmann
 * @author Mike Reiche
 * @todo Should be an interface only
 */
public class Page extends AbstractPage<Page> implements TestablePage {
    private final WebDriver driver;
    private final PageUiElementFinder finder = new PageUiElementFinder(this);

    public Page(WebDriver webDriver) {
        this.driver = webDriver;

        // performance test stop timer
//        perfTestExtras();
    }

    /**
     * Pages should not have parents. Use {@link Component} instead.
     */
    @Override
    public Nameable getParent() {
        return null;
    }

    /**
     * A page has always a name
     */
    @Override
    public boolean hasOwnName() {
        return true;
    }

    /**
     * There is usually no need to set the name of a page
     */
    @Override
    public Page setName(String name) {
        return this;
    }

    /**
     * Always return the class name of the page
     */
    @Override
    public String getName(boolean detailed) {
        return getClass().getSimpleName();
    }

    @Override
    public WebDriver getWebDriver() {
        return driver;
    }

//    /**
//     * Execute loadtestspecific
//     */
//    private void perfTestExtras() {
//        StopWatch.stopPageLoad(getWebDriver(), this.getClass());
//
//        if (Testerra.Properties.PERF_TEST.asBool()) {
//            executeThinkTime();
//        }
//    }

//    /**
//     * executes think time
//     */
//    private void executeThinkTime() {
//        // Thinktime in Properties
//        int thinkTime = PropertyManager.getIntProperty(TesterraProperties.PERF_PAGE_THINKTIME_MS, 0);
//        // timeOut for Threadsleep
//        int timeToWait = 0;
//        /*
//        Zufallsabweichung für Thinktimes > 0
//         */
//        if (thinkTime > 0) {
//            int randomDelta = 2000;
//            Random r = new Random();
//            int randomValue = r.nextInt(randomDelta * 2);
//
//            timeToWait = thinkTime + (randomValue - randomDelta);
//            if (timeToWait < 0) {
//                timeToWait = 0;
//            }
//        }
//        // wait Thinktime + Offset
//        log().info("Waiting a time to think of " + timeToWait + " milliseconds");
//        TimerUtils.sleep(timeToWait);
//    }

    /**
     * Waits for a text to be not present.
     *
     * @return boolean true if success == text is not present. false otherwise.
     */
    @Deprecated
    public boolean waitForIsNotTextPresentWithDelay(final String text, final int delayInSeconds) {
        TimerUtils.sleep(delayInSeconds * 1000);
        return waitForIsNotTextPresent(text);
    }

    protected UiElementFinder getFinder() {
        return this.finder;
    }

    @Override
    protected UiElement find(Locator locator) {
        return getFinder().find(locator);
    }

    @Override
    protected UiElement findDeep(Locator locator) {
        return getFinder().findDeep(locator);
    }

    /**
     * Waits for a text to be not present.
     *
     * @return boolean true if success == text is not present. false otherwise.
     */
    @Deprecated
    public boolean waitForIsNotTextDisplayedWithDelay(final String text, final int delayInSeconds) {
        TimerUtils.sleep(delayInSeconds * 1000);
        return waitForIsNotTextDisplayed(text);
    }

    @Override
    protected void pageLoaded() {
        if (Testerra.Properties.SCREENSHOT_ON_PAGELOAD.asBool()) {
            this.screenshotToReport();
        }
    }

    /**
     * Waits for a text to be not present.
     *
     * @return boolean true if success == text is not present. false otherwise.
     */
    @Deprecated
    public boolean waitForIsNotTextPresent(final String text) {
        return anyElementContainsText(text).waitFor().present(false);
    }

    /**
     * Waits for a text to be not displayed.
     *
     * @return boolean true if success == text is not present. false otherwise.
     */
    @Deprecated
    public boolean waitForIsNotTextDisplayed(final String text) {
        return anyElementContainsText(text).waitFor().displayed(false);
    }

    @Deprecated
    public void assertIsTextPresent(String text, String description) {
        assertIsTextPresent(text);
    }

    @Deprecated
    public void assertIsTextDisplayed(String text, String description) {
        assertIsTextDisplayed(text);
    }

    @Deprecated
    public void assertIsTextPresent(String text) {
        anyElementContainsText(text).expect().present().is(true);
    }

    @Deprecated
    public void assertIsTextDisplayed(String text) {
        anyElementContainsText(text).expect().displayed().is(true);
    }

    @Deprecated
    public void assertIsNotTextPresent(String text) {
        anyElementContainsText(text).expect().present().is(false);
    }

    @Deprecated
    public void assertIsNotTextDisplayed(String text) {
        try {
            anyElementContainsText(text).expect().displayed().is(false);
        } catch (AssertionError error) {
            if (error.getCause() instanceof ElementNotFoundException) {
                // ignore this
            } else {
                throw error;
            }
        }
    }

    private TestableUiElement anyElementContainsText(String text) {
        return this.getFinder().findDeep(XPath.from("*").text().contains(text));
    }

    @Override
    public PageAssertions waitFor(int seconds) {
        PropertyAssertionConfig config = new PropertyAssertionConfig();
        config.useTimeout = seconds;
        return new DefaultPageAssertions(this, config);
    }

    @Override
    public PageAssertions expect() {
        PropertyAssertionConfig config = new PropertyAssertionConfig();
        config.throwErrors = true;
        return new DefaultPageAssertions(this, config);
    }

    @Override
    public void screenshotToReport() {
        this.waitFor().screenshot(Report.Mode.ALWAYS);
    }

    @Override
    public String toString() {
        return this.toString(false);
    }
}
