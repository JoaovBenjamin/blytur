package com.example.blytur.chat;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.example.blytur.domain.matricula.Matricula;
import com.example.blytur.domain.matricula.MatriculaForm;
import com.example.blytur.domain.matricula.MatriculaRequest;
import com.example.blytur.domain.matricula.MatriculaService;
import com.example.blytur.domain.turbina.Turbina;
import com.example.blytur.domain.turbina.TurbinaRequest;
import com.example.blytur.domain.turbina.TurbinaService;

@Configuration
public class ChatTools {

    @Autowired
    MatriculaService matriculaService;
    @Autowired
    TurbinaService turbinaService;

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
        return request -> matriculaService.createMatricula(request.name(), request.cpf());
    }

    @Bean
    @Description("Busca a turbina pela versao")
    public Function<TurbinaRequest, Turbina> findTurbina() {
        return request -> turbinaService.findTurbina(request.capacidade(), request.versao());
    }
}
