package com.example.Hotel.Reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoDTO {

    private Long reservaId;
    private String tipoNotificacao;
    private String mensagem;
}
