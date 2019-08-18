package classes;

import java.io.Serializable;

public class BookCopy implements Serializable {

	private int copyNumber;
	private Book book;
	private boolean available;

	public BookCopy(Book book, int copyNumber, boolean available) {
		this.copyNumber = copyNumber;
		this.book = book;
		this.available = available;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public Book getBook() {
		return book;
	}

	public boolean isAvailable() {
		return available;
	}

	public void changeAvailability() {
		available = !available;
	}

	@Override
	public String toString() {
		
		return getBook().getTitle();
	}

}
