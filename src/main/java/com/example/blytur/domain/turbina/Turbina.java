package com.example.blytur.domain.turbina;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turbina")
@Builder
public class Turbina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String versao;
    String capacidade;

}
