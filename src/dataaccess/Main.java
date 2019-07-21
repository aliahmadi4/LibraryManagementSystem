package dataaccess;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import classes.Address;
import classes.*;


public class Main {

	public static void main(String[] args) {

		Address add = new Address("1000N", "Fairfield", "Iowa", 52557);
		
		//Members
		Member mmbr1 = new Member("Ali", "Ahmadi", add, "641-451-3308", 1);
		Member mmbr2 = new Member("John", "Doe", add, "641-451-3309", 1);
		Member mmbr3 = new Member("Bob", "Artist", add, "641-451-3307", 1);
		Member mmbr4 = new Member("Mike", "Jackson", add, "641-451-3306", 1);
		//System.out.println(mmbr1);
		
		//Authors
		Author author1 = new Author("Authur", "Trump", add, "641-451-3305", "Phd", "Nobel Prize Holder");
		List<Author> authors = new ArrayList<>();
		//authors.add(author1);
		
		//Books
		Book book1 = new Book("Algorithm", "ISBN-111111", authors, 3, 21);
		Book book2 = new Book("Mathematic", "ISBN-222222", authors, 3, 21);
		Book book3 = new Book("Data science", "ISBN-333333", authors, 1, 21);
		Book book4 = new Book("Physics", "ISBN-444444", authors, 1, 21);
		Book Periodical1 = new Book("Fashion Magazin", "ISBN-555555", authors, 2, 7);
		Book Periodical2 = new Book("Art Magazin", "ISBN-666666", authors, 2, 7);
		Book Periodical3 = new Book("Society Magazin", "ISBN-777777", authors, 2, 7);
		//System.out.println(book1);
		
		//Checkout
		CheckoutRecord checkout1 = new CheckoutRecord(1, mmbr1, book1.checkout());
		CheckoutRecord checkout2 = new CheckoutRecord(2, mmbr1, Periodical1.checkout());
		CheckoutRecord checkout3 = new CheckoutRecord(3, mmbr2, book2.checkout());
		CheckoutRecord checkout4 = new CheckoutRecord(4, mmbr2, Periodical1.checkout());
		CheckoutRecord checkout5 = new CheckoutRecord(5, mmbr3, book3.checkout(), LocalDate.of(2018, 01, 01));
		CheckoutRecord checkout6 = new CheckoutRecord(6, mmbr3, Periodical2.checkout());
		CheckoutRecord checkout7 = new CheckoutRecord(7, mmbr4, book4.checkout());
		CheckoutRecord checkout8 = new CheckoutRecord(8, mmbr4, Periodical3.checkout(), LocalDate.of(2019, 01, 01));
		//System.out.println(checkout1);
		
		DataAccess da = new DataAccessFacade();
		da.saveLibraryMember("emp", mmbr1);
		
		Member m = da.readLibraryMember("emp");
		System.out.println(m);
	}

}
