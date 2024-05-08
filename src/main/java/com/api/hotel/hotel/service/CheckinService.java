package com.api.hotel.hotel.service;

import com.api.hotel.hotel.model.entity.NumeroQuarto;
import com.api.hotel.hotel.model.entity.ReservaQuarto;
import com.api.hotel.hotel.model.entity.TipoQuarto;
import com.api.hotel.hotel.model.request.Checkin;
import com.api.hotel.hotel.repository.NumeroQuartoRepository;
import com.api.hotel.hotel.repository.ReservaQuartoRepository;
import com.api.hotel.hotel.repository.TipoQuartoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class CheckinService {
    final TipoQuartoRepository tipoQuartoRepository;
    final NumeroQuartoRepository numeroQuartoRepository;
    final ReservaQuartoRepository reservaQuartoRepository;

    public ReservaQuarto checkin(Checkin checkin) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Long totalDias = ChronoUnit.DAYS.between( LocalDate.now(),checkin.getDataFinal());

        //obter os valores e qtd disponives do quarto atraves do tipo
        TipoQuarto tipoQuarto = tipoQuartoRepository.findByTipo(checkin.getTipoQuarto().name());

        //se quantidade de quartos forem maiores q 0 prosseguir com a reserva
        if (tipoQuarto.getQtd() > 0) {

            //obter a numeracao do primeiro quarto disponivel de acordo com o tipo
            NumeroQuarto numeroQuarto = numeroQuartoRepository.findFirstByTipoQuartoAndOcupacao(checkin.getTipoQuarto().name(),"N");

            ReservaQuarto reservaQuarto = ReservaQuarto.builder()
                    .nome(checkin.getNome())
                    .numeroReserva(String.valueOf(timestamp.getTime()))
                    .numeroQuarto(numeroQuarto.getNumero())
                    .tipo(checkin.getTipoQuarto().name())
                    .dataInicio(LocalDate.now())
                    .dataFim(checkin.getDataFinal())
                    .totalDias(totalDias)
                    .valorTotal(resultadoValorTotal(tipoQuarto.getValorMin(), tipoQuarto.getValorMax(), totalDias))
                    .build();

            //com essa reserva o quarto estara ocupado devera ser flegado com 'S'
            numeroQuarto.setOcupacao("S");

            //diminuir em 1 a qtd de quartos disponives para o tipo de quarto escolhido
            tipoQuarto.setQtd(tipoQuarto.getQtd() - 1);

            //salvar a reserva
            reservaQuartoRepository.save(reservaQuarto);

            // salvar aquele numero de quarto que agora esta ocupado
            numeroQuartoRepository.save(numeroQuarto);

            // salvar diminuir em 1 a qtd de quartos disponives para aquele tipo de quarto
            tipoQuartoRepository.save(tipoQuarto);

            return reservaQuarto;

        }
        return null;


    }

    public static float resultadoValorTotal(Float valorMin, Float valorMax, Long totalDias) {
        LocalDate ld = LocalDate.now();
        DayOfWeek d = ld.getDayOfWeek();
        String indicador = (d == DayOfWeek.SATURDAY || d == DayOfWeek.FRIDAY ||
                d == DayOfWeek.SUNDAY || d == DayOfWeek.THURSDAY) ? "alta" : "baixa";
        if (indicador.equals("alta")) {
            return totalDias * valorMax;
        } else {
            return totalDias * valorMin;
        }

    }


}
