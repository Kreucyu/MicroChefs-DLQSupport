package com.dlqSupport.dto;

import jakarta.validation.constraints.NotNull;

public record FindMessageDTO(
        @NotNull String mensagemOriginal,
        @NotNull String tipoMensagem,
        @NotNull String mensagemDeErro,
        @NotNull String filaDeOrigdem
) {
}
