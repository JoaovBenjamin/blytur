package com.example.blytur.domain.leitura;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blytur.domain.turbina.Turbina;

@Service
public class LeituraService {
    @Autowired
    LeituraRepository leituraRepository;

    public List<Leitura> findAll(){
        return leituraRepository.findAll();
    }

    public Leitura createLeitura(Turbina turbina, String producao, String velocidadeVento){
        var leitura = Leitura.builder()
                                .turbina(turbina)
                                .createdAt(LocalDateTime.now())
                                .producao(producao)
                                .velocidadeVento(velocidadeVento)
                                .build();

        return leituraRepository.save(leitura);
    }
}
