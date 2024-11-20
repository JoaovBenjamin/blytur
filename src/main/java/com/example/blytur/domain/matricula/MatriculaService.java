package com.example.blytur.domain.matricula;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MatriculaService {

    @Autowired
    MatriculaRepositoy matriculaRepositoy;

    public List<Matricula> findAll() {
        return matriculaRepositoy.findAll();
    }

    public Matricula findMatricula(String name, String cpf) {
        if (cpf != null)
            return matriculaRepositoy.findByCpf(cpf);
        return matriculaRepositoy.findByName(name);
    }

    public Matricula closeMatricula(String cpf, String name) {

        Matricula matricula;

        if (cpf != null) {
            matricula = matriculaRepositoy.findByCpf(cpf);
        } else {
            matricula = matriculaRepositoy.findByName(name);
        }

        matricula.setStatus(StatusMatricula.INATIVO);

        return matriculaRepositoy.save(matricula);
    }

    public Matricula createMatricula(String name, String cpf) {
        var matricula = Matricula.builder()
                .cpf(cpf)
                .name(name)
                .status(StatusMatricula.ATIVA)
                .build();

        return matriculaRepositoy.save(matricula);
    }
}
