package com.example.blytur.domain.turbina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurbinaService {
    @Autowired
    TurbinaRepository turbinaRepository;
   
    public List<Turbina> findAll() {
        return turbinaRepository.findAll();
    }

    public Turbina createTurbina(String versao, String capacidade){
        var turbina = Turbina.builder()
                                    .capacidade(capacidade)
                                    .versao(versao)
                                    .build();

        return turbinaRepository.save(turbina);
    }
}
