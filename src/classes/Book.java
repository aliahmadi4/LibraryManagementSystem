package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable{

	private String title;
	private String isbn;
	private List<Author> authors;
	private List<BookCopy> copies = new ArrayList<>();
	private Integer checkoutLength;
	
	public Book(String title, String isbn, List<Author> authors, int numberOfCopy,Integer checkoutLength) {
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
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
	public List<Author> getAuthors() {
		return authors;
	}
	public boolean isAvailable() {
		return copies.stream().map(x->x.isAvailable()).reduce(false, (x,y)->x||y);
	}
	
	public Integer getCheckoutLength() {
		return checkoutLength;
	}
	public Integer getNoOfCopy() {
		return copies.size();
	}

	public BookCopy checkout() {
		if(isAvailable()) {
			BookCopy bookcopy= null;
			for(BookCopy bc: copies) {
				if(bc.isAvailable()) {
					bc.changeAvailability();
					bookcopy = bc;
					break;
				}
				
			}
			return bookcopy;
		}
		return null;
	}

	
	@Override
	public String toString() {
		return this.getTitle()+ ", by: " + authorsName();
	}
	
	public String authorsName() {
		String s="";
		for(Author a: authors) {
			s+= a.getFirstName() + a.getLastName() + " ";
		}
		return s;
	}
	
	
	
	
}
