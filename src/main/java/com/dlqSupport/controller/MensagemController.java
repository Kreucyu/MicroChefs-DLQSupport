package com.dlqSupport.controller;

import com.dlqSupport.dto.FixedMensagemDto;
import com.dlqSupport.exception.MensagemNotFoundException;
import com.dlqSupport.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private SupportService supportService;

    @PatchMapping("/reenviar")
    public ResponseEntity<String> reenviarMensagem(FixedMensagemDto fixedMensagemDto) {
        try {
            supportService.atualizarMensagem(fixedMensagemDto);
            return ResponseEntity.ok("Recebido com sucesso!");
        } catch (MensagemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + ", log: " + e);
        }
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<String> buscarMensagem(@PathVariable Long id) {
        try{
            return ResponseEntity.ok(supportService.getMensagemById(id).mensagemOriginal());
        } catch (MensagemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage() + ", log: "+ e);
        }
    }

    @GetMapping("/editor/{id}")
    public ModelAndView editorJson() {
        return new ModelAndView("index");
    }
}
