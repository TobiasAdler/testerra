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
 *     Peter Lehmann <p.lehmann@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
/*
 * Created on 02.05.2014
 *
 * Copyright(c) 1995 - 2013 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package eu.tsystems.mms.tic.testframework.utils;

import eu.tsystems.mms.tic.testframework.common.PropertyManager;
import eu.tsystems.mms.tic.testframework.common.FennecCommons;
import eu.tsystems.mms.tic.testframework.constants.FennecProperties;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * <Beschreibung der Klasse>
 *
 * @author pele
 */
public final class SourceUtils {

    private SourceUtils() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SourceUtils.class);

    private static String sourceRoot = System.getProperty(FennecProperties.MODULE_SOURCE_ROOT, "src");
    private static int linePrefetch = PropertyManager.getIntProperty(FennecProperties.SOURCE_LINES_PREFETCH, 5);
    private static final boolean FIND_SOURCES = PropertyManager.getBooleanProperty(FennecProperties.REPORT_ACTIVATE_SOURCES, true);
    private static HashMap<Class, List<String>> cachedClassNames = new HashMap<Class, List<String>>();
    private static final String PACKAGE_SCOPE = PropertyManager.getProperty(FennecProperties.PROJECT_PACKAGE,
            FennecCommons.DEFAULT_PACKAGE_NAME);

    public static String findScriptSourceForThrowable(Throwable throwable) {
        if (!FIND_SOURCES) {
            return null;
        }

        StackTraceElement[] stackTrace = throwable.getStackTrace();
        String className = null;
        String fileName = null;
        String methodName = null;
        int lineNumber = 0;
        boolean inDefaultPackageSection = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().startsWith(FennecCommons.DEFAULT_PACKAGE_NAME)) {
                className = stackTraceElement.getClassName();
                fileName = stackTraceElement.getFileName();
                lineNumber = stackTraceElement.getLineNumber();
                methodName = stackTraceElement.getMethodName();
                inDefaultPackageSection = true;
            }
            else {
                if (inDefaultPackageSection) {
                    /*
                    beeing here means, to be in the first line after the default package section
                    so we stop searching
                     */
                    break;
                }
            }
        }

        if (!ObjectUtils.isNull(className, fileName, methodName)) {
            return findFileAndShowSource(className, fileName, methodName, lineNumber);
        }
        return null;
    }

    /**
     * Print part of source of *callerSubClass* if stacktrace contains a failure of *classWithFailure* in
     * *callerSubClass*.
     *
     * Only for internal use!
     *
     * @param throwable .
     * @param classWithFailure .
     * @param callerSubClass .
     * @return .
     */
    public static String findSourceForThrowable(Throwable throwable, Class classWithFailure, Class callerSubClass) {
        if (!FIND_SOURCES) {
            return null;
        }

        // is class in throwable??
        int causeNumberForClass = getCauseNumberForClass(throwable, classWithFailure, 0);
        if (causeNumberForClass == -1) {
             return null;
        }

        // search for caller
        List<String> classNames;
        if (!cachedClassNames.containsKey(callerSubClass)) {
            classNames = findClassNamesForSubTypesOf(callerSubClass);
            cachedClassNames.put(callerSubClass, classNames);
        }
        else {
            classNames = cachedClassNames.get(callerSubClass);
            if (classNames.size() == 0) {
                classNames = findClassNamesForSubTypesOf(callerSubClass);
                cachedClassNames.remove(callerSubClass);
                cachedClassNames.put(callerSubClass, classNames);
            }
        }

        if (classNames.size() == 0) {
            return null;
        }

        return findCallerSubclassInThrowable(throwable, classNames, 0, causeNumberForClass);
    }

    private static String findCallerSubclassInThrowable(Throwable throwable, List classNames,
                                                        int causeCounter, int fromCauseNumber) {
        if (causeCounter >= fromCauseNumber) {
            StackTraceElement[] stackTrace = throwable.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (classNames.contains(className)) {
                    return findFileAndShowSource(className, stackTraceElement.getFileName(),
                            stackTraceElement.getMethodName(), stackTraceElement.getLineNumber());
                }
            }
        }
        Throwable cause = throwable.getCause();
        causeCounter++;
        if (cause != null) {
            return findCallerSubclassInThrowable(cause, classNames, causeCounter, fromCauseNumber);
        }

        return null;
    }

    private static int getCauseNumberForClass(Throwable throwable, Class clazz, int counter) {
        String classname = clazz.getName();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement.getClassName().equals(classname)) {
                return counter;
            }
        }
        Throwable cause = throwable.getCause();
        if (cause != null) {
            counter++;
            return getCauseNumberForClass(cause, clazz, counter);
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    private static List<String> findClassNamesForSubTypesOf(Class clazz) {
        List<String> classnames = new ArrayList<String>();
        Reflections reflections = new Reflections(PACKAGE_SCOPE);
        Set<Class> subTypesOf = reflections.getSubTypesOf(clazz);
        for (Class aClass : subTypesOf) {
            classnames.add(aClass.getName());
        }
        return classnames;
    }

    private static String findFileAndShowSource(String className, String filename, String methodName, int lineNr) {
        String filePath = className.replace(".", "/").concat(".java");
        File file;
        file = new File(sourceRoot + "/main/java/" + filePath);
        StringBuilder source = null;

        if (file.exists()) {
            LOGGER.debug("Found file in main/java");
            source = getSource(file, lineNr);
        }
        else {
            file = new File(sourceRoot + "/test/java/" + filePath);
            if (file.exists()) {
                LOGGER.debug("Found file in test/java");
                source = getSource(file, lineNr);
            }
        }

        if (source != null) {
            LOGGER.debug("Found source:\n" + source);
            String code = source.toString().replace("\n", "<br>");
            String codeTagBody = "<pre><br>" +
                    "<code>" +
                    filename + ":" + lineNr + "  &#8597; " + StringUtils.prepareStringForHTML(methodName) + "\n" +
                    "</code>\n" +
                    "<code>" + code + "</code><br>" +
                    "</pre>";
            return codeTagBody;
        }
        else {
            LOGGER.warn("Did not find source for " + filename + " in " + sourceRoot);
            return null;
        }
    }

    private static StringBuilder getSource(File file, int lineNr) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            int lineCounter = 1;
            int startAtLine = lineNr - linePrefetch;
            if (startAtLine < 1) {
                startAtLine = 1;
            }
            while (line != null) {
                if (lineCounter >= startAtLine && lineCounter < lineNr) {
                    /*
                    LINE
                     */
                    sb.append("  " + lineCounter + ": " + line + "\n");
                }
                else if (lineCounter == lineNr) {
                    /*
                    LINE WITH ISSUE
                     */
                    sb.append("&#8623; " + lineCounter + ": " + line + "\n");
                } else if (lineCounter > lineNr) {
                    // stop
                    br.close();

                    // make public
                    return sb;
                }

                // read next line
                line = br.readLine();
                lineCounter++;
            }
            br.close();
        }
        catch (IOException e) {
            LOGGER.warn("Error reading source of " + file.getName(), e);
        }
        return null;
    }

}
