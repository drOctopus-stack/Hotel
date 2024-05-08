package com.api.hotel.hotel.controller;

import com.api.hotel.hotel.model.entity.ReservaQuarto;
import com.api.hotel.hotel.model.entity.TipoQuarto;
import com.api.hotel.hotel.model.request.Checkin;
import com.api.hotel.hotel.service.CheckinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CheckinController {

    final CheckinService checkinService;

    @PostMapping("/check-in/hospede")
    public ResponseEntity<?> teste(@RequestBody Checkin checkin) throws Exception {
        ReservaQuarto reservaQuarto = checkinService.checkin(checkin);
        if (reservaQuarto == null) {

            String message= "Reserva nao efetuada por falta de vagas";
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } else {
            return ResponseEntity.ok(reservaQuarto);
        }
    }
}
