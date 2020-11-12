package co.edu.javeriana.tais2020.laurel.shippings.entities;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "Shipping")
public class Shipping {
    @Transient
    public static final String SEQUENCE_NAME = "shippings_sequence";

    @Id
    private Long id;
    private Long paymentId;
    private String carrier;
    private String sending_timestamp;
    private String tracking_code;
    private String expected_delivery_date;


    public Shipping() {
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

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getSending_timestamp() {
        return sending_timestamp;
    }

    public void setSending_timestamp(String sending_timestamp) {
        this.sending_timestamp = sending_timestamp;
    }

    public String getTracking_code() {
        return tracking_code;
    }

    public void setTracking_code(String tracking_code) {
        this.tracking_code = tracking_code;
    }

    public String getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(String expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }
}
