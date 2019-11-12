/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann
 *     pele
 */
package eu.tsystems.mms.tic.testframework.common;

import eu.tsystems.mms.tic.testframework.exceptions.TesterraSystemException;
import eu.tsystems.mms.tic.testframework.logging.Loggable;
import eu.tsystems.mms.tic.testframework.transfer.BooleanPackedResponse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Path Parser utility class.
 * <p/>
 * Created by peter on 01.09.14.
 */
public final class PropertiesParser implements Loggable {

    private static final Pattern patternReplace = Pattern.compile("\\{[^\\}]*\\}");
    private static final String REGEX_SENSIBLE = "@SENSIBLE@";
    private static final Pattern PATTERN_SENSIBLE = Pattern.compile(REGEX_SENSIBLE);

    public final List<Properties> properties = new LinkedList();

    /**
     * Parses a property and searches for testerra properties replacement marks: "{...}".
     * These marks will then be replaced by the property (if defined).
     * The replacement is recursive and has a loop detection.
     * Do the initial call with: parseLine(p, null).
     *
     * @param line            the current line.
     * @param searchedStrings a list of replacement marks already replaced (loop detection).
     *
     * @return the line with substitutions.
     */
    private String parseLine(String line, List<String> searchedStrings) {
        if (searchedStrings == null) {
            searchedStrings = new ArrayList<String>(1);
        }

        Matcher matcherReplace = patternReplace.matcher(line);
        List<String> matches = new ArrayList<String>(1);
        while (matcherReplace.find()) {
            String match = line.substring(matcherReplace.start(), matcherReplace.end());
            matches.add(match);
        }
        for (String match : matches) {
            String key = match.substring(1, match.length() - 1);

            /*
            Check for loop
             */
            if (searchedStrings.contains(key)) {
                throw new TesterraSystemException("Loop detected while replacing a property: " + match);
            } else {
                /*
                ask
                 */
                String value = pGetPrioritizedProperty(key);

                if (value == null) {
                    log().warn("Property " + match + " not found");
                } else {
                    // look if SENSIBLE
                    final BooleanPackedResponse<String> response = findAndVoidSENSIBLETag(value);
                    value = response.getResponse();
                    boolean sensible = response.getBoolean();

                    // 1. remember the key because it was replaced
                    List<String> listCopy = new ArrayList<String>(searchedStrings.size() + 1);
                    listCopy.addAll(searchedStrings);
                    // 2. check recursive replacements
                    listCopy.add(key);
                    value = parseLine(value, listCopy);
                    // 3. finally replace
                    line = line.replace(match, value);

                    if (sensible) {
                        value = "###########";
                    }
                    log().info("Replacing " + match + " with >" + value + "<");
                }
            }
        }
        return line;
    }

    private static BooleanPackedResponse<String> findAndVoidSENSIBLETag(String value) {
        if (value == null) {
            return new BooleanPackedResponse<String>(value, false);
        }
        final Matcher matcherSensible = PATTERN_SENSIBLE.matcher(value);
        if (matcherSensible.find()) {
            value = value.replaceAll(REGEX_SENSIBLE, "");
            return new BooleanPackedResponse<String>(value, true);
        }
        return new BooleanPackedResponse<String>(value, false);
    }

    /**
     * Parses a property and searches for properties replacement marks: "{...}".
     * These marks will then be replaced by the property (if defined).
     * The replacement is recursive and has a loop detection.
     *
     * @param line the current line.
     *
     * @return the line with substitutions.
     */
    public String parseLine(String line) {
        return parseLine(line, null);
    }

    public String getProperty(String key) {
        String value = pGetPrioritizedProperty(key);

        // replace marked system properties in this value (bla_{huhu} to bla_blubb if huhu=blubb)
        if (value != null) {
            value = parseLine(value);
        }

        /*
        replace residual control tags
         */
        final BooleanPackedResponse<String> response = findAndVoidSENSIBLETag(value);
        value = response.getResponse();

        return value;
    }

    public String getProperty(String key, Object defaultValue) {
        String value = getProperty(key);
        if (value == null || value.isEmpty()) {
            if (defaultValue != null) value = defaultValue.toString();
            else value = "";
        }
        return value;
    }

    private String pGetPrioritizedProperty(final String key) {
        String value = null;
        for (Properties property : properties) {
            value = property.getProperty(key, value);
        }
        return value;
    }

    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    public int getIntProperty(String key, Object defaultValue) {
        String prop = getProperty(key);
        if (prop == null) {
            prop = defaultValue.toString();
        }
        try {
            return Integer.parseInt(prop);
        } catch (final NumberFormatException e) {
            return (Integer)defaultValue;
        }
    }

    /**
     * Gets the value of the property identified by its key.
     *
     * @param key key of the property
     *
     * @return property value or -1 if value cannot be parsed.
     */
    public int getIntProperty(String key) {
       return getIntProperty(key, -1);
    }

    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    public double getDoubleProperty(String key, Object defaultValue) {
        String prop = getProperty(key);
        if (prop == null) {
            prop = defaultValue.toString();
        }
        try {
            return Double.parseDouble(prop);
        } catch (final NumberFormatException e) {
            return (Double)defaultValue;
        }
    }

    /**
     * Gets the value of the property identified by its key.
     *
     * @param key key of the property
     *
     * @return property value or -1 if value cannot be parsed or is not set.
     */
    public double getDoubleProperty(String key) {
        return getDoubleProperty(key, -1);
    }

    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    public long getLongProperty(String key, Object defaultValue) {
        String prop = getProperty(key);
        if (prop == null) {
            prop = defaultValue.toString();
        }
        try {
            return Long.parseLong(prop);
        } catch (final NumberFormatException e) {
            return (Long)defaultValue;
        }
    }

    /**
     * Gets the value of the property identified by its key.
     *
     * @param key key of the property
     *
     * @return property value or -1 if value cannot be parsed or is not set.
     */
    public long getLongProperty(String key) {
        return getLongProperty(key, -1);
    }

    /**
     * Get boolean property.
     *
     * @param key true or false.
     *
     * @return boolean property value or default false, if property is not set
     *
     * @see java.lang.Boolean#parseBoolean(String)
     */
    public boolean getBooleanProperty(String key) {
        return getBooleanProperty(key, false);
    }

    /**
     * Gets the value of the property or the default identified by its key.
     *
     * @param key          key of the property
     * @param defaultValue default value
     *
     * @return property value
     */
    public boolean getBooleanProperty(final String key, Object defaultValue) {
        String prop = getProperty(key);
        if (prop == null) {
            prop = defaultValue.toString();
        }
        return Boolean.parseBoolean(prop.trim());
    }

}
