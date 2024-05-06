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
package eu.tsystems.mms.tic.testframework.mailconnector.util;

import jakarta.mail.search.AndTerm;
import jakarta.mail.search.OrTerm;
import jakarta.mail.search.SearchTerm;

/**
 * @deprecated Use implementations of {@link SearchTerm} and combine them with {@link AndTerm} or {@link OrTerm} instead.
 */
@Deprecated
public class SearchCriteria {

    private final SearchCriteriaType searchCriteriaType;
    private final Object value;

    /**
     * Create search criteria
     *
     * @param searchCriteriaType {@link SearchCriteriaType}
     * @param value java.util.Date for {@link SearchCriteriaType#AFTER_DATE}, String for others.
     */
    public SearchCriteria(SearchCriteriaType searchCriteriaType, Object value) {
        this.searchCriteriaType = searchCriteriaType;
        this.value = value;
    }

    public SearchCriteriaType getSearchCriteriaType() {
        return searchCriteriaType;
    }

    public Object getValue() {
        return value;
    }

    /**
     * @return value as String or Runtime exception if it's not a string.
     */
    public String getStringValue() {
        if(!(value instanceof String)) {
            throw new RuntimeException("Expect String value for SearchCriteria of type " + searchCriteriaType.name());
        }
        return (String) value;
    }
}
