package com.example.blytur.domain.leitura;

import java.time.LocalDateTime;

import com.example.blytur.domain.turbina.Turbina;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leitura")
public class Leitura {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime createdAt;
    @ManyToOne
    Turbina turbina;
    String producao; // Produção diaria em energia
    String velocidadeVento; // Velocidade do vento para geração de energia
}
