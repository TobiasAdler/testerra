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
package eu.tsystems.mms.tic.testframework.webdrivermanager;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.common.Testerra;
import eu.tsystems.mms.tic.testframework.constants.TesterraProperties;
import eu.tsystems.mms.tic.testframework.enums.Position;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.webdrivermanager.desktop.WebDriverMode;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;

public class DesktopWebDriverRequest extends SeleniumWebDriverRequest implements Loggable, Serializable {

    private boolean maximize;
    private Position maximizePosition;

    public DesktopWebDriverRequest() {
        super();
        this.maximize = PropertyManager.getBooleanProperty(TesterraProperties.BROWSER_MAXIMIZE, false);
        this.maximizePosition = Position.valueOf(PropertyManager.getProperty(TesterraProperties.BROWSER_MAXIMIZE_POSITION, Position.CENTER.toString()).toUpperCase());
    }

    /**
     * @deprecated Use {@link #getServerUrl()}
     */
    public WebDriverMode getWebDriverMode() {
        return null;
    }

    /**
     * @deprecated Use {@link #setServerUrl(URL)} instead
     */
    public void setWebDriverMode(WebDriverMode webDriverMode) {

    }

    public void setMaximizeBrowser(boolean maximize) {
        this.maximize = maximize;
    }

    public boolean getMaximizeBrowser() {
        return this.maximize;
    }

    public void setMaximizePosition(Position position) {
        this.maximizePosition = position;
    }

    public Position getMaximizePosition() {
        return this.maximizePosition;
    }

    public Dimension getWindowSize() {
        Dimension dimension;
        String windowSizeProperty = Testerra.Properties.WINDOW_SIZE.asString();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(windowSizeProperty)) {
            Pattern pattern = Pattern.compile("(\\d+)x(\\d+)");
            Matcher matcher = pattern.matcher(windowSizeProperty);

            if (matcher.find()) {
                int width = Integer.parseInt(matcher.group(1));
                int height = Integer.parseInt(matcher.group(2));
                dimension = new Dimension(width, height);
            } else {
                dimension = getDefaultDimension();
                log().error(String.format("Unable to parse property %s=%s, falling back to default: %s", Testerra.Properties.WINDOW_SIZE, windowSizeProperty, dimension));
            }
        } else {
            dimension = getDefaultDimension();
        }
        return dimension;
    }

    private Dimension getDefaultDimension() {
        return new Dimension(1920, 1080);
    }

}
