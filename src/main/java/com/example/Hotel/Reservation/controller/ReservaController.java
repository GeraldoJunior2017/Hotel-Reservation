package com.example.Hotel.Reservation.controller;

import com.example.Hotel.Reservation.dto.ReservaDTO;
import com.example.Hotel.Reservation.model.Reserva;
import com.example.Hotel.Reservation.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/criar")
    public ResponseEntity<Reserva> criarReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            Reserva reserva = reservaService.criarReserva(reservaDTO);

            return ResponseEntity.ok(reserva);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/checkin/{id}")
    public ResponseEntity<Reserva> checkIn(@PathVariable Long id) {
        Reserva reserva = reservaService.checkIn(id);
        return ResponseEntity.ok(reserva);
    }

    @PostMapping("/checkout/{id}")
    public ResponseEntity<Reserva> checkOut(@PathVariable Long id) {
        Reserva reserva = reservaService.checkOut(id);
        return ResponseEntity.ok(reserva);
    }
}
