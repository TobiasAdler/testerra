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
package eu.tsystems.mms.tic.testframework.test.utils;

import eu.tsystems.mms.tic.testframework.core.server.StaticServer;
import java.net.BindException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServerTest {

    private StaticServer staticServer;

    @Test
    public void test_StartServer() throws Exception {
        staticServer = new StaticServer();
        staticServer.start(1234);
    }

    @Test(dependsOnMethods = "test_StartServer")
    public void test_AlreadyStartedServer() throws Exception{
        StaticServer newStaticServer = new StaticServer();
        try {
            newStaticServer.start(1234);
        } catch (BindException e) {
            Assert.assertEquals(newStaticServer.getPort(), 1234);
        }
    }

    @Test
    public void test_NewRandomPort() throws Exception {
        StaticServer newStaticServer = new StaticServer();
        newStaticServer.start();
        Assert.assertTrue(newStaticServer.getPort() > 0);
    }
}
