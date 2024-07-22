package com.example.Hotel.Reservation.service;

import com.example.Hotel.Reservation.model.Hotel;
import com.example.Hotel.Reservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> pesquisarHoteis(
            String destino,
            Integer numQuartos,
            Integer numHospedes,
            Double minAvaliacao,
            LocalDate dataCheckIn,
            LocalDate dataCheckOut
    ) {
        // Chamando o repositório para buscar os hotéis
        List<Hotel> hoteis = hotelRepository.findByCriteria(
                destino,
                numQuartos,
                numHospedes,
                minAvaliacao,
                dataCheckIn,
                dataCheckOut
        );


        return hoteis;
    }

    public List<Hotel> compararHoteis(
            Double minPreco,
            Double maxPreco,
            String localizacao,
            String comodidades,
            Double minAvaliacao) {
        return hotelRepository.findByComparisonCriteria(
                minPreco,
                maxPreco,
                localizacao,
                comodidades,
                minAvaliacao
        );
    }


    public Hotel adicionarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
