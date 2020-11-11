package co.edu.javeriana.tais2020.laurel.marketplace.repositories;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketplaceRepository extends MongoRepository<Item, Long> {

    List<Item> findByNameLikeIgnoreCase(String name);
}
