package com.dlqSupport.service;
import com.dlqSupport.dto.RecoveryMensagemDto;
import com.dlqSupport.entities.Mensagem;
import com.dlqSupport.exception.MensagemNotFoundException;
import com.dlqSupport.producer.MensagemProducer;
import com.dlqSupport.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SupportService {
    @Autowired
    private MensagemProducer MensagemProducer;

    @Autowired
    private SupportRepository supportRepository;

    private void salvarMensagem(String mensagem) {
        Mensagem novaMensagem = new Mensagem();
        novaMensagem.setMensagemOriginal(mensagem);
        supportRepository.save(novaMensagem);
    }

    public void processarMensagem(String mensagem) {
        salvarMensagem(mensagem);
        iniciarEditor(getIdByMensagem(mensagem));
    }

    public RecoveryMensagemDto getMensagemById(Long id) {
        Mensagem mensagemDesejada = supportRepository.findById(id).orElse(null);
        if(mensagemDesejada == null) {
            throw new MensagemNotFoundException("Não foi encontrada mensagem com id" + id);
        }
        return new RecoveryMensagemDto(id, mensagemDesejada.getMensagemOriginal());
    }

    public Long getIdByMensagem(String mensagem) {
        return supportRepository.findByMensagemOriginal(mensagem).getId();
    }

    private void iniciarEditor(Long id) {

    }




}
