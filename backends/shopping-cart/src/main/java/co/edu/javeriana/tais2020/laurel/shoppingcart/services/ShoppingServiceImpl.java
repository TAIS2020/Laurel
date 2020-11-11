package co.edu.javeriana.tais2020.laurel.shoppingcart.services;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;
import co.edu.javeriana.tais2020.laurel.shoppingcart.repositories.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingServiceImpl implements ShoppingService{

    @Autowired
    private ShoppingRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ShoppingCart addItemCart(ShoppingCart shoppingCart){
        return null;
    }

    @Override
    public boolean deleteItemCart(Long user_id, Long item_id) {
        ShoppingCart shippingFound = findShoppingCart(user_id,item_id);
        if (shippingFound == null) return false;

        repository.delete(shippingFound);
        return true;
    }

    private ShoppingCart findShoppingCart(Long user_id, Long item_id) {
        //Optional<ShoppingCart> shoppingOptional = repository.findAll();
        if (shoppingOptional.isEmpty()) return null;

        return shoppingOptional.get();
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return null;
    }

}
