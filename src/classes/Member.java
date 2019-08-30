package classes;

import java.io.Serializable;
import java.util.Objects;

public class Member extends Person implements Serializable{

	//private static final long serialVersionUID = -2226197306790714013L;
	private Integer memberId;

	public Member(String firstName, String lastName, Address address, String phoneNumber, Integer memberId) {
		super(firstName, lastName, address, phoneNumber);
		this.memberId = memberId;
	}
	
	public Member(String firstName, String lastName, Address address, String phoneNumber) {
		super(firstName, lastName, address, phoneNumber);
		this.memberId = 0;
	}

	public Integer getMemberId() {
		return memberId;
	}
	
	public String getFullName() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
//	@Override
//	public int hashCode() {
//		return Objects.hash();
//	}
	
	

	public String toString() {
		return this.getFirstName() + " " + this.getLastName() ;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
}
