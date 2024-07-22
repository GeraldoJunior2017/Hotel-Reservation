package com.example.Hotel.Reservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    @JsonBackReference
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    @JsonBackReference
    private Reserva reserva;

    private String numero;
    private String tipo;
    private Double valorDiaria;

    public Quarto(Long id, Hotel hotel, String numero, String tipo, Double valorDiaria) {
        this.id = id;
        this.hotel = hotel;
        this.numero = numero;
        this.tipo = tipo;
        this.valorDiaria = valorDiaria;
    }
}
