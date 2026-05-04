package com.dlqSupport.dto;

import jakarta.validation.constraints.NotNull;

public record FindMessageDTO(
        @NotNull long id,
        @NotNull String mensagemOriginal
) {
}
