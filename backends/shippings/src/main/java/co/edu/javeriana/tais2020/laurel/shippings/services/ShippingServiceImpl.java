package co.edu.javeriana.tais2020.laurel.shippings.services;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;
import co.edu.javeriana.tais2020.laurel.shippings.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository repository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Shipping createShipping(Shipping shipping) {
        shipping.setId(sequenceGeneratorService.generateSequence(Shipping.SEQUENCE_NAME));
        return repository.save(shipping);
    }

    @Override
    public List<Shipping> getAllShipping() {
        List<Shipping> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Shipping getShipping(Long id) {
        return findShipping(id);
    }

    @Override
    public Shipping updateShipping(Shipping shippingConfirmation) {
        return repository.save(shippingConfirmation);
    }

//    @Override
//    public boolean deleteShipping(Long id) {
//        ShippingConfirmation shippingConfirmationFound = findShipping(id);
//        if (shippingConfirmationFound == null) return false;
//
//        repository.delete(shippingConfirmationFound);
//        return true;
//    }

    private Shipping findShipping(Long id) {
        Optional<Shipping> shippingOptional = repository.findById(id);
        if (shippingOptional.isEmpty()) return null;

        return shippingOptional.get();
    }
}
