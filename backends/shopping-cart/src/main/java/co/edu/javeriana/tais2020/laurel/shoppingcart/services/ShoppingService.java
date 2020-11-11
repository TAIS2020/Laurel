package co.edu.javeriana.tais2020.laurel.shoppingcart.services;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;

import java.util.List;

public interface ShoppingService {
        ShoppingCart addItemCart(ShoppingCart shoppingCart);
        boolean deleteItemCart(Long user_id, Long item_id);
        List<ShoppingCart> getAllShoppingCarts();
}
