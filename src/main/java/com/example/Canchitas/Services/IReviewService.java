package com.example.Canchitas.Services;

import com.example.Canchitas.Entities.Reviews;

import java.util.List;

public interface IReviewService extends CrudService<Reviews> {
    List<Reviews> findBySportPlace_Id(Long sportPlace_id);
    List<Reviews> findReviewByPersonId(Long person_id);
}
