package com.example.blytur.domain.turbina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurbinaRepository extends JpaRepository<Turbina, Long> {
    Turbina findByVersao(String versao);

    Turbina findByCapacidade(String capacidade);
}
