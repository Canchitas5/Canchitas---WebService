package com.example.Canchitas.Controllers;


import com.example.Canchitas.Entities.Company;
import com.example.Canchitas.Entities.SportPlace;
import com.example.Canchitas.Services.Impl.CompanyService;
import com.example.Canchitas.Services.Impl.SportPlaceServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("api/v1/sportPlaces")
@RestController
public class SportPlaces {

    private final SportPlaceServices sportPlacesService;
    private final CompanyService companyServices;
    public SportPlaces(SportPlaceServices sportPlacesService, CompanyService companyServices) {
        this.sportPlacesService = sportPlacesService;
        this.companyServices = companyServices;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SportPlace>> findAllplaces(){
        try {
            List<SportPlace> places = sportPlacesService.getAll();
            if(places.size()>0)
                return new ResponseEntity<>(places, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportPlace> findById (@PathVariable("id") Long id){
        try {
            Optional<SportPlace> places = sportPlacesService.getById(id);
            if(places == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(places.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportPlace> createplaces(@RequestBody SportPlace places){
        try {
            SportPlace placesCreate = sportPlacesService.save(places);
            return new ResponseEntity<>(placesCreate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportPlace> updateplaces(@PathVariable("id") Long id, @RequestBody SportPlace places){
        try {
            Optional<SportPlace> placesFound = sportPlacesService.getById(id);
            if(!placesFound.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                places.setId(id);
                sportPlacesService.save(places);
                return new ResponseEntity<>(places, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SportPlace> deleteplaces(@PathVariable("id") Long id){
        try {
            Optional<SportPlace> placesFound = sportPlacesService.getById(id);
            if(!placesFound.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                sportPlacesService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/company/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SportPlace>> findByCompany_Id (@PathVariable("id") Long id){
        try {
            Optional<Company> places =companyServices.getById(id);

            if(!places.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else{
                List<SportPlace> place = sportPlacesService.findByCompany_Id(id);
                return new ResponseEntity<>(place, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Find By location
    @GetMapping(value = "/coordinates/{coordinates}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SportPlace>> findByCoordinates (@PathVariable("coordinates") String coordinates){
        try {
            List<SportPlace> places =sportPlacesService.findByCoordinates(coordinates);
            if(places.size()>0){
                return new ResponseEntity<>(places, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
