package co.edu.javeriana.tais2020.laurel.payments.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Payment")
public class Payment {

	@Transient
	public static final String SEQUENCE_NAME = "pay_sequence";

	@Id
	private Long id;
	private Long user_id;
	private String payment_method;
	private Long quotas;
	private String address_number;
	//private BillingAddress billing_address;

	public Payment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public Long getQuotas() {
		return quotas;
	}

	public void setQuotas(Long quotas) {
		this.quotas = quotas;
	}

	public String getAddress_number() {
		return address_number;
	}

	public void setAddress_number(String address_number) {
		this.address_number = address_number;
	}


}
