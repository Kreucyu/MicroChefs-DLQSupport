package com.dlqSupport.dto.producers;

import com.dlqSupport.entities.StatusPedido;

public record UpdatePedidoDTO(
        long id,
        StatusPedido statusPedido
) {
}
