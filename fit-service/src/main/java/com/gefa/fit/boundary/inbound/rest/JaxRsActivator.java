package com.gefa.fit.boundary.inbound.rest;

import com.gefa.fit.boundary.inbound.rest.error.handlers.ExceptionHandler;
import com.gefa.fit.boundary.inbound.rest.error.handlers.NoSuchAssetExceptionHandler;
import com.gefa.fit.boundary.inbound.rest.resources.AssetResourceImpl;

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
        classes.add(AssetResourceImpl.class);
        classes.add(ExceptionHandler.class);
        classes.add(NoSuchAssetExceptionHandler.class);
        return classes;
    }

}
