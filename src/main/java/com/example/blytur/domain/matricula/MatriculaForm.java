package com.example.blytur.domain.matricula;

import com.example.blytur.domain.turbina.Turbina;

public record MatriculaForm(
        String name,
        String cpf,
        Turbina turbina) {

}
