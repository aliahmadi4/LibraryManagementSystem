package classes;

import java.io.Serializable;
import java.util.Objects;

public class Member extends Person implements Serializable{

	private static final long serialVersionUID = -2226197306790714013L;
	private int memberId;

	public Member(String firstName, String lastName, Address address, String phoneNumber, int memberId) {
		super(firstName, lastName, address, phoneNumber);
		this.memberId = memberId;
	}

	public int getMemberId() {
		return memberId;
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash();
//	}
	
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + " " + this.getAddress().getStreet();
	}
}
