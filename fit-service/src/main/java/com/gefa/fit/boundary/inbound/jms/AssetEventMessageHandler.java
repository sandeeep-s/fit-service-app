package com.gefa.fit.boundary.inbound.jms;

import com.gefa.fit.application.infrastructure.ActiveMQ;
import com.gefa.fit.boundary.AbstractTransferObject;
import com.gefa.fit.boundary.inbound.jms.base.AbstractMessageHandler;
import com.gefa.fit.boundary.inbound.jms.base.Configuration;
import com.gefa.fit.boundary.inbound.jms.events.AssetEvent;
import com.google.gson.JsonSyntaxException;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.*;


/*
@MessageDriven(name = "AssetEventMessageHandler", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "assetq.create"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
*/
@ApplicationScoped
public class AssetEventMessageHandler extends AbstractMessageHandler implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageHandler.class);

    @Inject
    @ActiveMQ
    private ConnectionFactory  connectionFactory;

    @Inject
    private Configuration configuration;

/*
    @Produces
    @ActiveMQ
    public ConnectionFactory getConnectionFactory() {
        return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    }
*/

    @Inject
    private AssetEventAdapter assetEventAdapter;

    @Override
    protected void processMessage(TextMessage message) throws JMSException {

        try {
            String jsonString = message.getText();
            AssetEvent assetEvent = AbstractTransferObject.fromJson(jsonString, AssetEvent.class);
            assetEventAdapter.handleEvent(assetEvent);
        } catch (JsonSyntaxException e) {

        }
    }

    @Override
    public void run() {
        System.out.println("Inside run method");
        startReceiving();
    }

    public void startReceiving(){
        logger.info("Inside startReceiving method ActiveMQConnection.DEFAULT_BROKER_URL="+ActiveMQConnection.DEFAULT_BROKER_URL);
        Connection connection = null;
        Session session = null;
        try {

            connection = connectionFactory.createConnection();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("assetq.create");

            MessageConsumer consumer = session.createConsumer(destination);

            consumer.setMessageListener(this);

            connection.start();


        }catch(JMSException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
