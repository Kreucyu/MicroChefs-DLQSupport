package com.dlqSupport.entities;

import java.util.List;
import java.util.Map;

public record CamposExigidos(
        String tipo,
        Boolean isObrigatorio,
        List<String> valoresPermitidos,
        Map<String, CamposExigidos> subValores
) {
}
