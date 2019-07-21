package classes;

public class Person {

	private String firstName;
	private String lastName;
	private Address address;
	private String phoneNumber;
	
	public Person(String firstName, String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
}
