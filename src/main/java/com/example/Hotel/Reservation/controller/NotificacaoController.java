package com.example.Hotel.Reservation.controller;

import com.example.Hotel.Reservation.dto.NotificacaoDTO;
import com.example.Hotel.Reservation.service.NotificacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    public NotificacaoController(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @PostMapping("/notificacoes")
    public ResponseEntity<String> receberNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        System.out.println("Notificação recebida: " + notificacaoDTO);

        return ResponseEntity.ok("Notificação registrada com sucesso!");
    }

    @PostMapping
    public ResponseEntity<String> enviarNotificacao(@RequestBody NotificacaoDTO notificacaoDTO) {
        try {
            notificacaoService.registrarNotificacao(notificacaoDTO);
            return ResponseEntity.ok("Notificação registrada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao registrar notificação.");
        }
    }
}
