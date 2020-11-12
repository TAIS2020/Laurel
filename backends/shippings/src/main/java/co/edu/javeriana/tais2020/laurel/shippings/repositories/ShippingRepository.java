package co.edu.javeriana.tais2020.laurel.shippings.repositories;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends MongoRepository<Shipping, Long> {
}
