package dataaccess;

import java.util.HashMap;
import java.util.List;

import classes.*;

public interface DataAccess {
	//Members
	public void saveMember(Member member);
	public HashMap<Integer, Member> readMembers();
	
	//Book
	public void saveBook(Book book);
	public HashMap<String, Member> readBooks();
	
	//CheckoutRecord
	public void saveCheckoutRecord(CheckoutRecord checkout);
	public HashMap<Integer, Member> readRecords();
	
}
