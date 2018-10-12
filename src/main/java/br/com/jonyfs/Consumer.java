package br.com.jonyfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${queue.a}")
    public void processMessageA(@Payload final Message<MyMessage> message) {
        LOGGER.info("Processing {} in queue a", message.getPayload());
    }

    @JmsListener(destination = "${queue.b}")
    public void processMessageB(@Payload String message) {
        LOGGER.info("Processing {}  in queue b", message);
    }

}
