package co.edu.javeriana.tais2020.laurel.payments.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BillingAdress")
public class BillingAddress {

	@Transient
	public static final String SEQUENCE_NAME = "bill_sequence";

	@Id
	private Long id;
	private Long zip;
	private String address_number;
	private String country_id;
	private Long city_id;

	public BillingAddress() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public String getAddress_number() {
		return address_number;
	}

	public void setAddress_number(String address_number) {
		this.address_number = address_number;
	}

	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public Long getCity_id() {
		return city_id;
	}

	public void setCity_id(Long city_id) {
		this.city_id = city_id;
	}

}
