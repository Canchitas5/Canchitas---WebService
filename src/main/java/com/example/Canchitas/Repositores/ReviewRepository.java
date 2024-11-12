package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Long> {

    List<Reviews> findBySportPlace_Id(Long sportPlace_id);
    List<Reviews> findReviewByPersonId(Long person_id);

}
