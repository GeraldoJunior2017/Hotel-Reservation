package com.example.Hotel.Reservation.service;

import com.example.Hotel.Reservation.dto.NotificacaoDTO;
import com.example.Hotel.Reservation.dto.ReservaDTO;
import com.example.Hotel.Reservation.model.Hotel;
import com.example.Hotel.Reservation.model.Quarto;
import com.example.Hotel.Reservation.model.Reserva;
import com.example.Hotel.Reservation.repository.HotelRepository;
import com.example.Hotel.Reservation.repository.QuartoRepository;
import com.example.Hotel.Reservation.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private QuartoRepository quartoRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public Reserva criarReserva(ReservaDTO reservaDTO) {
        // Busca o hotel pelo ID
        Hotel hotel = hotelRepository.findById(reservaDTO.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel não encontrado"));

        // Busca o quarto pelo ID
        Quarto quarto = quartoRepository.findById(reservaDTO.getQuartoId())
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));

        // Cria uma nova reserva
        Reserva reserva = new Reserva();
        reserva.setNome(reservaDTO.getNome());
        reserva.setContato(reservaDTO.getContato());
        reserva.setDataCheckIn(reservaDTO.getDataCheckIn());
        reserva.setDataCheckOut(reservaDTO.getDataCheckOut());
        reserva.setHotel(hotel);
        reserva.setQuarto(quarto);
        reserva.setDetalhesPagamento(reservaDTO.getDetalhesPagamento());
        reserva.setStatus("Reserva criada"); // Definindo status inicial

        // Atualiza o quarto para refletir a nova reserva
        quarto.setReserva(reserva);
        quartoRepository.save(quarto); // Salva a atualização do quarto

        // Salva a nova reserva
        return reservaRepository.save(reserva);
    }
    @Transactional
    public Reserva checkIn(Long reservaId) {
        // Buscar reserva pelo ID
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        // Atualizar o status da reserva para check-in
        reserva.setStatus("Check-in realizado");
        reservaRepository.save(reserva);

        // Notificar sobre o check-in
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO();
        notificacaoDTO.setReservaId(reservaId);
        notificacaoDTO.setTipoNotificacao("Check-in Confirmado");
        notificacaoDTO.setMensagem("Check-in realizado com sucesso para a reserva " + reservaId);

        restTemplate.postForObject("http://localhost:8080/notificacoes", notificacaoDTO, String.class);

        return reserva;
    }

    @Transactional
    public Reserva checkOut(Long reservaId) {
        // Buscar reserva pelo ID
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));

        // Atualizar o status da reserva para check-out
        reserva.setStatus("Check-out realizado");
        reservaRepository.save(reserva);

        // Notificar sobre o check-out
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO();
        notificacaoDTO.setReservaId(reservaId);
        notificacaoDTO.setTipoNotificacao("Check-out Confirmado");
        notificacaoDTO.setMensagem("Check-out realizado com sucesso para a reserva " + reservaId);

        restTemplate.postForObject("http://localhost:8080/notificacoes", notificacaoDTO, String.class);

        return reserva;
    }

}

