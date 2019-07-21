package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	private String title;
	private String isbn;
	private List<String> authors;
	private boolean availability;
	private List<BookCopy> copies = new ArrayList<>();
	private int checkoutLength;
	public Book(String title, String isbn, List<String> authors, boolean availability, int numberOfCopy,int checkoutLength) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
		this.availability = availability;
		this.makeCopy(numberOfCopy);
		this.checkoutLength = checkoutLength;
	}
	
	private void makeCopy(int n) {
		for(int i=0; i<n; i++) {
			BookCopy copy = new BookCopy(this, copies.size()+1, true);
			copies.add(copy);
		}
	}
	
	public String getTitle() {
		return title;
	}
	public String getIsbn() {
		return isbn;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public boolean isAvailability() {
		return availability;
	}
	
	public int getCheckoutLength() {
		return checkoutLength;
	}
	
	
	
	
	
}
