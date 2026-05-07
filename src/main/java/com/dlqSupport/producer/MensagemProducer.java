package com.dlqSupport.producer;

import com.dlqSupport.dto.FixedMessageDTO;
import com.dlqSupport.dto.RecoveryMessageDTO;
import com.dlqSupport.dto.producers.CozinhaPedidoDTO;
import com.dlqSupport.dto.producers.UpdatePedidoDTO;
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

    public void reenviarJson(FixedMessageDTO fixedMessageDTO) {
        System.out.println(fixedMessageDTO.mensagemCorrigida());
        //Object pedido = new CozinhaPedidoDTO();
        String exchange = "pedido-exchange";
        String routingKey = "pedido-key.pago";

        if(fixedMessageDTO.filaDeOrigem().equals("pedido-queue")) {
            routingKey = "pedido-key.update";
           // pedido = new UpdatePedidoDTO()
        }

        amqpTemplate.convertAndSend(
                exchange,
                routingKey,
                fixedMessageDTO.mensagemCorrigida()
        );

    }

}
