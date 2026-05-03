package com.dlqSupport.dto;

public record FixedMensagemDto(
        Long id,
        String mensagemCorrigida,
        String correcaoDocumentada
) {
}
