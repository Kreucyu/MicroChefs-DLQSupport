package com.dlqSupport.service;

import com.dlqSupport.producer.MensagemProducer;
import com.dlqSupport.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SupportService {
    @Autowired
    private MensagemProducer supportProducer;

    @Autowired
    private SupportRepository supportRepository;

    public void salvarMensagem(String json) {

    }
}
