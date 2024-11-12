package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBySportPlace_Id(Long sportPlace_id);
    List<Reservation> findReservationByPersonId(Long user_id);
}
