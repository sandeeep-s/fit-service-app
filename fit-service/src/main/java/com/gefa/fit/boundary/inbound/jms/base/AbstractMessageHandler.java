package com.gefa.fit.boundary.inbound.jms.base;

import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public abstract class AbstractMessageHandler implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageHandler.class);

    @Override
    public void onMessage(Message message) {
        try {

            logger.info("Received message from " + message.getJMSDestination());

            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                processMessage(txtMsg);
            }

        } catch (JMSException e) {
            logger.error("JMS Error", e);
        } catch (JsonSyntaxException e) {
            logger.error("Received a non-JSON message", e);
        }
    }

    protected abstract void processMessage(TextMessage message) throws JMSException;
}
