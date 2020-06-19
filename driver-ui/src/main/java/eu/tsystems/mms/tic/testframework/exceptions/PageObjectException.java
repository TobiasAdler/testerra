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
 package eu.tsystems.mms.tic.testframework.exceptions;

/**
 * Runtime Exception indicating any unexpected behaviour of Page objects.
 *
 * @author pele
 *
 */
public class PageObjectException extends RuntimeException {

    /**
     * Default serial version UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Inherited Constructed, giving a message to the exception.
     *
     * @param message Message for exception.
     */
    public PageObjectException(final String message) {
        super(message);
    }

    /**
     * Inherited Constructor creating this exception by its cause and with a message.
     *
     * @param message Message for exception.
     * @param cause Cause of exception.
     */
    public PageObjectException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Inherited Constructor creating this exception by its cause.
     *
     * @param cause Cause of exception.
     */
    public PageObjectException(final Throwable cause) {
        super(cause);
    }
}
