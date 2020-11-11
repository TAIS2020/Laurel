package co.edu.javeriana.tais2020.laurel.shoppingcart.controllers;

import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCart;
import co.edu.javeriana.tais2020.laurel.shoppingcart.entities.ShoppingCarts;
import co.edu.javeriana.tais2020.laurel.shoppingcart.services.ShoppingService;
import co.edu.javeriana.tais2020.laurel.shoppingcart.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping
    public ResponseEntity<ShoppingCarts> getShoppingCarts() {
        ShoppingCarts shoppingCarts = new ShoppingCarts();
        shoppingCarts.setShoppingCarts(shoppingService.getAllShoppingCarts());
        return ResponseEntity.ok(shoppingCarts);
    }

    @PutMapping("/{user_id}/cart")
    public ResponseEntity<ShoppingCart> addItemCart(@PathVariable Long user_id, @Valid @RequestBody ShoppingCart shoppingCart) throws ResourceNotFoundException {

        shoppingCart.setUserId(user_id);
        ShoppingCart updated = shoppingService.addItemCart(shoppingCart);
        if (Objects.isNull(updated)) throw new ResourceNotFoundException("Shopping cart not found for user id: " + user_id);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{user_id}/cart/item/{item_id}")
    public ResponseEntity deleteItemCart(@PathVariable Long user_id, @PathVariable Long item_id) throws ResourceNotFoundException  {
        if (shoppingService.deleteShoppingCart(user_id,item_id)) return ResponseEntity.accepted().build();

        throw new ResourceNotFoundException("Shopping cart not found for user id: " + user_id + " and item id: " + item_id);
    }

    @GetMapping("/users/{user_id}/cart")
    public ResponseEntity getItemCart(@PathVariable Long user_id) throws ResourceNotFoundException  {
        List<ShoppingCart> shoppingCart = shoppingService.getShoppingCarts(user_id);
        if (shoppingCart.isEmpty()) throw new ResourceNotFoundException("Shopping cart not found for user id: " + user_id);

        return ResponseEntity.ok(shoppingCart);
    }
}
