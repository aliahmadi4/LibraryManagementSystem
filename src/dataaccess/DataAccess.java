package dataaccess;

import java.util.HashMap;
import java.util.List;

import classes.*;

public interface DataAccess {
	//User
	public void saveUser(User user);
	public HashMap<String, User> readUsers();
	
	//Members
	public void saveMember(Member member);
	public HashMap<Integer, Member> readMembers();
	public List<Member> readMembersList();
	public Member findMember(int id);
	
	//Book
	public void saveBook(Book book);
	public HashMap<String, Book> readBooks();
	public List<Book> readBooksList();
	public Book findBook(String isbn);
	
	//CheckoutRecord
	public void saveCheckoutRecord(CheckoutRecord checkout);
	public HashMap<Integer, CheckoutRecord> readCheckoutRecords();
	public List<CheckoutRecord> readCheckoutRecordsList();
	
}
