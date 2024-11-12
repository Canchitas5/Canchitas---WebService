package com.example.Canchitas.Services;

import com.example.Canchitas.Entities.Reservation;
import com.example.Canchitas.Entities.Reviews;

import java.util.List;

public interface IReservationService extends CrudService<Reservation> {
    List<Reservation> findBySportPlace_Id(Long sportPlace_id);
    List<Reservation> findReservationByPersonId(Long person_id);
}
