package com.dlqSupport.dto.producers;

import java.time.LocalDate;
import java.util.List;

public record CozinhaPedidoDTO(
        Long id,
        LocalDate dataDoPedido,
        List<CozinhaItemPedidoDTO> itens
) {
}
