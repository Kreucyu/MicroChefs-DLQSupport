package com.dlqSupport.consumer;

import com.dlqSupport.service.SupportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SupportConsumer {

    @Autowired
    private SupportService supportService;

    @RabbitListener(queues = { "dead-letter-queue" })
    public void receberMensagem(@Payload String mensagem) throws IOException {
        supportService.processarMensagem(mensagem);
    }

}
