package com.gefa.fit.server;

import com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.ExceptionHandler;
import com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.NoSuchAssetExceptionHandler;
import com.gefa.fit.boundary.inbound.v0_0_0.rest.resources.AssetResourceImpl;
import io.undertow.server.handlers.resource.ClassPathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * UndertowServer class.
 *
 */
public class UndertowServer {

	public static UndertowJaxrsServer startServer() {
		System.setProperty("org.jboss.resteasy.port", "8082");
		UndertowJaxrsServer server = new UndertowJaxrsServer().start();

		ResteasyDeployment deployment = new ResteasyDeployment();
		deployment.setInjectorFactoryClass("org.jboss.resteasy.cdi.CdiInjectorFactory");
		deployment.setApplicationClass(MyApp.class.getName());
		DeploymentInfo di = server.undertowDeployment(deployment);
		di.setClassLoader(UndertowServer.class.getClassLoader());
		di.setResourceManager(new ClassPathResourceManager(UndertowServer.class.getClassLoader()));
		di.setContextPath("/fit-asset-service");
		di.setDeploymentName("DI");
		di.addListeners(Servlets.listener(org.jboss.weld.environment.servlet.Listener.class));
//		di.addListener(Servlets.listener(JMSServletContextListener.class));
		server.deploy(di);
		return server;
	}

	/**
	 * UndertowServer method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final UndertowJaxrsServer server = startServer();
		System.out.println(String.format("Resteasy app started \nHit enter to stop it..."));
		System.in.read();
		server.stop();
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
