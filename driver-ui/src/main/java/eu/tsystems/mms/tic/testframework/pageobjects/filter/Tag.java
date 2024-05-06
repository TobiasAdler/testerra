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
 package eu.tsystems.mms.tic.testframework.pageobjects.filter;

import java.util.function.Predicate;
import org.openqa.selenium.WebElement;

@Deprecated
public class Tag implements Predicate<WebElement> {

    private String expectedTag;
    private StringChecker stringChecker;

    Tag() {}

    private Tag(String expectedTag, StringChecker stringChecker) {
        if (expectedTag == null) {
            throw new IllegalArgumentException("Tag can not be required to be null.");
        }
        this.expectedTag = expectedTag;
        this.stringChecker = stringChecker;
    }

    public Predicate<WebElement> is(String expectedTag) {
        Tag tag = new Tag(expectedTag, new StringChecker.Is());
        return tag;
    }

    public Predicate<WebElement> isNot(String expectedTag) {
        Tag tag = new Tag(expectedTag, new StringChecker.IsNot());
        return tag;
    }

    public Predicate<WebElement> contains(String expectedTag) {
        Tag tag = new Tag(expectedTag, new StringChecker.Contains());
        return tag;
    }

    public Predicate<WebElement> containsNot(String expectedTag) {
        Tag tag = new Tag(expectedTag, new StringChecker.ContainsNot());
        return tag;
    }

    @Override
    public boolean test(WebElement webElement) {
        String tag = webElement.getTagName();
        return stringChecker.check(expectedTag, tag);
    }

    @Override
    public String toString() {
        return String.format(stringChecker.toString(), "Tag", expectedTag);
    }
}
