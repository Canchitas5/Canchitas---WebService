package com.example.Canchitas.Services;

import com.example.Canchitas.Entities.SportPlace;

import java.util.List;

public interface SportPlaceService extends CrudService<SportPlace> {
    List<SportPlace> findByLocation(String location) throws Exception;
    List<SportPlace> findByCompany_Id(Long Id) throws Exception;
}
