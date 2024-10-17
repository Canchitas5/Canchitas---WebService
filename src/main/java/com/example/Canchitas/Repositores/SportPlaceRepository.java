package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.SportPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportPlaceRepository extends JpaRepository<SportPlace,Long> {
    List<SportPlace> findByLocation(String location) throws Exception;
    List<SportPlace> findByCompany_Id(Long Id) throws Exception;
}
