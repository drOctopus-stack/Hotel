package com.api.hotel.hotel.model.entity;

import com.api.hotel.hotel.util.TipoQuartoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TipoQuarto {

    private  Integer qtd;

    private Float valorMax;

    private Float valorMin;

    private String tipo;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
