package co.edu.javeriana.tais2020.laurel.shippings.dto;

import co.edu.javeriana.tais2020.laurel.shippings.entities.Shipping;

import java.util.List;

public class ShippingList {
    private List<Shipping> shippingList;

    public ShippingList() {
    }

    public List<Shipping> getShippingList() {
        return shippingList;
    }

    public void setShippingList(List<Shipping> shippingList) {
        this.shippingList = shippingList;
    }
}
