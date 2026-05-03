package com.dlqSupport.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class MensagemProducer {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void reenviarJson(String json) {
        amqpTemplate.convertAndSend(
                "pedido-exchange",
                "pedido-key.pago",
                objectMapper.writeValueAsString(json)
        );
    }

}
