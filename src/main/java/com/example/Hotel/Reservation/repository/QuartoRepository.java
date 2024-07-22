package com.example.Hotel.Reservation.repository;

import com.example.Hotel.Reservation.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    List<Quarto> findByIdIn(List<Long> ids);
}
