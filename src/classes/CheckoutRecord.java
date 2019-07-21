package classes;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecord implements Serializable{

	private Member member;
	private BookCopy bookCopy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutRecord(Member member, BookCopy bookCopy, LocalDate checkoutDate, LocalDate dueDate) {
		this.member = member;
		this.bookCopy = bookCopy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
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
	
	
}
