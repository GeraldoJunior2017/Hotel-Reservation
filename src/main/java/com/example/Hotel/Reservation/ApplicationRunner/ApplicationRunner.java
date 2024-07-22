package com.example.Hotel.Reservation.ApplicationRunner;

import com.example.Hotel.Reservation.data.HotelDataLoader;
import com.example.Hotel.Reservation.model.Hotel;
import com.example.Hotel.Reservation.model.Quarto;
import com.example.Hotel.Reservation.repository.HotelRepository;
import com.example.Hotel.Reservation.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApplicationRunner {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            if (hotelRepository.count() == 0) {
                // Carregar dados iniciais de hotéis
                List<Hotel> hotels = HotelDataLoader.getInitialHotels();
                hotelRepository.saveAll(hotels);

                // Obter os hotéis do repositório para criar quartos associados
                List<Hotel> loadedHotels = hotelRepository.findAll();
                List<Quarto> quartos = HotelDataLoader.getInitialQuartos(loadedHotels);
                quartoRepository.saveAll(quartos);

                System.out.println("Dados iniciais inseridos.");
            }
        };
    }
}
