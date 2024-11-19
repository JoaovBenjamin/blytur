package com.example.blytur.chat;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.example.blytur.domain.Matricula;
import com.example.blytur.domain.MatriculaForm;
import com.example.blytur.domain.MatriculaRequest;
import com.example.blytur.domain.MatriculaService;



@Configuration
public class ChatTools {
    
    @Autowired
    MatriculaService matriculaService;

    @Bean
    @Description("Encerrar matricula com o cliente")
    public Function<MatriculaRequest, Matricula> closeMatricula(){
        return request -> matriculaService.closeMatricula(request.cpf(), request.name());   
    }

    @Bean
    @Description("Busca a matricula do cliente pelo nome ou cpf")
    public Function<MatriculaRequest, Matricula> findMatricula(){
        return request -> matriculaService.findMatricula(request.name(), request.cpf());
    }

    @Bean
    @Description("Cria uma nova matricula com um cliente")
    public Function<MatriculaForm, Matricula> createMatricula(){
        return request -> matriculaService.createMatricula(request.name(),request.cpf());
    }
}

