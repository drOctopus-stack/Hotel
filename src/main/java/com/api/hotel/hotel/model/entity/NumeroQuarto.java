package com.api.hotel.hotel.model.entity;

import com.api.hotel.hotel.util.TipoQuartoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class NumeroQuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoQuarto;


    private String numero;

    private String ocupacao;
}
