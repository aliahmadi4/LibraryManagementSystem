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
	
	Map<Integer, Member> members = new HashMap<>();
	Map<String, Book> books = new HashMap<>();
	Map<Integer, CheckoutRecord> records = new HashMap<>();
	
	public void saveMember(Member member) {
		members.put(member.getMemberId(), member);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(members);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
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
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	public void saveCheckoutRecord(CheckoutRecord checkout){
		records.put(checkout.getId(), checkout);
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(records);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}
	
	public HashMap<Integer, Member> readMembers() {
		ObjectInputStream in = null;
		HashMap<Integer, Member> members = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.MEMBERS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			members = (HashMap<Integer, Member>)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return members;
	}
	public HashMap<String, Member> readBooks(){
		ObjectInputStream in = null;
		HashMap<String, Member> books = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.BOOKS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			books = (HashMap<String, Member>)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return books;
	}
	
	public HashMap<Integer, Member> readCheckoutRecords(){
		ObjectInputStream in = null;
		HashMap<Integer, Member> checkoutrecords = new HashMap<>();
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, Table.RECORDS.name());
			in = new ObjectInputStream(Files.newInputStream(path));
			checkoutrecords = (HashMap<Integer, Member>)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return checkoutrecords;
	}
	
}
