package com.example.blytur.domain.casa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blytur.domain.matricula.Matricula;

@Service
public class CasaService {
    
    @Autowired
    CasaRepository casaRepository;

    public List<Casa> findAll(){
        return casaRepository.findAll();
    }


    public Casa findCasa(String endereco, String cep){
        if(cep != null){
            return casaRepository.findByCep(cep);
        }
        return casaRepository.findByEndereco(endereco);
    }



    public Casa createCasa(String endereco, String cep, Matricula matricula){
        var casa = Casa.builder()
                            .cep(cep)
                            .endereco(endereco)
                            .matricula(matricula)
                            .build();

        return casaRepository.save(casa); 
    }

}
