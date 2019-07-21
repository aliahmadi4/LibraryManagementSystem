package classes;

public class Member extends Person{

	private int memberId;

	public Member(String firstName, String lastName, Address address, String phoneNumber, int memberId) {
		super(firstName, lastName, address, phoneNumber);
		this.memberId = memberId;
	}

	public int getMemberId() {
		return memberId;
	}
	
	
}
