package com.example.Hotel.Reservation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {
    private Long hotelId;
    private Long quartoId;
    private String nome;
    private String contato;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private String detalhesPagamento;
}