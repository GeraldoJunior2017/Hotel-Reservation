package com.example.Hotel.Reservation.service;


import com.example.Hotel.Reservation.dto.NotificacaoDTO;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {


    public void registrarNotificacao(NotificacaoDTO notificacaoDTO) {
        // Exemplo de log para depuração
        System.out.println("Notificação recebida: ");
        System.out.println("Reserva ID: " + notificacaoDTO.getReservaId());
        System.out.println("Tipo: " + notificacaoDTO.getTipoNotificacao());
        System.out.println("Mensagem: " + notificacaoDTO.getMensagem());

    }
}
