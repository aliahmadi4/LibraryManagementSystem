package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecord implements Serializable{

	private int id;
	private Member member;
	private BookCopy bookCopy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutRecord(int id, Member member, BookCopy bookCopy) {
		this.id = id;
		this.member = member;
		this.bookCopy = bookCopy;
		this.checkoutDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(bookCopy.getBook().getCheckoutLength());
	}
	public CheckoutRecord(int id, Member member, BookCopy bookCopy, LocalDate checkoutDate) {
		this.id = id;
		this.member = member;
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = checkoutDate.plusDays(bookCopy.getBook().getCheckoutLength());
	}

	public Member getMember() {
		return member;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}
	
	@Override
	public String toString() {
		return this.getMember().getFirstName() + ", book title: " + this.getBookCopy().getBook().getTitle() + ", due to: " + this.getDueDate();
	}
	
}
