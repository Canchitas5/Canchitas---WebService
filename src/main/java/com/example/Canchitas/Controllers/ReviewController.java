package com.example.Canchitas.Controllers;


import com.example.Canchitas.Entities.Reviews;
import com.example.Canchitas.Services.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reviews>> getAll() {
        try {
            List<Reviews> reviews = reviewService.getAll();
            if (reviews.size() > 0)
                return new ResponseEntity<>(reviews, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/sportPlace/{sportPlace_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reviews>> findByProduct_Id(@PathVariable("sportPlace_id") Long sportPlace_id) {
        try {
            List<Reviews> reviews = reviewService.findBySportPlace_Id(sportPlace_id);
            if (reviews.size() > 0)
                return new ResponseEntity<>(reviews, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/person/{person_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Reviews>> findReviewByUserId(@PathVariable("person_id") Long person_id) {
        try {
            List<Reviews> reviews = reviewService.findReviewByPersonId(person_id);
            if (reviews.size() > 0)
                return new ResponseEntity<>(reviews, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reviews> getById(@PathVariable("id") Long id) {
        try {
            Optional<Reviews> review = reviewService.getById(id);
            if (!review.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reviews> newReview(@RequestBody Reviews review) {
        try {
            Reviews newReview = reviewService.save(review);
            if (newReview != null)
                return new ResponseEntity<>(newReview, HttpStatus.CREATED);
            else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reviews> updateReview(@PathVariable("id") Long id, @RequestBody Reviews review) {
        try {
            if (id.equals(review.getId())) {
                Reviews reviewUpdate = reviewService.save(review);
                return new ResponseEntity<>(reviewUpdate, HttpStatus.OK);
            } else
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("id") Long id) {
        try {
            reviewService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
