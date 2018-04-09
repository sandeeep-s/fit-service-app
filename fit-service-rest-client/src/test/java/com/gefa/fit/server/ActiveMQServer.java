package com.gefa.fit.server;

import org.apache.activemq.broker.BrokerService;

public class ActiveMQServer {

    private static BrokerService broker;

    public static void startBroker() throws Exception{
        broker = new BrokerService();

        broker.addConnector("tcp://localhost:61616");

        broker.start();
    }

    public static void stopBroker() throws Exception{
        broker.stop();
    }
}
