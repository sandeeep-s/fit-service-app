package com.gefa.fit.server;

import org.eclipse.jetty.jmx.MBeanContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * UndertowServer class.
 *
 */
public class JettyServer {


    static final String APPLICATION_PATH = "/";
    static final String CONTEXT_ROOT = "/fit-asset-service";

    private static Server server;

    public static void stopServer() throws Exception{
        server.stop();
    }

	public static void startServer() throws Exception{

        final int port = 8082;
        server = new Server(port);
        server.setStopAtShutdown(true);
		MBeanContainer mbContainer = new MBeanContainer(ManagementFactory.getPlatformMBeanServer());
		server.addBean(mbContainer);

		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath(CONTEXT_ROOT);
        File warFile = new File("../fit-service/target/fit-service.war");
        if (!warFile.exists())
        {
            throw new RuntimeException( "Unable to find WAR File: "+warFile.getAbsolutePath());
        }
        webapp.setWar(warFile.getAbsolutePath());

		server.setHandler(webapp);
		server.start();

		//The test was not getting executed due to below call
		//server.join();


	}

}
