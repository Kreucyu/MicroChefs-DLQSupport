package com.dlqSupport.producer;

import com.dlqSupport.dto.RecoveryMessageDTO;
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

    public void reenviarJson(RecoveryMessageDTO recoveryMessageDTO) {
        amqpTemplate.convertAndSend(
                "pedido-exchange",
                "pedido-key.pago",
                objectMapper.writeValueAsString(recoveryMessageDTO.mensagemCorrigida())
        );
    }

}
