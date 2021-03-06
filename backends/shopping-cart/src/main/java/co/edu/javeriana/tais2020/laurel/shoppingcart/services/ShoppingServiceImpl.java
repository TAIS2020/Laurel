package co.edu.javeriana.tais2020.laurel.shoppingcart.services;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;
import co.edu.javeriana.tais2020.laurel.shoppingcart.repositories.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingServiceImpl implements ShoppingService{

    @Autowired
    private ShoppingRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ShoppingCart addItemCart(ShoppingCart shoppingCart){

        ShoppingCart shoppingFound = findShoppingCart(shoppingCart.getId());
        if (shoppingFound == null) {
            //Create
            shoppingCart.setId(sequenceGeneratorService.generateSequence(shoppingCart.SEQUENCE_NAME));
            return repository.save(shoppingCart);
        }

        //Update
        shoppingFound.setId(shoppingCart.getId());
        shoppingFound.setUserId(shoppingCart.getUserId());
        shoppingFound.setItemId(shoppingCart.getItemId());
        shoppingFound.setQuantity(shoppingCart.getQuantity());

        return repository.save(shoppingFound);
    }

    private ShoppingCart findShoppingCart(Long id) {
        if(id == null) return null;

        Optional<ShoppingCart> shoppingCartOptional = repository.findById(id);
        if (shoppingCartOptional.isEmpty()) return null;

        return shoppingCartOptional.get();
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        List<ShoppingCart> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<ShoppingCart> getShoppingCarts(Long user_id) {
        return repository.findByUserId(user_id);
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public boolean deleteShoppingCart(Long userId, Long itemId) {
        return (repository.deleteByUserIdAndItemId(userId,itemId) > 0);
    }

}
