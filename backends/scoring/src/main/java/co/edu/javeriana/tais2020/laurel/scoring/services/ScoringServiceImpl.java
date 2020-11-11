package co.edu.javeriana.tais2020.laurel.scoring.services;

import co.edu.javeriana.tais2020.laurel.scoring.entities.Review;
import co.edu.javeriana.tais2020.laurel.scoring.repositories.ScoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoringServiceImpl implements ScoringService {

    @Autowired
    private ScoringRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Review createReview(Review review) {
        review.setId(sequenceGeneratorService.generateSequence(Review.SEQUENCE_NAME));
        return repository.save(review);
    }
}
