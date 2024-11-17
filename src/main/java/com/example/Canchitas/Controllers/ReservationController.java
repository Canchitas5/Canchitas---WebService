package com.example.Canchitas.Controllers;

import com.example.Canchitas.Entities.Reservation;
import com.example.Canchitas.Services.Impl.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/reservation")
public class ReservationController {


    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Implement GetAll

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Reservation>> getAll(){
        try {
            List<Reservation> reservations = reservationService.getAll();
            if (reservations.size() > 0)
                return new ResponseEntity<>(reservations, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //GetById

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getById(@PathVariable("id") Long id){
        try {
            Optional<Reservation> reservation = reservationService.getById(id);
            if(reservation.isPresent())
                return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Create

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> create(@RequestBody Reservation reservation){
        try {
            Reservation reservationCreate = reservationService.save(reservation);
            if (reservationCreate != null)
                return new ResponseEntity<>(reservationCreate, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Update
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Reservation> update(@PathVariable("id") Long id, @RequestBody Reservation reservation){
        try {
            if (id.equals(reservation.getId())) {
                Reservation reservationUpdate = reservationService.save(reservation);
                return new ResponseEntity<>(reservationUpdate, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Delete

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Reservation> delete(@PathVariable("id") Long id){
        try {
            Optional<Reservation> reservation = reservationService.getById(id);
            if (reservation.isPresent()) {
                reservationService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //FindBySportPlaceId

    @GetMapping(value = "/sportPlace/{sportPlace_id}", produces = "application/json")
    public ResponseEntity<List<Reservation>> findBySportPlaceId(@PathVariable("sportPlace_id") Long sportPlace_id){
        try {
            List<Reservation> reservations = reservationService.findBySportPlace_Id(sportPlace_id);
            if (reservations.size() > 0)
                return new ResponseEntity<>(reservations, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //FindReservationByUserId
    @GetMapping(value = "/person/{person_id}", produces = "application/json")
    public ResponseEntity<List<Reservation>> findReservationByUserId(@PathVariable("person_id") Long person_id){
        try {
            List<Reservation> reservations = reservationService.findReservationByPersonId(person_id);
            if (reservations.size() > 0)
                return new ResponseEntity<>(reservations, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
