package co.edu.javeriana.tais2020.laurel.marketplace.services;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;

import java.util.List;

public interface ItemsService {

    Item getItem(Long id);
    List<Item> getItems(String searchTerms);
    Item updateItem(Item item);
    Item createItem(Item item);
    boolean deleteItem(Long id);

}
