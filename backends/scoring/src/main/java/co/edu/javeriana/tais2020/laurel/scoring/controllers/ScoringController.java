package co.edu.javeriana.tais2020.laurel.scoring.controllers;

import co.edu.javeriana.tais2020.laurel.scoring.entities.Review;
import co.edu.javeriana.tais2020.laurel.scoring.services.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/scoring")
public class ScoringController {

    @Autowired
    private ScoringService scoringService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok(scoringService.createReview(review));
    }
}
