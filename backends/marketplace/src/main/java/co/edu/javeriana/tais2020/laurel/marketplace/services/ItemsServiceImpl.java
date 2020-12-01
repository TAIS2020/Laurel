package co.edu.javeriana.tais2020.laurel.marketplace.services;

import co.edu.javeriana.tais2020.laurel.marketplace.entities.Item;
import co.edu.javeriana.tais2020.laurel.marketplace.repositories.MarketplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private MarketplaceRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Item getItem(Long id) {
        return findItem(id);
    }

    @Override
    public List<Item> getItems(String searchTerms) {
        return repository.findByNameLikeIgnoreCase(searchTerms);
    }

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item updateItem(Item item) {
        Item itemFound = findItem(item.getId());
        if (itemFound == null) return null;

        itemFound.setDescription(item.getDescription());
        itemFound.setInStock(item.getInStock());
        itemFound.setName(item.getName());
        itemFound.setPhotos(item.getPhotos());
        itemFound.setPrice(item.getPrice());

        return repository.save(itemFound);
    }

    @Override
    public Item createItem(Item item) {
        item.setId(sequenceGeneratorService.generateSequence(Item.SEQUENCE_NAME));
        return repository.save(item);
    }

    @Override
    public boolean deleteItem(Long id) {
        Item itemFound = findItem(id);
        if (itemFound == null) return false;

        repository.delete(itemFound);
        return true;
    }

    private Item findItem(Long id) {
        Optional<Item> itemOptional = repository.findById(id);
        if (itemOptional.isEmpty()) return null;

        return itemOptional.get();
    }
}
