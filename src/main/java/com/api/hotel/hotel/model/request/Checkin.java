package com.api.hotel.hotel.model.request;

import com.api.hotel.hotel.util.TipoQuartoEnum;
import lombok.Data;

import java.time.LocalDate;
@Data
public class Checkin {

    private String nome;
    private TipoQuartoEnum tipoQuarto;
    private LocalDate dataFinal;
}
