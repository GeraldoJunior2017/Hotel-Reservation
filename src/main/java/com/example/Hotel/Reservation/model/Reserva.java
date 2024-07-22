package com.example.Hotel.Reservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String contato;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "quarto_id")
    @JsonManagedReference // Utilizado para serializar a relação com Quarto
    private Quarto quarto;

    private String detalhesPagamento;
    private String status; // Adicionado para armazenar o status da reserva

}
