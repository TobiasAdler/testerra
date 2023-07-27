
package eu.tsystems.mms.tic.testframework.webdrivermanager;

/*
 * Testerra
 *
 * (C) 2020, Eric Kubenka, T-Systems Multimedia Solutions GmbH, Deutsche Telekom AG
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

import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.http.HttpClient;

import java.time.Duration;

/**
 * This Client Factory allows us to reduces timeouts of 3 HOURS to our custom timeouts.
 * This will help, to avoid blocking selenium commands.
 * <p>
 * Date: 21.11.2019
 * Time: 09:43
 *
 * @author Eric Kubenka
 */
class HttpClientFactory implements HttpClient.Factory {

    /** TODO: Delete or re-implement
     * This class was used to set a custom timeout for sending commands to browser sessions. Selenium 3 has a default of 120 minutes. This was reduced to 2 minutes.
     *
     * For using in Selenium 4 this class has to re-implement because Selenium 4 uses HttpClient of Java 11.
     * Selenium 4 has the following default timeouts: connectionTimeout=10sec, readTimeout=180 sec, seems to be ok
     */

    private final Duration factoryConnectionTimeout = Duration.ofSeconds(120); // Kill, when connect does not succeed in this timeout
    private final Duration factoryReadTimeout = factoryConnectionTimeout; // Kill hanging / stuck selenium commands after this timeout.

//    private final ConnectionPool pool = new ConnectionPool();

    // TODO: Just a placeholder
    @Override
    public HttpClient createClient(ClientConfig config) {
        return null;
    }

//    @Override
//    public HttpClient.Builder builder() {
//
//        // this code is copied from OkHttpClient.Factory .. and modified in timeout configuration.
//        return new HttpClient.Builder() {
//
//            @Override
//            public HttpClient createClient(URL url) {
//
//                connectionTimeout = factoryConnectionTimeout;
//                readTimeout = factoryReadTimeout;
//
//                okhttp3.OkHttpClient.Builder client = new okhttp3.OkHttpClient.Builder()
//                        .connectionPool(pool)
//                        .followRedirects(true)
//                        .followSslRedirects(true)
//                        .proxy(proxy)
//                        .readTimeout(readTimeout.toMillis(), MILLISECONDS)
//                        .connectTimeout(connectionTimeout.toMillis(), MILLISECONDS);
//
//                String info = url.getUserInfo();
//                if (!Strings.isNullOrEmpty(info)) {
//                    String[] parts = info.split(":", 2);
//                    String user = parts[0];
//                    String pass = parts.length > 1 ? parts[1] : null;
//
//                    String credentials = Credentials.basic(user, pass);
//
//                    client.authenticator((route, response) -> {
//                        if (response.request().header("Authorization") != null) {
//                            return null; // Give up, we've already attempted to authenticate.
//                        }
//
//                        return response.request().newBuilder()
//                                .header("Authorization", credentials)
//                                .build();
//                    });
//                }
//
//                client.addNetworkInterceptor(chain -> {
//                    Request request = chain.request();
//                    Response response = chain.proceed(request);
//                    return response.code() == 408
//                            ? response.newBuilder().code(500).message("Server-Side Timeout").build()
//                            : response;
//                });
//
//                return new org.openqa.selenium.remote.internal.OkHttpClient(client.build(), url);
//            }
//        };
//    }
//
//    @Override
//    public HttpClient createClient(URL url) {
//
//        return builder().createClient(url);
//    }
//
//    @Override
//    public void cleanupIdleClients() {
//
//        pool.evictAll();
//    }
}
