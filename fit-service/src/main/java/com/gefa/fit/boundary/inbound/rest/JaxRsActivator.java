package com.gefa.fit.boundary.inbound.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * JaxRs Configuration.
 * 
 * 
 */
@ApplicationPath("/")
public class JaxRsActivator extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(com.gefa.fit.boundary.inbound.rest.resources.AssetResourceImpl.class);
/*
        classes.add(com.gefa.fit.boundary.inbound.rest.error.handlers.ExceptionHandler.class);
        classes.add(com.gefa.fit.boundary.inbound.rest.error.handlers.NoSuchAssetExceptionHandler.class);
*/

        classes.add(com.gefa.fit.boundary.inbound.v0_0_0.rest.resources.AssetResourceImpl.class);
/*
        classes.add(com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.ExceptionHandler.class);
        classes.add(com.gefa.fit.boundary.inbound.v0_0_0.rest.error.handlers.NoSuchAssetExceptionHandler.class);
*/

        return classes;
    }

}
