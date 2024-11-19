package com.example.blytur.domain;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank(message = "O nome não pode estar vazio")
    String name;
    @CPF(message = "O numero de cpf deve ser válido")
    String cpf;
    @Enumerated(EnumType.STRING)
    StatusMatricula status;
}
