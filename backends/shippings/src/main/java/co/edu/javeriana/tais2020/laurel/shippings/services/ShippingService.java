package co.edu.javeriana.tais2020.laurel.shippings.services;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;

import java.util.List;

public interface ShippingService {
    Shipping createShipping(Shipping shipping);
    List<Shipping> getAllShipping();
    Shipping getShipping(Long id);
    Shipping updateShipping(Shipping shipping);
//    boolean deleteShipping(Long id);
}

