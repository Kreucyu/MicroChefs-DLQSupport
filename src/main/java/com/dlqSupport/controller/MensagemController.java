package com.dlqSupport.controller;

import com.dlqSupport.dto.FakeMensagemDto;
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

    public MensagemController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PatchMapping("/reenviar")
    public ResponseEntity<String> reenviarMensagem(@RequestBody FixedMensagemDto fixedMensagemDto) {
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

    @PostMapping("/fake")
    public ResponseEntity<String> fakeMessage(@RequestBody FakeMensagemDto fakeMensagemDto) {
        supportService.processarMensagem(fakeMensagemDto.mensagemOriginal());
        return ResponseEntity.ok("recebido");
    }
}
