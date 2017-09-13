/*
 * Copyright © 2017 liyp (liyp.yunpeng@gmail.com)
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
 */
//  The contents of this file are subject to the Mozilla Public License
//  Version 1.1 (the "License"); you may not use this file except in
//  compliance with the License. You may obtain a copy of the License
//  at http://www.mozilla.org/MPL/
//
//  Software distributed under the License is distributed on an "AS IS"
//  basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
//  the License for the specific language governing rights and
//  limitations under the License.
//
//  The Original Code is RabbitMQ.
//
//  The Initial Developer of the Original Code is GoPivotal, Inc.
//  Copyright (c) 2007-2015 Pivotal Software, Inc.  All rights reserved.
//


package com.rabbitmq.client.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ClientTests extends TestCase {
    public static TestSuite suite() {
        TestSuite suite = new TestSuite("client");
        suite.addTest(TableTest.suite());
        suite.addTest(BlockingCellTest.suite());
        suite.addTest(TruncatedInputStreamTest.suite());
        suite.addTest(AMQConnectionTest.suite());
        suite.addTest(ValueOrExceptionTest.suite());
        suite.addTest(BrokenFramesTest.suite());
        suite.addTest(ClonePropertiesTest.suite());
        suite.addTestSuite(Bug20004Test.class);
        suite.addTestSuite(CloseInMainLoop.class);
        suite.addTestSuite(ChannelNumberAllocationTests.class);
        suite.addTestSuite(QueueingConsumerShutdownTests.class);
        suite.addTestSuite(MultiThreadedChannel.class);
        suite.addTestSuite(com.rabbitmq.utility.IntAllocatorTests.class);
        suite.addTestSuite(AMQBuilderApiTest.class);
        suite.addTestSuite(AmqpUriTest.class);
        suite.addTestSuite(JSONReadWriteTest.class);
        suite.addTestSuite(SharedThreadPoolTest.class);
        return suite;
    }
}
