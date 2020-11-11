package co.edu.javeriana.tais2020.laurel.scoring.repositories;

import co.edu.javeriana.tais2020.laurel.scoring.entities.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoringRepository extends MongoRepository<Review, Long> {
}
