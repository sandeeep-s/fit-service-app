package com.gefa.fit.boundary.inbound.jms;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

@ApplicationScoped
public class JmsCDIServletContextListener {

    @Inject
    private AssetEventMessageHandler assetEventMessageHandler;

    public void init(@Observes @Initialized(ApplicationScoped.class) ServletContext context) {
        System.out.println("Initialized ServletContext: " + context.getServletContextName());
        System.out.println("Inside context initialized assetEventMessageHandler="+assetEventMessageHandler);
        assetEventMessageHandler.startReceiving();
    }

    public void destroy(@Observes @Destroyed(ApplicationScoped.class) ServletContext context) {
        // Do stuff during webapp's shutdown.
    }
}
