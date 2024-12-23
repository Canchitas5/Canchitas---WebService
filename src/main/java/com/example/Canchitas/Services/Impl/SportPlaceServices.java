package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.SportPlace;
import com.example.Canchitas.Repositores.SportPlaceRepository;
import com.example.Canchitas.Services.SportPlaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportPlaceServices implements SportPlaceService {
    private final SportPlaceRepository sportPlaceRepository;

    public SportPlaceServices(SportPlaceRepository sportPlaceRepository) {
        this.sportPlaceRepository = sportPlaceRepository;
    }

    @Override
    public SportPlace save(SportPlace sportPlace) throws Exception {
        return sportPlaceRepository.save(sportPlace);
    }

    @Override
    public void delete(Long id) throws Exception {
        sportPlaceRepository.deleteById(id);
    }

    @Override
    public List<SportPlace> getAll() throws Exception {
        return sportPlaceRepository.findAll();
    }

    @Override
    public Optional<SportPlace> getById(Long id) throws Exception {
        return sportPlaceRepository.findById(id);
    }

    @Override
    public List<SportPlace> findByCoordinates(String coordinates) throws Exception {
        return sportPlaceRepository.findByCoordinates(coordinates);
    }

    @Override
    public List<SportPlace> findByCompany_Id(Long Id) throws Exception {
        return sportPlaceRepository.findByCompany_Id(Id);
    }
}
