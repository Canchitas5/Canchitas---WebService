package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.Reservation;
import com.example.Canchitas.Repositores.ReservationRepository;
import com.example.Canchitas.Services.IReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation save(Reservation entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findBySportPlace_Id(Long sportPlace_id) {
        return reservationRepository.findBySportPlace_Id(sportPlace_id);
    }

    @Override
    public List<Reservation> findReservationByPersonId(Long person_id) {
        return reservationRepository.findReservationByPersonId(person_id);
    }
}
