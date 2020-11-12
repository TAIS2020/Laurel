package co.edu.javeriana.tais2020.laurel.shippings.services;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;
import co.edu.javeriana.tais2020.laurel.shippings.repositories.ShippingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShippingsServiceImpl implements ShippingsService {

    @Autowired
    private ShippingsRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Shipping> getAllShippings() {
        List<Shipping> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Shipping getShipping(Long id) {
        return findShipping(id);
    }

    @Override
    public Shipping createShipping(Shipping shipping) {
        shipping.setId(sequenceGeneratorService.generateSequence(Shipping.SEQUENCE_NAME));
        return repository.save(shipping);
    }

    @Override
    public Shipping updateShipping(Shipping shipping) {
        return repository.save(shipping);
    }

    @Override
    public boolean deleteShipping(Long id) {
        Shipping shippingFound = findShipping(id);
        if (shippingFound == null) return false;

        repository.delete(shippingFound);
        return true;
    }

    private Shipping findShipping(Long id) {
        Optional<Shipping> shippingOptional = repository.findById(id);
        if (shippingOptional.isEmpty()) return null;

        return shippingOptional.get();
    }
}
