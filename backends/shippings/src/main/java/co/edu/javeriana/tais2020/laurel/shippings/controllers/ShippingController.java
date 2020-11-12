package co.edu.javeriana.tais2020.laurel.shippings.controllers;

import co.edu.javeriana.tais2020.laurel.shippings.dto.CreateShippingRequest;
import co.edu.javeriana.tais2020.laurel.shippings.dto.ShippingConfirmationRequest;
import co.edu.javeriana.tais2020.laurel.shippings.dto.ShippingList;
import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;
import co.edu.javeriana.tais2020.laurel.shippings.exception.ResourceNotFoundException;
import co.edu.javeriana.tais2020.laurel.shippings.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping
    public ResponseEntity<ShippingList> getAllShipping() {
        ShippingList shippingList = new ShippingList();
        shippingList.setShippingList(shippingService.getAllShipping());
        return ResponseEntity.ok(shippingList);
    }

    @GetMapping("price")
    public ResponseEntity<Long> getAddressPrice(
            @RequestParam Long from_lat,
            @RequestParam Long from_long,
            @RequestParam Long to_lat,
            @RequestParam Long to_long) {

        return ResponseEntity.ok(Long.valueOf(60L));
    }

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@Valid @RequestBody CreateShippingRequest shippingRequest) {
        Shipping shipping = new Shipping();

        shipping.setAddress(shippingRequest.getAddress());
        shipping.setPaymentId(shippingRequest.getPaymentId());
        shipping.setItems(shippingRequest.getItems());

        return ResponseEntity.ok(shippingService.createShipping(shipping));
    }

    @PutMapping("{id}/confirm")
    public ResponseEntity<Shipping> shippingConfirmation(@PathVariable Long id, @Valid @RequestBody ShippingConfirmationRequest shippingConfirmation) throws ResourceNotFoundException {

        Shipping shipping = shippingService.getShipping(id);

        if (shipping == null) throw new ResourceNotFoundException("Shipping not found for id: " + id);

        shipping.setCarrier(shippingConfirmation.getCarrier());
        shipping.setExpectedDeliveryDate(shippingConfirmation.getExpectedDeliveryDate());
        shipping.setSendingTimestamp(shippingConfirmation.getSendingTimestamp());
        shipping.setTrackingCode(shippingConfirmation.getTrackingCode());

        Shipping updated = shippingService.updateShipping(shipping);
        return ResponseEntity.ok(updated);
    }

}
