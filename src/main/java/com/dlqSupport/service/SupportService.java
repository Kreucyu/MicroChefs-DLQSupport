package com.dlqSupport.service;

import com.dlqSupport.producer.SupportProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SupportService {
    @Autowired
    private SupportProducer supportProducer;

    public void validarJson(String json) {
        System.out.println(json);
        supportProducer.resendJson(json);
    }

    public void invocarEditor(String json) throws IOException {
    }
}
