package com.example.Hotel.Reservation.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String localizacao;
    private int numQuartos;
    private int numHospedes;
    private double precoDiaria;
    private String descricao;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private String comodidades;
    private double avaliacao ;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Quarto> quartos;

    @OneToMany(mappedBy = "hotel")
    @JsonManagedReference
    private List<Reserva> reservas;

    // Construtor com todos os parâmetros
    public Hotel(Long id, String nome, String localizacao, int numQuartos, int numHospedes, double precoDiaria, String descricao, LocalDate dataCheckIn, LocalDate dataCheckOut, String comodidades, double avaliacao ) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.numQuartos = numQuartos;
        this.numHospedes = numHospedes;
        this.precoDiaria = precoDiaria;
        this.descricao = descricao;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.comodidades = comodidades;
        this.avaliacao  = avaliacao ;
    }
}



