package eu.tsystems.mms.tic.testframework.webdrivermanager;

import org.openqa.selenium.Capabilities;

import java.net.URL;
import java.util.Optional;

public interface WebDriverRequest extends Cloneable {
    String DEFAULT_SESSION_KEY = "default";
    String getSessionKey();
    String getBrowser();
    String getBrowserVersion();
    String getPlatformName();
    Capabilities getCapabilities();

    boolean getShutdownAfterTest();
    boolean getShutdownAfterTestFailed();
    boolean getShutdownAfterExecution();
    void setShutdownAfterTest(boolean shutdownAfterTest);
    void setShutdownAfterTestFailed(boolean shutdownAfterTestFailed);
    void setShutdownAfterExecution(boolean shutdownAfterExecution);

    Optional<URL> getServerUrl();

    WebDriverRequest clone() throws CloneNotSupportedException;
}
