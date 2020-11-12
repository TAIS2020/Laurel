package co.edu.javeriana.tais2020.laurel.shippings.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Shipping")
public class Shipping {
    @Transient
    public static final String SEQUENCE_NAME = "shipping_sequence";

    @Id
    private Long id;
    private Long paymentId;
    private String address;
    private String carrier;
    private String trackingCode;
    private LocalDateTime sendingTimestamp;
    private LocalDate expectedDeliveryDate;
    private List<Item> items;

    public Shipping() {
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public LocalDateTime getSendingTimestamp() {
        return sendingTimestamp;
    }

    public void setSendingTimestamp(LocalDateTime sendingTimestamp) {
        this.sendingTimestamp = sendingTimestamp;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
