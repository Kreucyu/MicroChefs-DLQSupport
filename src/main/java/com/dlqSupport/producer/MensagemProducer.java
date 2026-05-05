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

        String exchange = "pedido-exchange";
        String routingKey = "pedido-key.pago";

        if(recoveryMessageDTO.filaDeOrigem().equals("pedido-queue")) {
            routingKey = "pedido-key.update";
        }
        amqpTemplate.convertAndSend(
                exchange,
                routingKey,
                objectMapper.writeValueAsString(recoveryMessageDTO.mensagemCorrigida())
        );
    }

}
