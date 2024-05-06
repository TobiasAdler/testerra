/*
 * Testerra
 *
 * (C) 2020, Mike Reiche, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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

package eu.tsystems.mms.tic.testframework.pageobjects;

public enum Attribute {
    CLASS("class"),
    ID("id"),
    NAME("name"),
    HREF("href"),
    TITLE("title"),
    VALUE("value"),
    STYLE("style"),
    ALT("alt"),
    SRC("src"),
    READONLY("readonly"),
    DISABLED("disabled"),
    ARIA_LABEL("aria-label"),
    ARIA_EXPANDED("aria-expanded")
    ;

    private final String attrib;

    Attribute(final String attrib) {
        this.attrib = attrib;
    }

    @Override
    public String toString() {
        return attrib;
    }
}
