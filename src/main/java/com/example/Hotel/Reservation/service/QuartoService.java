package com.example.Hotel.Reservation.service;

import com.example.Hotel.Reservation.model.Quarto;
import com.example.Hotel.Reservation.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository quartoRepository;

    public Quarto saveQuarto(Quarto quarto) {
        return quartoRepository.save(quarto);
    }

    public List<Quarto> getAllQuartos() {
        return quartoRepository.findAll();
    }

    public Quarto getQuartoById(Long id) {
        return quartoRepository.findById(id).orElse(null);
    }

    public void deleteQuarto(Long id) {
        quartoRepository.deleteById(id);
    }

    public List<Quarto> getQuartosByIds(List<Long> ids) {
        return quartoRepository.findByIdIn(ids);
    }
}
