package co.edu.javeriana.tais2020.laurel.shippings.controllers;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;
import co.edu.javeriana.tais2020.laurel.shippings.entities.Shippings;
import co.edu.javeriana.tais2020.laurel.shippings.entities.Price;
import co.edu.javeriana.tais2020.laurel.shippings.exception.ResourceNotFoundException;
import co.edu.javeriana.tais2020.laurel.shippings.services.ShippingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.Objects;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingsController {

    @Autowired
    private ShippingsService shippingsService;

    @GetMapping
    public ResponseEntity<Shippings> getShippings() {
        Shippings shippings = new Shippings();
        shippings.setShippings(shippingsService.getAllShippings());
        return ResponseEntity.ok(shippings);
    }

    @GetMapping("price?from_lat={from_lat}&from_long={from_long}&to_lat={to_lat}&to_long={to_long}")
    public ResponseEntity<Price> getAddressPrice(@PathVariable Long from_lat,
                                             @PathVariable Long from_long,
                                             @PathVariable Long to_lat,
                                             @PathVariable Long to_long) throws ResourceNotFoundException {

        return ResponseEntity.ok(new Price(Long.valueOf(6L)));
    }

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        return ResponseEntity.ok(shippingsService.createShipping(shipping));
    }

    @PutMapping("{id}/confirm")
    public ResponseEntity<Shipping> shippingConfirmation(@PathVariable Long id, @Valid @RequestBody Shipping shipping) throws ResourceNotFoundException {

        Shipping tempShipping = shippingsService.getShipping(id);
        tempShipping.setCarrier(shipping.getCarrier());
        tempShipping.setSending_timestamp(shipping.getSending_timestamp());
        tempShipping.setTracking_code(shipping.getTracking_code());
        tempShipping.setExpected_delivery_date(shipping.getExpected_delivery_date());

        Shipping updated = shippingsService.updateShipping(tempShipping);
        if (Objects.isNull(updated)) throw new ResourceNotFoundException("Shipping not found for id: " + id);

        return ResponseEntity.ok(updated);
    }


}
