package com.example.blytur.domain.leitura;

import com.example.blytur.domain.turbina.Turbina;

public record LeituraForm(
    String velocidadeVento,
    String producao,
    Turbina turbina
) {
    
}
