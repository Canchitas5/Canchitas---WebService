package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.Reviews;
import com.example.Canchitas.Repositores.ReviewRepository;
import com.example.Canchitas.Services.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Reviews save(Reviews reviews) throws Exception {
        return reviewRepository.save(reviews);
    }

    @Override
    public void delete(Long id) throws Exception {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<Reviews> getAll() throws Exception {
        return  reviewRepository.findAll();
    }

    @Override
    public Optional<Reviews> getById(Long id) throws Exception {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Reviews> findBySportPlace_Id(Long sport_place_id) {
        return reviewRepository.findBySportPlace_Id(sport_place_id);
    }

    @Override
    public List<Reviews> findReviewByPersonId(Long person_id) {
        return reviewRepository.findReviewByPersonId(person_id);
    }
}
