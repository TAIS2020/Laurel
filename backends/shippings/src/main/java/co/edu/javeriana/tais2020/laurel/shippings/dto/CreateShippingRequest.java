package co.edu.javeriana.tais2020.laurel.shippings.dto;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CreateShippingRequest {
    @NotNull(message = "Payment id is required")
    private Long paymentId;
    @NotBlank(message = "Address cannot be blank")
    @NotNull(message = "Address cannot be null")
    private String address;
    @NotEmpty(message = "Item list cannot be empty")
    private List<Item> items;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
