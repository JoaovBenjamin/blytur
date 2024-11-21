package com.example.blytur.domain.casa;

import com.example.blytur.domain.matricula.Matricula;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "casa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Casa {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String endereco;
    String cep;
    @ManyToOne
    Matricula matricula;
}
