package com.dlqSupport.consumer;

import com.dlqSupport.service.SupportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class SupportConsumer {

    @Autowired
    private SupportService supportService;

    public SupportConsumer(SupportService supportService) {
        this.supportService = supportService;
    }

    @RabbitListener(queues = { "dead-letter-queue" })
    public void receberMensagem(@Payload String mensagem) {
        supportService.processarMensagem(mensagem);
    }
}
