package com.gefa.fit.boundary.inbound.jms;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class JMSServletContextListener implements ServletContextListener
{

    @Inject
    private AssetEventMessageHandler assetEventMessageHandler;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Inside context initialized assetEventMessageHandler="+assetEventMessageHandler);
        assetEventMessageHandler.startReceiving();

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
