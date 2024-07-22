package com.example.Hotel.Reservation.data;

import com.example.Hotel.Reservation.model.Hotel;
import com.example.Hotel.Reservation.model.Quarto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelDataLoader {

    public static List<Hotel> getInitialHotels() {
        return List.of(
                new Hotel(null, "Hotel Lux", "São Paulo", 10, 20, 100.0, "Um hotel confortável e bem localizado.", LocalDate.parse("2024-07-15"), LocalDate.parse("2024-07-20"), "Wi-Fi, estacionamento, café da manhã", 4.5),
                new Hotel(null, "Hotel Premium", "São Paulo", 5, 10, 150.0, "Hotel de luxo com excelentes comodidades.", LocalDate.parse("2024-07-16"), LocalDate.parse("2024-07-21"), "Wi-Fi, piscina, spa", 4.8),
                new Hotel(null, "Hotel Econômico", "São Paulo", 8, 16, 200.0, "Uma opção econômica para viajantes.", LocalDate.parse("2024-08-01"), LocalDate.parse("2024-08-05"), "Wi-Fi, café da manhã", 3.8),
                new Hotel(null, "Hotel Familiar", "Rio de Janeiro", 12, 25, 90.0, "Ideal para famílias em férias.", LocalDate.parse("2024-08-10"), LocalDate.parse("2024-08-15"), "Wi-Fi, piscina, parque infantil", 4.2),
                new Hotel(null, "Hotel Executivo", "São Paulo", 15, 30, 200.0, "Luxo e conforto para viajantes de negócios.", LocalDate.parse("2024-08-20"), LocalDate.parse("2024-08-25"), "Wi-Fi, centro de conferências, restaurante", 4.7),
                new Hotel(null, "Hotel Marítimo", "Rio de Janeiro", 20, 40, 250.0, "Com vista para o mar e várias comodidades.", LocalDate.parse("2024-09-01"), LocalDate.parse("2024-09-10"), "Wi-Fi, piscina, spa, acesso à praia", 4.9),
                new Hotel(null, "Hotel Campestre", "Gramado", 6, 12, 80.0, "Experiência rústica e aconchegante.", LocalDate.parse("2024-09-15"), LocalDate.parse("2024-09-20"), "Wi-Fi, café da manhã, lareira", 4.4),
                new Hotel(null, "Hotel Urbano", "São Paulo", 20, 50, 120.0, "Localizado no centro da cidade.", LocalDate.parse("2024-10-01"), LocalDate.parse("2024-10-10"), "Wi-Fi, estacionamento, restaurante", 4.4),
                new Hotel(null, "Hotel Luxor", "Belo Horizonte", 10, 20, 110.0, "Hotel elegante e sofisticado.", LocalDate.parse("2024-10-05"), LocalDate.parse("2024-10-15"), "Wi-Fi, centro de fitness, spa", 4.6),
                new Hotel(null, "Hotel Desportivo", "Porto Alegre", 8, 16, 110.0, "Ideal para turistas e esportistas.", LocalDate.parse("2024-11-01"), LocalDate.parse("2024-11-10"), "Wi-Fi, estacionamento, restaurante", 4.1)
        );
    }

    public static List<Quarto> getInitialQuartos(List<Hotel> hotels) {
        List<Quarto> quartos = new ArrayList<>();

        // Gerar quartos para cada hotel com base no campo numQuartos
        for (Hotel hotel : hotels) {
            int numQuartos = hotel.getNumQuartos();
            for (int i = 1; i <= numQuartos; i++) {
                // Gerar o número do quarto como uma string formatada
                String numero = String.format("%03d", i);
                // Definir um tipo e valor de diária padrão
                String tipo = "Tipo " + (i % 3 + 1); // Alterna entre 3 tipos
                double valorDiaria = 100.0 + (i * 5); // Valor da diária ajustado

                // Adiciona um quarto para o hotel
                quartos.add(new Quarto(null, hotel, numero, tipo, valorDiaria));
            }
        }

        return quartos;
    }
}
