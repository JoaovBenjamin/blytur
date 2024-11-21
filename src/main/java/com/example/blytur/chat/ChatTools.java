package com.example.blytur.chat;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.example.blytur.domain.casa.Casa;
import com.example.blytur.domain.casa.CasaForm;
import com.example.blytur.domain.casa.CasaRequest;
import com.example.blytur.domain.casa.CasaService;
import com.example.blytur.domain.leitura.Leitura;
import com.example.blytur.domain.leitura.LeituraForm;
import com.example.blytur.domain.leitura.LeituraService;
import com.example.blytur.domain.matricula.Matricula;
import com.example.blytur.domain.matricula.MatriculaForm;
import com.example.blytur.domain.matricula.MatriculaRequest;
import com.example.blytur.domain.matricula.MatriculaService;
import com.example.blytur.domain.turbina.Turbina;
import com.example.blytur.domain.turbina.TurbinaForm;
import com.example.blytur.domain.turbina.TurbinaService;

@Configuration
public class ChatTools {

    @Autowired
    MatriculaService matriculaService;
    @Autowired
    TurbinaService turbinaService;
    @Autowired
    CasaService casaService;
    @Autowired
    LeituraService leituraService;

    @Bean
    @Description("Encerrar matricula com o cliente")
    public Function<MatriculaRequest, Matricula> closeMatricula() {
        return request -> matriculaService.closeMatricula(request.cpf(), request.name());
    }

    @Bean
    @Description("Busca a matricula do cliente pelo nome ou cpf")
    public Function<MatriculaRequest, Matricula> findMatricula() {
        return request -> matriculaService.findMatricula(request.name(), request.cpf());
    }

    @Bean
    @Description("Cria uma nova matricula com um cliente")
    public Function<MatriculaForm, Matricula> createMatricula() {
        return request -> matriculaService.createMatricula(request.name(), request.cpf(), request.turbina());
    }

    @Bean
    @Description("Cria turbina para o cliente")
    public Function<TurbinaForm, Turbina> createTurbina() {
        return request -> turbinaService.createTurbina(request.versao(), request.capacidade());
    }

    @Bean
    @Description("Cria casa de um cliente")
    public Function<CasaForm, Casa> createCasa(){
        return request -> casaService.createCasa(request.endereco(),request.cep(),request.matricula());
    }

    @Bean
    @Description("Procura a localização da casa de um cliente")
    public Function<CasaRequest, Casa> findCasa(){
        return request -> casaService.findCasa(request.endereco(), request.cep());        
    }

    @Bean
    @Description("Cria a leitura da turbina relacionada ao cliente")
    public Function <LeituraForm, Leitura> createLeitura(){
        return request -> leituraService.createLeitura(request.turbina(), request.producao(),request.velocidadeVento());
    }
  
}
