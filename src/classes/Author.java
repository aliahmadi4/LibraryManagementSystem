package classes;


public class Author extends Person{

	private String credentials;
	private String shortBio;
	
	public Author(String firstName, String lastName, Address address, String phoneNumber, String credentials,
			String shortBio) {
		super(firstName, lastName, address, phoneNumber);
		this.credentials = credentials;
		this.shortBio = shortBio;
	}

	public String getCredentials() {
		return credentials;
	}

	public String getShortBio() {
		return shortBio;
	}
	
	
}
