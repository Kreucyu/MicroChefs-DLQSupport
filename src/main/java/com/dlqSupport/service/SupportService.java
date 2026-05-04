package com.dlqSupport.service;
import com.dlqSupport.dto.FixedMessageDTO;
import com.dlqSupport.dto.RecoveryMessageDTO;
import com.dlqSupport.entities.Mensagem;
import com.dlqSupport.exception.MensagemNotFoundException;
import com.dlqSupport.producer.MensagemProducer;
import com.dlqSupport.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportService {
    @Autowired
    private MensagemProducer MensagemProducer;

    @Autowired
    private SupportRepository supportRepository;

    public SupportService(SupportRepository supportRepository) {
        this.supportRepository = supportRepository;
    }

    public void processarMensagem(String mensagem) {
        salvarMensagem(mensagem);
        iniciarEditor(getIdByMensagem(mensagem));
    }

    private void salvarMensagem(String mensagem) {
        Mensagem novaMensagem = new Mensagem();
        novaMensagem.setMensagemOriginal(mensagem);
        System.out.println(novaMensagem);
        supportRepository.save(novaMensagem);
    }

    public void iniciarEditor(Long id) {
        System.out.println("\nACESSO AO EDITOR JSON: http://localhost:9091/mensagem/editor/" + id);
    }

    public void atualizarMensagem(FixedMessageDTO fixedMensagemDto) {
        Mensagem mensagemAtualizada = supportRepository.findById(fixedMensagemDto.id()).orElse(null);
        if(mensagemAtualizada == null) throw new MensagemNotFoundException("Não foi possível encontrar a mensagem");
        mensagemAtualizada.setCorrecaoDocumentada(fixedMensagemDto.correcaoDocumentada());
        mensagemAtualizada.setMensagemCorrigida(fixedMensagemDto.mensagemCorrigida());
    }


    public RecoveryMessageDTO getMensagemById(Long id) {
        Mensagem mensagemDesejada = supportRepository.findById(id).orElse(null);
        if(mensagemDesejada == null) throw new MensagemNotFoundException("Não foi encontrada mensagem com id" + id);
        return new RecoveryMessageDTO(id, mensagemDesejada.getMensagemOriginal());
    }

    public Long getIdByMensagem(String mensagem) {
        return supportRepository.findByMensagemOriginal(mensagem).getId();
    }
}
