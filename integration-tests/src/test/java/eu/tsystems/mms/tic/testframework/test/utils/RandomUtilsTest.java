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
 package eu.tsystems.mms.tic.testframework.test.utils;

import eu.tsystems.mms.tic.testframework.testing.TesterraTest;
import eu.tsystems.mms.tic.testframework.utils.RandomUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomUtilsTest extends TesterraTest {

    private String stringContainsChars = "String contains not only ";
    private String stringLength = "String has not expected length";
    private String intMax = "Number is higher than expected maximum";
    private String intMin = "Number is lower than expected minimum";

    /**
     * checks if random string only contains a-z
     */
    @Test
    public void testT01_randomString() {
        String testString = RandomUtils.generateRandomString();

        String regex = "^[a-z]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(testString);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }


    /**
     * checks if random number only contains chars  0-9
     */
    @Test
    public void testT02_randomNumbers() {
        int length = 5;
        String number = RandomUtils.generateRandomNumber(length);

        Assert.assertEquals(length, 5, stringLength);

        String regex = "^[0-9]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(number);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }

    /**
     * checks if random number only contains chars  0-9
     */
    @Test
    public void testT03_randomNumbers() {
        int length = 27;
        String number = RandomUtils.generateRandomNumber(length);

        Assert.assertEquals(length, 27, stringLength);

        String regex = "^[0-9]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(number);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }

    /**
     * checks if random number only contains chars  0-9
     */
    @Test
    public void testT04_randomNumbersInt01() {
        int max = 1;
        Integer number = RandomUtils.generateRandomInt(max);

        Assert.assertTrue(number <= max, intMax);

        String a = "" + number;

        String regex = "^[0-9]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(a);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }

    /**
     * checks if random number only contains chars  0-9
     */
    @Test
    public void testT05_randomNumbersInt02() {
        int max = 10;
        Integer number = RandomUtils.generateRandomInt(max);

        Assert.assertTrue(number <= max, intMax);

        String a = "" + number;

        String regex = "^[0-9]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(a);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }

    /**
     * checks if random number only contains chars  0-9
     */
    @Test
    public void testT06_randomNumbersInt03() {

        int min = 10;
        int max = 20;

        final int number = RandomUtils.generateRandomInt(min, max);

        Assert.assertTrue(number >= min, intMin);
        Assert.assertTrue(number <= max, intMax);

        String a = "" + number;

        String regex = "^[0-9]";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(a);
        Assert.assertTrue(matcher.find(), stringContainsChars + regex);
    }

}
