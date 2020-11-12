package co.edu.javeriana.tais2020.laurel.shippings.services;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;

import java.util.List;

public interface ShippingsService {
    List<Shipping> getAllShippings();
    Shipping getShipping(Long id);
    Shipping createShipping(Shipping user);
    Shipping updateShipping(Shipping user);
    boolean deleteShipping(Long id);
}

