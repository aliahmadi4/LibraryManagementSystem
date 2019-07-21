package dataaccess;

import classes.Address;
import classes.Member;

public class Main {

	public static void main(String[] args) {

		Address add = new Address("1000N", "Fairfield", "Iowa", 52557);
		Member mmbr = new Member("ali", "ahmadi", add, "+93464654", 1);
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember("emp", mmbr);
		
		Member m = da.readLibraryMember("emp");
		System.out.println(m);
	}

}
