package com.example.blytur.domain;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MatriculaRepositoy extends JpaRepository<Matricula, Long> {
    
    Matricula findByName(String name);
    Matricula findByCpf(String cpf);
}
