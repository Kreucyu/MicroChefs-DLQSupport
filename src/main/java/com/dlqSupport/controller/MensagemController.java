package com.dlqSupport.controller;

import com.dlqSupport.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/archive")
public class MensagemController {

    @Autowired
    private SupportService supportService;

    @PostMapping
    public ResponseEntity<String> receberJson(String json) {
        supportService.validarJson(json);
        return ResponseEntity.ok("Recebido com sucesso!");
    }
}
