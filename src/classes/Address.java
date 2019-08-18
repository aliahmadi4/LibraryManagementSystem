package classes;

import java.io.Serializable;

public class Address implements Serializable{

	private String street;
	private String city;
	private String state;
	private int zip;
	
	public Address(String street, String city, String state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}
	
	public String toString() {
		return getStreet() +", "+ getCity() +", "+getState() +", "+getZip();
	}
	//private static final long serialVersionUID = 1L;
	
	
	
}
