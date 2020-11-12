package co.edu.javeriana.tais2020.laurel.shippings.entities;

public class Price {
    private Long price;

    public Price(Long shippingPrice) {
        price = shippingPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
