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
 package eu.tsystems.mms.tic.testframework.test.common;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.common.PropertyManagerProvider;
import eu.tsystems.mms.tic.testframework.common.WebDriverPropertyResolver;
import eu.tsystems.mms.tic.testframework.constants.TesterraProperties;
import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.webdrivermanager.IWebDriverManager;
import eu.tsystems.mms.tic.testframework.webdrivermanager.WebDriverManager;
import java.util.Collections;
import java.util.Optional;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertyManagerTest extends TesterraTest implements PropertyManagerProvider {

    /**
     * property test with system properties and replacement system
     */
    @Test
    public void testT01a_ReplaceSystemProperty() {
        System.setProperty("myprop", "bla_{huhu}");
        System.setProperty("huhu", "blubb");
        String property = PropertyManager.getProperty("myprop", "nothing");

        Assert.assertEquals(property, "bla_blubb", "SystemProperty Replacement works");
    }

    /**
     * property test with boolean from property manager
     */
    @Test
    public void testT02BooleanFileTrue() {
        boolean prop = PropertyManager.getBooleanProperty("pm.test.boolean1", false);
        Assert.assertTrue(prop, "Boolean property from file");
    }

    /**
     * property test with boolean from property manager
     */
    @Test
    public void testT03BooleanFileFalse() {
        boolean prop = PropertyManager.getBooleanProperty("pm.test.boolean2", true);
        Assert.assertFalse(prop, "Boolean property from file");
    }

    /**
     * property test with default boolean
     */
    @Test
    public void testT04BooleanDefault() {
        boolean prop = PropertyManager.getBooleanProperty("pm.test.boolean3", false);
        Assert.assertFalse(prop, "Boolean property default");
    }

    /**
     * property test without default boolean
     */
    @Test
    public void testT04b_BooleanWithoutDefault() {
        boolean prop = PropertyManager.getBooleanProperty("pm.test.boolean1");
        Assert.assertTrue(prop, "Boolean property default");
    }

    /**
     * property test without default boolean
     */
    @Test
    public void testT04c_BooleanWithoutDefaultAndNotSet() {
        boolean prop = PropertyManager.getBooleanProperty("pm.test.boolean3");
        Assert.assertFalse(prop, "Boolean property default");
    }

    /**
     * property test with boolean from system properties
     */
    @Test
    public void testT05SystBoolean1() {
        System.setProperty("pm.test.boolean4", "true");
        boolean booleanProperty = PropertyManager.getBooleanProperty("pm.test.boolean4", true);
        Assert.assertTrue(booleanProperty, "Boolean property from system");
    }

    /**
     * property test with boolean from system properties
     */
    @Test
    public void testT06SystBoolean2() {
        System.setProperty("pm.test.boolean5", "false");
        boolean booleanProperty = PropertyManager.getBooleanProperty("pm.test.boolean5", false);
        Assert.assertFalse(booleanProperty, "Boolean property from system");
    }

    /**
     * property test with boolean from system properties
     */
    @Test
    public void testT07SystBoolean3() {
        System.setProperty("pm.test.boolean6", "false");
        boolean booleanProperty = PropertyManager.getBooleanProperty("pm.test.boolean6", true);
        Assert.assertFalse(booleanProperty, "Boolean property from system");
    }

    /**
     * property test with boolean from system properties with replacement system
     */
    @Test
    public void testT08BooleanEinsetzen1() {
        System.setProperty("pm.test.boolean7", "false");
        System.setProperty("pm.test.boolean8", "{pm.test.boolean7}");
        boolean booleanProperty = PropertyManager.getBooleanProperty("pm.test.boolean8", true);
        Assert.assertFalse(booleanProperty, "Boolean property replacement");
    }

    /**
     * property test with integer from property manager
     */
    @Test
    public void testT09IntFile1() {
        int intProperty = PropertyManager.getIntProperty("pm.test.int1");
        Assert.assertEquals(intProperty, 0, "Int property from file");
    }

    /**
     * property test with integer from property manager
     */
    @Test
    public void testT10IntFile2() {
        int intProperty = PropertyManager.getIntProperty("pm.test.int2");
        Assert.assertEquals(intProperty, 465, "Int property from file");
    }

    /**
     * property test with default integer
     */
    @Test
    public void testT11IntDefault() {
        int intProperty = PropertyManager.getIntProperty("pm.test.int3", 1966);
        Assert.assertEquals(intProperty, 1966, "Int property default");
    }

    /**
     * property test with integer from system properties
     */
    @Test
    public void testT12SIntSystem1() {
        System.setProperty("pm.test.int4", "1324");
        int intProperty = PropertyManager.getIntProperty("pm.test.int4", 1324);
        Assert.assertEquals(intProperty, 1324, "Int property from system");
    }

    /**
     * property test with integer from system properties
     */
    @Test
    public void testT13IntSystem2() {
        System.setProperty("pm.test.int5", "13498765");
        int intProperty = PropertyManager.getIntProperty("pm.test.int5", 13498765);
        Assert.assertEquals(intProperty, 13498765, "Int property from system");
    }

    /**
     * property test with integer from system properties with replacement system
     */
    @Test
    public void testT14IntEinsetzen() {
        System.setProperty("pm.test.int5", "500");
        System.setProperty("pm.test.int6", "3{pm.test.int5}");
        int intProperty = PropertyManager.getIntProperty("pm.test.int6");
        Assert.assertEquals(intProperty, 3500, "Int property replacement");
    }

    /**
     * property test with string files from system properties
     */
    @Test
    public void testT15StringSystem1() {
        System.setProperty("pm.test.str1", "B");
        String property = PropertyManager.getProperty("pm.test.str1");
        Assert.assertEquals(property, "B", "property from system");
    }

    /**
     * property test with string files from system properties
     */
    @Test
    public void testT16StrSystem1() {
        System.setProperty("pm.test.str2", "Haus");
        String property = PropertyManager.getProperty("pm.test.str2");

        Assert.assertEquals(property, "Haus", "property from system");
    }

    /**
     * property test with string files from system properties with replacement system
     */
    @Test
    public void testT17StrEinsetzen1() {
        System.setProperty("pm.test.str3", "Peter_{Nachname}");
        System.setProperty("Nachname", "Pan");
        String property = PropertyManager.getProperty("pm.test.str3");
        Assert.assertEquals(property, "Peter_Pan", "property system replacement");
    }

    /**
     * property test with string files from system properties with replacement system
     */
    @Test
    public void testt18Streinsetzen2() {
        System.setProperty("pm.test.str4", "League_{1}_{pm.test.str5}");
        System.setProperty("1", "of");
        System.setProperty("pm.test.str5", "Legends");
        String property = PropertyManager.getProperty("pm.test.str4");
        Assert.assertEquals(property, "League_of_Legends", "property system replacement ");
    }

    /**
     * property test with string file from property manager
     */
    @Test
    public void testt19Stringfile1() {
        String property = PropertyManager.getProperty("pm.test.str6");
        Assert.assertEquals(property, "A", "property from file");
    }

    /**
     * property test with string file from property manager
     */
    @Test
    public void testt20Stringfile2() {
        String property = PropertyManager.getProperty("pm.test.str7");
        Assert.assertEquals(property, "Student", "property from file");
    }

    /**
     * property test with default string file
     */
    @Test
    public void testt21Stringfiledefault() {
        String property = PropertyManager.getProperty("pm.test.str8", "Test");
        Assert.assertEquals(property, "Test", "property default");
    }

    @Test
    public void testT22_DoublePropertyWithDefault() {

        double doubleProperty = PropertyManager.getDoubleProperty("pm.test.double1", 10.0);
        Assert.assertEquals(doubleProperty, 10.11, "Double Property equals value of file property.");
    }

    @Test
    public void testT23_DoublePropertyWithDefaultNotSet() {

        double doubleProperty = PropertyManager.getDoubleProperty("pm.test.double2", 10.0);
        Assert.assertEquals(doubleProperty, 10.0, "Double Property equals value of default.");
    }

    @Test
    public void testT24_DoublePropertyWithoutDefaultNotSet() {
        double doubleProperty = PropertyManager.getDoubleProperty("pm.test.double2");
        Assert.assertEquals(doubleProperty, -1.0, "Double Property equals default value.");
    }

    @Test
    public void testT25_LongPropertyWithDefault() {

        long longProperty = PropertyManager.getLongProperty("pm.test.long1", 10L);
        Assert.assertEquals(longProperty, 2147483648L, "Long Property equals value of file property.");
    }

    @Test
    public void testT26_LongPropertyWithDefaultNotSet() {

        long longProperty = PropertyManager.getLongProperty("pm.test.long2", 10L);
        Assert.assertEquals(longProperty, 10L, "Long Property equals value of default.");
    }

    @Test
    public void testT27_LongPropertyWithoutDefaultNotSet() {
        long longProperty = PropertyManager.getLongProperty("pm.test.long2");
        Assert.assertEquals(longProperty, -1L, "Long Property equals default value.");
    }

    @Test
    public void testT31_MultiReplace() {
        System.setProperty("myprop", "test_{prop1}_{prop5}");
        System.setProperty("prop1", "value1");
        System.setProperty("prop2", "value2");
        System.setProperty("prop3", "value3_{prop2}");
        System.setProperty("prop4", "value4_{prop3}");
        System.setProperty("prop5", "value5_{prop4}_{prop1}");
        String property = PropertyManager.getProperty("myprop", "nothing");

        Assert.assertEquals(property, "test_value1_value5_value4_value3_value2_value1", "SystemProperty Replacement works");
    }

    @Test
    public void testT32_MultiReplace_Sensible() {
        System.setProperty("myprop", "test_{prop1}_{prop5}");
        System.setProperty("prop1", "value1");
        System.setProperty("prop2", "value2");
        System.setProperty("prop3", "value3_{prop2}");
        System.setProperty("prop4", "value4_{prop3}");
        System.setProperty("prop5", "value5_{prop4}_{prop1}");
        String property = PropertyManager.getProperty("myprop", "nothing");

        Assert.assertEquals(property, "test_value1_value5_value4_value3_value2_value1", "SystemProperty Replacement works");
    }

    @Test
    public void testT40_ThreadLocalProperty() {

        PropertyManager.getThreadLocalProperties().put("thread.property", "1");

        final Runnable runnable = () -> PropertyManager.getThreadLocalProperties().put("thread.property", "runnable");
        Thread thread = new Thread(runnable);
        thread.start();

        final String value = PropertyManager.getProperty("thread.property");
        Assert.assertEquals(value, "1", "Thread Local property not overridden.");
    }

    @Test
    public void testT41_ClearThreadLocalProperty() {

        PropertyManager.getThreadLocalProperties().put("thread.property", "1");

        final Runnable runnable = () -> {
            PropertyManager.getThreadLocalProperties().put("thread.property", "runnable");
            Assert.assertEquals(PropertyManager.getProperty("thread.property"), "runnable", "Thread Local property not overridden.");
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "1", "Thread Local property not overridden.");

        PropertyManager.clearThreadlocalProperties();
        Assert.assertNull(PropertyManager.getThreadLocalProperties().getProperty("thread.property"), "Thread properties cleared.");
    }

    @Test()
    public void testT42_LoadThreadLocalPropertyFile() {

        PropertyManager.loadThreadLocalProperties("propertyfiles/threadlocal.properties");

        final Runnable runnable = () -> {
            PropertyManager.getThreadLocalProperties().put("thread.property", "runnable");
            Assert.assertEquals(PropertyManager.getProperty("thread.property"), "runnable", "Thread Local property not overridden.");
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "thread_file", "Thread Local property not overridden.");
    }

    @Test
    public void testT43_LocalPropertyOverrides() {

        PropertyManager.loadProperties("propertyfiles/file.properties");
        Assert.assertNull(PropertyManager.getThreadLocalProperties().getProperty("thread.property"));

        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "file", "Thread Local property not overridden.");

        PropertyManager.getThreadLocalProperties().put("thread.property", "new");
        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "new", "Thread Local property not overridden.");
    }

    @Test
    public void testT50_GetDifferentPropertyMaps() {

        PropertyManager.loadProperties("propertyfiles/file.properties");
        PropertyManager.loadThreadLocalProperties("propertyfiles/threadlocal.properties");

        Assert.assertEquals(PropertyManager.getThreadLocalProperties().getProperty("thread.property"), "thread_file");
        Assert.assertEquals(PropertyManager.getFileProperties().getProperty("thread.property"), "file");
        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "thread_file");

        // clear
        PropertyManager.clearThreadlocalProperties();
        Assert.assertNull(PropertyManager.getThreadLocalProperties().getProperty("thread.property"));

        PROPERTY_MANAGER.removeSystemProperty("thread.property");
        Assert.assertNull(PropertyManager.getGlobalProperties().getProperty("thread.property"));

        Assert.assertEquals(PropertyManager.getProperty("thread.property"), "file");
    }

    // Disabled because it will break everything
    @Test(enabled = false)
    public void testT51_ClearAllProperties() {

        PropertyManager.loadThreadLocalProperties("propertyfiles/threadlocal.properties");

        // clear -
        PropertyManager.clearProperties();
        Assert.assertNull(PropertyManager.getThreadLocalProperties().getProperty("thread.property"));
        Assert.assertNull(PropertyManager.getProperty("thread.property"));
    }

    @Test
    public void test_priority() {

        String property = "test";
        String expected = "huhu";

        Assert.assertEquals(PropertyManager.getProperty(property), expected);

        System.setProperty("test", "haha");

        Assert.assertNotEquals(PropertyManager.getProperty(property), expected);
    }

    @Test
    public void test_resolvePriorityProperty() {
        final String propertyKey = "any-property";
        final String expected = "I-have-been-resolved";

        PropertyManager.withResolvers(Collections.singletonList(property -> Optional.of(expected)), () -> {
            Assert.assertEquals(PropertyManager.getProperty(propertyKey), expected);
        });
        Assert.assertNull(PropertyManager.getProperty(propertyKey));
    }

    @Test
    public void test_WebDriverPropertyResolver() {
        String fakeBrowser = "fakeBrowser";
        String actualBrowser = "HeadlessChrome";
        String browserPropertyName = IWebDriverManager.Properties.BROWSER.toString();
        Assert.assertNotEquals(PropertyManager.getProperty(browserPropertyName), fakeBrowser);

        WebDriver webDriver = WebDriverManager.getWebDriver();

        PropertyManager.getThreadLocalProperties().setProperty(browserPropertyName, fakeBrowser);
        Assert.assertEquals(PropertyManager.getProperty(browserPropertyName), fakeBrowser);

        PropertyManager.withResolvers(Collections.singletonList(new WebDriverPropertyResolver(webDriver)), () -> {
            Assert.assertEquals(PropertyManager.getProperty(browserPropertyName), actualBrowser);
        });
    }
}
