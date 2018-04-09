package com.gefa.fit.server;

import com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.ExceptionHandler;
import com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.NoSuchAssetExceptionHandler;
import com.gefa.fit.boundary.inbound.v0_0_0.rest.resources.AssetResourceImpl;
import org.eclipse.jetty.server.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.webapp.WebAppContext;

/**
 * UndertowServer class.
 *
 */
public class JettyServer {


    static final String APPLICATION_PATH = "/";
    static final String CONTEXT_ROOT = "/fit-asset-service";

	public static void startServer() throws Exception{

        final int port = 8082;
        final Server jetty = new Server(port);

		WebAppContext context = new WebAppContext();
    	context.setContextPath(CONTEXT_ROOT);
    	context.setResourceBase("WEB-INF");
    	context.setDescriptor("./src/main/webapp/WEB-INF/web.xml");
    	jetty.setHandler(context);

		jetty.start();
		jetty.join();


	}

    /**
	 * UndertowServer method.
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
	    startServer();
	}

	@ApplicationPath("/")
	public static class MyApp extends Application {

		@Override
		public Set<Class<?>> getClasses() {
			HashSet<Class<?>> classes = new HashSet<Class<?>>();
			classes.add(AssetResourceImpl.class);
			classes.add(ExceptionHandler.class);
			classes.add(NoSuchAssetExceptionHandler.class);
			return classes;
		}
	}

}
