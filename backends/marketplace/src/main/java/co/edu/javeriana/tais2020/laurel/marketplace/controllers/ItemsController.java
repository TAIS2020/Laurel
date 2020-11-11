package co.edu.javeriana.tais2020.laurel.marketplace.controllers;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import co.edu.javeriana.tais2020.laurel.marketplace.entities.Items;
import co.edu.javeriana.tais2020.laurel.marketplace.exception.ResourceNotFoundException;
import co.edu.javeriana.tais2020.laurel.marketplace.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/items")
@Validated
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public ResponseEntity<Items> getItems(@RequestParam String q) {
        Items items = new Items();
        items.setItems(itemsService.getItems(q));
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) throws ResourceNotFoundException {
        Item item = itemsService.getItem(id);
        if (Objects.isNull(item)) throw new ResourceNotFoundException("Item not found for id: " + id);

        return ResponseEntity.ok(item);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        return ResponseEntity.ok(itemsService.createItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody Item item) throws ResourceNotFoundException {
        item.setId(id);
        Item updated = itemsService.updateItem(item);
        if (Objects.isNull(updated)) throw new ResourceNotFoundException("User not found for id: " + id);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) throws ResourceNotFoundException  {
        if (itemsService.deleteItem(id)) return ResponseEntity.accepted().build();

        throw new ResourceNotFoundException("User not found for id: " + id);
    }

}
