package com.example.Hotel.Reservation.repository;

import com.example.Hotel.Reservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {


    @Query("SELECT h FROM Hotel h WHERE " +
            "(COALESCE(:destino, '') = '' OR h.localizacao LIKE %:destino%) AND " +
            "(COALESCE(:numQuartos, h.numQuartos) = h.numQuartos) AND " +
            "(COALESCE(:numHospedes, h.numHospedes) = h.numHospedes) AND " +
            "(COALESCE(:minAvaliacao, 0.0) <= h.avaliacao) AND " +
            "(COALESCE(:dataCheckIn, h.dataCheckIn) = h.dataCheckIn) AND " +
            "(COALESCE(:dataCheckOut, h.dataCheckOut) = h.dataCheckOut)")
    List<Hotel> findByCriteria(
            @Param("destino") String destino,
            @Param("numQuartos") Integer numQuartos,
            @Param("numHospedes") Integer numHospedes,
            @Param("minAvaliacao") Double minAvaliacao,
            @Param("dataCheckIn") LocalDate dataCheckIn,
            @Param("dataCheckOut") LocalDate dataCheckOut
    );


    @Query("SELECT h FROM Hotel h WHERE " +
            "(COALESCE(:minPreco, 0.0) <= h.precoDiaria) AND " +
            "(:maxPreco IS NULL OR h.precoDiaria <= :maxPreco) AND " +
            "(COALESCE(:localizacao, '') = '' OR h.localizacao LIKE %:localizacao%) AND " +
            "(COALESCE(:comodidades, '') = '' OR h.comodidades LIKE %:comodidades%) AND " +
            "(COALESCE(:minAvaliacao, 0.0) <= h.avaliacao)")
    List<Hotel> findByComparisonCriteria(
            @Param("minPreco") Double minPreco,
            @Param("maxPreco") Double maxPreco,
            @Param("localizacao") String localizacao,
            @Param("comodidades") String comodidades,
            @Param("minAvaliacao") Double minAvaliacao
    );


}
