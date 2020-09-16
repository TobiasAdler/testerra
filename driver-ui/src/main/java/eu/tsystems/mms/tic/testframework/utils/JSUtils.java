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

package eu.tsystems.mms.tic.testframework.utils;

import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.constants.JSMouseAction;
import eu.tsystems.mms.tic.testframework.exceptions.NotYetImplementedException;
import eu.tsystems.mms.tic.testframework.exceptions.TesterraRuntimeException;
import eu.tsystems.mms.tic.testframework.exceptions.TesterraSystemException;
import eu.tsystems.mms.tic.testframework.internal.StopWatch;
import eu.tsystems.mms.tic.testframework.internal.Viewport;
import eu.tsystems.mms.tic.testframework.pageobjects.UiElement;
import eu.tsystems.mms.tic.testframework.pageobjects.internal.frames.IFrameLogic;
import java.awt.Color;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JavaScript Utils.
 *
 * @author pele
 */
public final class JSUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSUtils.class);

    /**
     * try to implement javascript on page
     *
     * @param driver       .
     * @param resourceFile .
     * @param id           .
     */
    public static void implementJavascriptOnPage(final WebDriver driver, final String resourceFile, final String id) {

        // TODO rnhb&pele: find a solution that is not conflicting with GuiElement activity (maybe run this before
        // GuiElement) --> Switch to default content will end in "GuiElement not found", because the frame of GuiElement
        // isn't active anymore
        // driver.switchTo().defaultContent();
        if (isJavascriptImplementedOnPage(driver, id)) {
            LOGGER.debug("Already injected: " + resourceFile);
            return;
        }

        LOGGER.debug("JS inject: " + resourceFile);
        /*
         * Build inline string
         */
        String inline = "";
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFile);
            inline = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new TesterraSystemException(e);
        }

        implementJavascriptOnPage(id, driver, inline);
    }

    public static void implementJavascriptOnPage(
            String scriptId,
            WebDriver driver,
            String script
    ) {
        try {
            if (script.length() > 0) {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                String injectedScript = String.format("var script=document.createElement('script');" +
                                "var text=document.createTextNode(%s);" +
                                "script.type='text/javascript';" +
                                "script.id=%s;" +
                                "script.appendChild(text);" +
                                "document.body.appendChild(script);",
                        JSONObject.quote(script),
                        JSONObject.quote(scriptId)
                );
                javascriptExecutor.executeScript(injectedScript);
            }
        } catch (Exception e) {
            LOGGER.error("Error executing javascript: " + e.getMessage(), e);
        }
    }

    /**
     * executing async script
     *
     * @param driver     .
     * @param script     .
     * @param parameters .
     * @return .
     */
    public static Object executeAsyncScript(final WebDriver driver, final String script, final Object... parameters) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        return javascriptExecutor.executeAsyncScript(script, parameters);
    }

    /**
     * Try to execute javascript. If an error occurs it will be thrown.
     *
     * @param driver     .
     * @param script     .
     * @param parameters .
     * @return .
     */
    public static Object executeScriptWOCatch(final WebDriver driver, final String script, final Object... parameters) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String msg = "Executing script >>" + script + "<<";
        if (parameters != null) {
            for (Object parameter : parameters) {
                msg += "\n\n with parameters: " + parameter;
            }
        }

        LOGGER.debug(msg);

        return javascriptExecutor.executeScript(script, parameters);
    }

    /**
     * Try to execute javascript. If an error occurs it will be logged only.
     *
     * @param driver     .
     * @param script     .
     * @param parameters .
     * @return .
     */
    public static Object executeScript(final WebDriver driver, final String script, final Object... parameters) {
        try {
            return executeScriptWOCatch(driver, script, parameters);
        } catch (Exception e) {
            LOGGER.error(String.format("Error executing script\n-----\n%s\n-----", script), e);
            return null;
        }
    }

    /**
     * Highlight a webelement on an actual driver session
     *
     * @param driver     .
     * @param webElement .
     * @param r          .
     * @param g          .
     * @param b          .
     */
    @Deprecated
    public static void highlightWebElement(
            final WebDriver driver,
            final WebElement webElement,
            final int r,
            final int g,
            final int b
    ) {
        highlightWebElement(driver, webElement, new Color(r, g, b));
    }

    /**
     * Highlights an element for a specified time.
     */
    public static void highlightWebElement(
            WebDriver driver,
            WebElement webElement,
            Color color
    ) {
        int ms = 2000;
        executeScript(
                driver,
                String.format("var element = arguments[0];\n" +
                        "var origOutline = element.style.outline;\n" +
                        "element.style.outline='5px solid rgba(%d,%d,%d,%d)';\n" +
                        "var t = window.setTimeout(function(){\n" +
                        "   element.style.outline = origOutline;\n" +
                        "}, %d);",
                        color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha(), ms),
                webElement
        );
    }

    /**
     * Highlight a webelement on an actual driver session
     *
     * @param driver     .
     * @param webElement .
     * @param r          .
     * @param g          .
     * @param b          .
     */
    @Deprecated
    public static void highlightWebElementStatic(
            final WebDriver driver,
            final WebElement webElement,
            final int r,
            final int g,
            final int b
    ) {
        highlightWebElementStatic(driver, webElement, new Color(r, g, b));
    }


    /**
     * Static element highlight doesn't fade out.
     */
    public static void highlightWebElementStatic(
            WebDriver driver,
            WebElement webElement,
            Color color
    ) {
        LOGGER.debug("Static highlighting WebElement " + webElement);
        executeScript(
                driver,
                String.format("arguments[0].style.outline='5px dotted rgba(%d,%d,%d,%d)';", color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()),
                webElement
        );
        LOGGER.debug("Finished static highlighting WebElement" + webElement);
    }

    private static boolean isJavascriptImplementedOnPage(final WebDriver driver, final String id) {
        List<WebElement> script = driver.findElements(By.xpath(".//script[@id='" + id + "']"));
        return script.size() > 0;
    }

    /**
     * Execute a JS MouseAction on a driver session.
     *
     * @param driver              .
     * @param containerWebElement .
     * @param type                .
     * @param x                   .
     * @param y                   .
     */
    public static void executeJavaScriptMouseAction(
            final WebDriver driver,
            WebElement containerWebElement,
            JSMouseAction type,
            int x,
            int y
    ) {
        String aimedElement = "arguments[0]";
        if (containerWebElement == null) {
            aimedElement = "document";
        }
        ((JavascriptExecutor) driver).executeScript("var evt = document.createEvent('MouseEvents');"
                + " evt.initMouseEvent('" + type.getActionCommand() + "',true, true, window, 0, 0, 0,"
                + x + "," + y + ","
                + " false, false, false, false, 0,null);" +
                " " + aimedElement + ".dispatchEvent(evt);", containerWebElement);
    }

    /**
     * Scroll to top of page.
     *
     * @param driver WebDriver instance.
     */
    public static void scrollToTop(final WebDriver driver) {
        final JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("scroll(0,0);");
    }

    /**
     * Get a javascript based selector including frame hierarchy by extracting the By-Property of GuiElement
     * Uses Reflection
     *
     * @param element GuiElement
     * @return String
     */
    public static String getJavaScriptSelector(final UiElement element) {

        final String jsFrameExpander = ".contentDocument";
        String hierarchyFrameSelector = "document";

        // Run through hierarchy
        final IFrameLogic frameLogic = element.getFrameLogic();

        if (frameLogic != null) {
            List<UiElement> allFramesInOrder = frameLogic.getAllFramesInOrder();
            for (UiElement guiElement : allFramesInOrder) {
                hierarchyFrameSelector = pGetSimpleJsSelector(guiElement, hierarchyFrameSelector) + jsFrameExpander;
            }
        }

        // get js selector
        final String fullSelector = pGetSimpleJsSelector(element, hierarchyFrameSelector);

        return fullSelector;
    }

    /**
     * Gets the selector without frame hierarchy
     *
     * @param element          GuiElement
     * @param documentSelector String Current Selector
     * @return String
     */
    private static String pGetSimpleJsSelector(final UiElement element, final String documentSelector) {

        final String jsById = documentSelector + ".getElementById(\"###\")";
        final String jsByClassName = documentSelector + ".getElementsByClassName(\"###\")[0]";
        final String jsByTagName = documentSelector + ".getElementsByTagName(\"###\")[0]";

        //
        final String jsByCssSelector = documentSelector + ".querySelector(\"###\")";
        final String jsByName = documentSelector + ".querySelector(*[name='###'])";

        final String jsByXpath = documentSelector + ".evaluate(\"###\", " + documentSelector
                + ", null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
        // TODO [erku] that is xpath ..maybe we can create some TesterraJS-methods
        final String jsByLinkText = documentSelector + ".evaluate(\".//a[text()='###']\", " + documentSelector
                + ", null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";
        final String jsByPartialLinkText = documentSelector + ".evaluate(\".//a[contains(text(), '###')]\", "
                + documentSelector + ", null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue";

        // By-Class does not allow to access the selector field
        // ... use .toString() and extract selector.
        final By by = element.getLocate().getBy();
        final String beautifiedSelector = beautifySelectorString(by);
        String jsSelector = "";

        if (by instanceof By.ById) {
            jsSelector = jsById;
        } else if (by instanceof By.ByCssSelector) {
            jsSelector = jsByCssSelector;
        } else if (by instanceof By.ByXPath) {
            jsSelector = jsByXpath;
        } else if (by instanceof By.ByClassName) {
            jsSelector = jsByClassName;
        } else if (by instanceof By.ByLinkText) {
            jsSelector = jsByLinkText;
        } else if (by instanceof By.ByPartialLinkText) {
            jsSelector = jsByPartialLinkText;
        } else if (by instanceof By.ByTagName) {
            jsSelector = jsByTagName;
        } else if (by instanceof By.ByName) {
            jsSelector = jsByName;
        }

        return jsSelector.replace("###", beautifiedSelector);
    }

    /**
     * Replaces unnecessary parts of String
     *
     * @param selector By Selector
     * @return String
     */
    private static String beautifySelectorString(By selector) {

        return selector.toString().replaceFirst("By.*:", "").trim();
    }

    public static Map<String, Long> getElementInnerBorders(UiElement guiElement) {
        String cmd = "el = arguments[0];" +
                "bl = window.getComputedStyle(el, null).getPropertyValue('border-left-width');" +
                "br = window.getComputedStyle(el, null).getPropertyValue('border-right-width');" +
                "bt = window.getComputedStyle(el, null).getPropertyValue('border-top-width');" +
                "bb = window.getComputedStyle(el, null).getPropertyValue('border-bottom-width');" +
                "" +
                "pl = window.getComputedStyle(el, null).getPropertyValue('padding-left');" +
                "pr = window.getComputedStyle(el, null).getPropertyValue('padding-right');" +
                "pt = window.getComputedStyle(el, null).getPropertyValue('padding-top');" +
                "pb = window.getComputedStyle(el, null).getPropertyValue('padding-bottom');" +
                "" +
                "bl = bl.replace('px','');" +
                "br = br.replace('px','');" +
                "bt = bt.replace('px','');" +
                "bb = bb.replace('px','');" +
                "" +
                "pl = pl.replace('px','');" +
                "pr = pr.replace('px','');" +
                "pt = pt.replace('px','');" +
                "pb = pb.replace('px','');" +
                "" +
                "l = el.getBoundingClientRect().x;" +
                "w = el.getBoundingClientRect().width;" +
                "t = el.getBoundingClientRect().y;" +
                "h = el.getBoundingClientRect().height;" +
                "" +
                "il = parseInt(l);" +
                "iw = parseInt(w);" +
                "it = parseInt(t);" +
                "ih = parseInt(h);" +
                "" +
                "ibl = parseInt(bl);" +
                "ibr = parseInt(br);" +
                "ibt = parseInt(bt);" +
                "ibb = parseInt(bb);" +
                "" +
                "ipl = parseInt(pl);" +
                "ipr = parseInt(pr);" +
                "ipt = parseInt(pt);" +
                "ipb = parseInt(pb);" +
                "" +
                "x = il + ipl + ibl;" +
                "xx = il + iw - ibr - ipr;" +
                "y = it + ipt + ibt;" +
                "yy = it + ih - ibb - ipb;" +
                "" +
                "return {left:x, right:xx, top:y, bottom:yy};";

        WebDriver driver = guiElement.getWebDriver();
        Map<String, Long> out = new ConcurrentHashMap<>();
        guiElement.findWebElement(webElement -> {
            try {
                Object o = executeScript(driver, cmd, webElement);
                if (o != null && o instanceof Map) {
                    Map map = (Map) o;
                    for (Object key : map.keySet()) {
                        Object value = map.get(key);
                        if (key instanceof String && value instanceof Long) {
                            out.put((String) key, (Long) value);
                        }
                    }

                    out.keySet().forEach(key -> LOGGER.info(key + "=" + out.get(key)));
                    if (out.keySet().size() != 4) {
                        throw new TesterraRuntimeException("Could not get element border via JS call");
                    }

                }
            } catch (Exception e) {
                LOGGER.error("Could not determine element inner left position", e);
            }
            throw new TesterraRuntimeException("Could not get element border via JS call");
        });

        return out;
    }

    public static Viewport getViewport(WebDriver driver) {
        if (driver == null) {
            return null;
        }

        try {
            Integer position = null;
            Integer width = null;
            Integer height = null;

            String script = "var doc = document.documentElement;" +
                    "var top = (window.pageYOffset || doc.scrollTop) - (doc.clientTop || 0);" +
                    "return top;";
            Object jsposition = executeScript(driver, script, "");
            if (jsposition != null) {
                position = Integer.valueOf("" + jsposition);
            }

            script = "var w = Math.max(document.documentElement.clientWidth, window.innerWidth || 0);" +
                    "return w;";
            Object jswidth = executeScript(driver, script, "");
            if (jswidth != null) {
                width = Integer.valueOf("" + jswidth);
            }

            script = "var h = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);" +
                    "return h;";
            Object jsheight = executeScript(driver, script, "");
            if (jsheight != null) {
                height = Integer.valueOf("" + jsheight);
            }

            if (!ObjectUtils.isNull(position, width, height)) {
                LOGGER.debug("viewport position: " + position);
                LOGGER.debug("viewport width: " + width);
                LOGGER.debug("viewport height: " + height);
                return new Viewport(position, width, height);
            }
            return null;
        } catch (Throwable e) {
            LOGGER.warn("Error getting viewport", e);
            return null;
        }
    }

    private static int getJSValueAsInt(Object in) {
        if (in instanceof Double) {
            return (int) (double) (Double) in;
        }
        if (in instanceof Long) {
            return (int) (long) (Long) in;
        }

        LOGGER.error("Cannot cast JS value into int: " + in);
        if (in == null) {
            return 0;
        }
        return 0;
    }

    public static Point getElementLocationInViewPort(UiElement guiElement) {
        int x = 0;
        int y = 0;

        /*
        calculate frames
         */
        if (guiElement.getFrameLogic() != null) {
            UiElement[] frames = guiElement.getFrameLogic().getFrames();
            for (UiElement frame : frames) {
                Point elementLocationInParent = getElementLocationInParent(frame, Where.TOP_LEFT);
                x += elementLocationInParent.x;
                y += elementLocationInParent.y;
            }
        }

        /*
        calculate element
         */
        Point point = getElementLocationInParent(guiElement, Where.CENTER);
        x += point.x;
        y += point.y;

        return new Point(x, y);
    }

    enum Where {
        CENTER,
        TOP_LEFT
    }

    public static Point getElementLocationInParent(UiElement guiElement, Where where) {
        AtomicReference<Point> atomicPoint = new AtomicReference<>();
        guiElement.findWebElement(webElement -> {
            Object o = executeScript(guiElement.getWebDriver(), "return arguments[0].getBoundingClientRect();", webElement);

            if (o == null) {
                throw new TesterraSystemException("Could not get information about web element, please see the logs");
            }

            Map m = (Map) o;

            int left = getJSValueAsInt(m.get("left"));
            int width = getJSValueAsInt(m.get("width"));
            int height = getJSValueAsInt(m.get("height"));
            int top = getJSValueAsInt(m.get("top"));

            switch (where) {
                case CENTER:
                    atomicPoint.set(new Point(left + width / 2, top + height / 2));
                    break;
                case TOP_LEFT:
                    atomicPoint.set(new Point(left, top));
                    break;
                default:
                    throw new NotYetImplementedException("" + where);
            }
        });

        return atomicPoint.get();

    }

    public static Point getRelativePositionVector(UiElement from, UiElement to) {
        Point start = getElementLocationInViewPort(from);
        Point end = getElementLocationInViewPort(to);

        return new Point(end.x - start.x, end.y - start.y);
    }

    /**
     * Scrolls the element to the center of the viewport
     */
    public void scrollToCenter(WebDriver webDriver, WebElement webElement, Point offset) {
        JSUtils.executeScript(
                webDriver,
                String.format("const elementRect = arguments[0].getBoundingClientRect();\n" +
                        "const absoluteElementTop = elementRect.top + window.pageYOffset;\n" +
                        "const absoluteElementLeft = elementRect.left + window.pageXOffset;\n" +
                        "const middle = absoluteElementTop - (window.innerHeight / 2);\n" +
                        "const center = absoluteElementLeft - (window.innerWidth / 2);\n" +
                        "window.scrollTo(center+%d, middle+%d);", offset.x, offset.y),
                webElement
        );
    }

    public void mouseOver(final WebDriver webDriver, final WebElement webElement) {
        demoMouseOver(webDriver, webElement);
        pMouseOverJS(webDriver, webElement);
    }

    public void doubleClick(final WebDriver webDriver, final WebElement webElement) {
        Point location = webElement.getLocation();
        JSUtils.executeJavaScriptMouseAction(webDriver, webElement, JSMouseAction.DOUBLE_CLICK, location.getX(), location.getY());
    }

    public void rightClick(final WebDriver webDriver, final WebElement webElement) {
        String script = "var element = arguments[0];" +
                "var e = element.ownerDocument.createEvent('MouseEvents');" +
                "e.initMouseEvent('contextmenu', true, true,element.ownerDocument.defaultView, 1, 0, 0, 0, 0, false,false, false, false,2, null);" +
                "return !element.dispatchEvent(e);";

        JSUtils.executeScript(webDriver, script, webElement);
    }

    public void click(final WebDriver webDriver, final WebElement webElement) {
        executeScript(webDriver, "arguments[0].click();", webElement);
    }

    private void demoMouseOver(final WebDriver webDriver, final WebElement webElement) {
        if (Testerra.Properties.DEMO_MODE.asBool()) {
            highlightWebElement(webDriver, webElement, new Color(255, 255, 0));
        }
    }

    public void clickAbsolute(final WebDriver webDriver, final WebElement webElement) {
        pClickAbsolute(webDriver, webElement);
    }

    public void mouseOverAbsolute2Axis(final WebDriver webDriver, final WebElement webElement) {
        demoMouseOver(webDriver, webElement);
        pMouseOverAbsolute2Axis(webDriver, webElement);
    }

    private void pMouseOverJS(final WebDriver webDriver, final WebElement webElement) {
        final String code = "var fireOnThis = arguments[0];"
                + "var evObj = document.createEvent('MouseEvents');"
                + "evObj.initEvent( 'mouseover', true, true );"
                + "fireOnThis.dispatchEvent(evObj);";

        ((JavascriptExecutor) webDriver).executeScript(code, webElement);
    }

    private void pClickAbsolute(WebDriver driver, WebElement webElement) {
        // Start the StopWatch for measuring the loading time of a Page
        StopWatch.startPageLoad(driver);

        Point point = webElement.getLocation();

        Actions action = new Actions(driver);

        // goto 0,0
        action.moveToElement(webElement, 1 + -point.getX(), 1 + -point.getY());

        // move y, then x
        action.moveByOffset(0, point.getY()).moveByOffset(point.getX(), 0);

        // move to webElement
        action.moveToElement(webElement);
        action.moveByOffset(1, 1);
        action.click().perform();
    }

    private void pMouseOverAbsolute2Axis(WebDriver driver, WebElement webElement) {
        Actions action = new Actions(driver);

        Point point = webElement.getLocation();

        // goto 0,0
        action.moveToElement(webElement, 1 + -point.getX(), 1 + -point.getY()).perform();

        // move y, then x
        action.moveByOffset(0, point.getY()).moveByOffset(point.getX(), 0).perform();

        // move to webElement
        action.moveToElement(webElement).perform();
    }
}
