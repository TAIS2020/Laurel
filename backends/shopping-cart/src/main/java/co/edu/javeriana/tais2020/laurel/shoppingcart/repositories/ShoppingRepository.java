package co.edu.javeriana.tais2020.laurel.shoppingcart.repositories;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends MongoRepository<ShoppingCart, Long> {
}
