package com.gefa.fit;

import com.gefa.fit.application.infrastructure.ActiveMQ;
import com.gefa.fit.boundary.outbound.async.fit.JMSFacade;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.jms.ConnectionFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Singleton
public class Configuration {

    private static final Log LOG = LogFactory.getLog(JMSFacade.class);

    private long timeout = 20000;

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    private Properties properties;

    @PostConstruct
    private void postConstruct(){
        properties = new Properties();
        String propertiesFilePath = System.getProperty("properties.file");
        System.out.println("propertiesFilePath="+propertiesFilePath);
        Path path = Paths.get(propertiesFilePath);
        try {
            properties.load(new FileInputStream(path.toFile()));
        } catch (IOException e) {
            LOG.error("Error reading configuration properties", e);
            throw new RuntimeException("Error reading configuration properties", e);
        }

    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    @Produces
    @ActiveMQ
    public ConnectionFactory getAMQConnectionFactory() {

        String activemqUrl = getProperty("activemq.url");
        System.out.println("activemqUrl="+activemqUrl);
        System.out.println("ActiveMQConnectionFactory.DEFAULT_BROKER_URL="+ ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        return new ActiveMQConnectionFactory(activemqUrl);
    }

}
