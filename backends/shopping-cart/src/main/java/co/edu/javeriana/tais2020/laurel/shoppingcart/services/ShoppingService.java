package co.edu.javeriana.tais2020.laurel.shoppingcart.services;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;

import java.util.List;

public interface ShoppingService {
        List<ShoppingCart> getAllShoppingCarts();
        List<ShoppingCart> getShoppingCarts(Long user_id);
        ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
        boolean deleteShoppingCart(Long userId, Long itemId);
        ShoppingCart addItemCart(ShoppingCart shoppingCart);
}
