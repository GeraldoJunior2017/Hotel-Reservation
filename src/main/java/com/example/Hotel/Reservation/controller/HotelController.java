package com.example.Hotel.Reservation.controller;

import com.example.Hotel.Reservation.model.Hotel;
import com.example.Hotel.Reservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;




@RestController
@RequestMapping("/hoteis")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    @GetMapping("/pesquisar")
    public ResponseEntity<List<Hotel>> pesquisarHoteis(
            @RequestParam(value = "destino", required = false) String destino,
            @RequestParam(value = "numQuartos", required = false) Integer munQuartos,
            @RequestParam(value = "numHospedes", required = false) Integer numHospedes,
            @RequestParam(value = "minAvaliacao", required = false) Double minAvaliacao,
            @RequestParam(value = "dataCheckIn", required = false) LocalDate dataCheckIn,
            @RequestParam(value = "dataCheckOut", required = false) LocalDate dataCheckOut){

        List<Hotel> hoteis = hotelService.pesquisarHoteis(destino,munQuartos, numHospedes, minAvaliacao,dataCheckIn,dataCheckOut);
        return ResponseEntity.ok(hoteis);
    }




    @GetMapping("/comparar")
    public ResponseEntity<List<Hotel>> compararHoteis(
            @RequestParam(value = "minPreco", required = false) Double minPreco,
            @RequestParam(value = "maxPreco", required = false) Double maxPreco,
            @RequestParam(value = "localizacao", required = false) String localizacao,
            @RequestParam(value = "comodidades", required = false) String comodidades,
            @RequestParam(value = "minAvaliacao", required = false) Double minAvaliacao

    )
    {
        List<Hotel> hoteis = hotelService.compararHoteis(minPreco, maxPreco, localizacao, comodidades, minAvaliacao);
        return ResponseEntity.ok(hoteis);
    }
}


