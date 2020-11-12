package co.edu.javeriana.tais2020.laurel.shippings.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ShippingConfirmationRequest {
    private String carrier;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sendingTimestamp;
    private String trackingCode;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate expectedDeliveryDate;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public LocalDateTime getSendingTimestamp() {
        return sendingTimestamp;
    }

    public void setSendingTimestamp(LocalDateTime sendingTimestamp) {
        this.sendingTimestamp = sendingTimestamp;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public LocalDate getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}
