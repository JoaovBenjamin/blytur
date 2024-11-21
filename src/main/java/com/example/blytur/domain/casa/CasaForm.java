package com.example.blytur.domain.casa;

import com.example.blytur.domain.matricula.Matricula;

public record CasaForm(
    String endereco,
    String cep,
    Matricula matricula
) {
    
}
