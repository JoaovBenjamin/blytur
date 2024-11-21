package com.example.blytur.domain.casa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CasaRepository extends JpaRepository<Casa, Long>{
    
    Casa findByEndereco(String endereco);
    Casa findByCep(String cep);
} 