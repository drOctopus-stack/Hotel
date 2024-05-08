package com.api.hotel.hotel.model.entity;

import com.api.hotel.hotel.util.TipoQuartoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReservaQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numeroReserva;
    private String numeroQuarto;
    private String tipo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long totalDias;
    private Float valorTotal;
}
