package dataaccess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.*;
import dataaccess.Table;

public class DataAccessFacade implements DataAccess {

	public static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\src\\dataaccess\\storage";
	public static final String DATE_PATTERN = "MM/dd/yyyy";

	Map<String, User> users = readUsers();
	Map<Integer, Member> members = readMembers();
	Map<String, Book> books = readBooks();
	Map<Integer, CheckoutRecord> records = readCheckoutRecords();

	public void saveUser(User user) {
		users.put(user.getUsername(), user);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.USERS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(users);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void saveMember(Member member) {
		HashMap<Integer, Member> mmbrs = readMembers();
		int nextId=1;
		if(mmbrs.size() >0) {
			
			nextId = mmbrs.get(mmbrs.size()).getMemberId()+1;
		}
		member.setMemberId(nextId);
		members.put(member.getMemberId(), member);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(members);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void saveBook(Book book) {
		books.put(book.getIsbn(), book);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.BOOKS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(books);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public void saveCheckoutRecord(CheckoutRecord checkout) {
		records.put(checkout.getId(), checkout);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(records);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public HashMap<String, User> readUsers() {
		ObjectInputStream in = null;
		HashMap<String, User> users = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.USERS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			users = (HashMap<String, User>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return users;
	}

	public HashMap<Integer, Member> readMembers() {
		ObjectInputStream in = null;
		HashMap<Integer, Member> members = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			members = (HashMap<Integer, Member>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return members;
	}

	public HashMap<String, Book> readBooks() {
		ObjectInputStream in = null;
		HashMap<String, Book> books = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.BOOKS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			books = (HashMap<String, Book>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return books;
	}

	public HashMap<Integer, CheckoutRecord> readCheckoutRecords() {
		ObjectInputStream in = null;
		HashMap<Integer, CheckoutRecord> checkoutrecords = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			checkoutrecords = (HashMap<Integer, CheckoutRecord>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return checkoutrecords;
	}

	public List<Member> readMembersList() {

		List<Member> members = new ArrayList<Member>();
		for (Member m : readMembers().values()) {
			members.add(m);
		}
		return members;
	}

	@Override
	public List<Book> readBooksList() {
		List<Book> books = new ArrayList<>();
		for (Book b : readBooks().values()) {
			books.add(b);
		}
		return books;
	}

	@Override
	public List<CheckoutRecord> readCheckoutRecordsList() {
		List<CheckoutRecord> checkoutRecords = new ArrayList<>();
		for (CheckoutRecord cr : readCheckoutRecords().values()) {
			checkoutRecords.add(cr);
		}
		return checkoutRecords;
	}

	@Override
	public Member findMember(int id) {
		HashMap<Integer, Member> members = readMembers();
		return members.get(id);
	}

	@Override
	public Book findBook(String isbn) {
		HashMap<String, Book> books = readBooks();
		return books.get(isbn);
	}

	@Override
	public List<CheckoutRecord> searchCheckout(int id) {
		List<CheckoutRecord> checkoutRecords = new ArrayList<>();
		for (CheckoutRecord cr : readCheckoutRecords().values()) {
			if (cr.getMember().getMemberId() == id)
				checkoutRecords.add(cr);
		}
		return checkoutRecords;
	}

}
