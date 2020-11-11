package co.edu.javeriana.tais2020.laurel.shoppingcart.repositories;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingRepository extends MongoRepository<ShoppingCart, Long> {

    Long deleteByUserIdAndItemId(Long userId, Long itemId);
    ShoppingCart findByUserIdAndItemId(Long userId, Long itemId);
    List<ShoppingCart> findByUserId(Long userId);
}
