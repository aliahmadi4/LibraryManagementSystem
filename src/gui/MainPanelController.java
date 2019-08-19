package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import classes.*;

public class MainPanelController implements Initializable {

	@FXML
	private Tab membersTab;

	@FXML
	private Tab booksTab;

	@FXML
	private MenuBar menubar;

	@FXML
	private Tab checkoutTab;

	@FXML
	private TableView<Member> memberTable;

	@FXML
	private TableColumn memberTableFirstName;

	@FXML
	private TableColumn memberTableId;

	@FXML
	private TableColumn memberTablePhone;

	@FXML
	private TableColumn memberTableAddress;

	@FXML
	private TableColumn memberTableLastName;

	@FXML
	private TableView<Book> booksTable;

	@FXML
	private TableColumn title;

	@FXML
	private TableColumn authors;

	@FXML
	private TableColumn isbn;

	@FXML
	private TableColumn checkoutLength;

	@FXML
	private TableView<CheckoutRecord> checkoutRecordTable;

	@FXML
	private TableColumn checkoutBookCopy;

	@FXML
	private TableColumn checkoutDueDate;

	@FXML
	private TableColumn checkoutMember;

	@FXML
	private TableColumn checkoutDate;

	@FXML
	private TableColumn checkoutId;

	@FXML
	void fillMemberTable(ActionEvent event) throws IOException {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		populateMembersTable();
		populateBooksTable();
		populateCheckoutRecordsTable();
	}

	public void populateMembersTable() {
		DataAccess daf = new DataAccessFacade();
		List<Member> members = daf.readMembersList();
		// System.out.println(members);
		memberTable.getItems().setAll(members);
		memberTableId.setCellValueFactory(new PropertyValueFactory<Member, Integer>("memberId"));
		memberTableFirstName.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
		memberTableLastName.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));
		memberTableAddress.setCellValueFactory(new PropertyValueFactory<Member, String>("address"));
		memberTablePhone.setCellValueFactory(new PropertyValueFactory<Member, String>("phoneNumber"));
	}

	public void populateBooksTable() {
		DataAccess daf = new DataAccessFacade();
		List<Book> books = daf.readBooksList();
		booksTable.getItems().setAll(books);
		title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		isbn.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
		checkoutLength.setCellValueFactory(new PropertyValueFactory<Book, String>("checkoutLength"));
		authors.setCellValueFactory(new PropertyValueFactory<Book, Author>("authors"));
	}

	public void populateCheckoutRecordsTable() {
		DataAccess daf = new DataAccessFacade();
		List<CheckoutRecord> checkoutRecords = daf.readCheckoutRecordsList();
		checkoutRecordTable.getItems().setAll(checkoutRecords);
		checkoutId.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("id"));
		checkoutMember.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("member"));
		checkoutBookCopy.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, BookCopy>("bookCopy"));
		checkoutDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("checkoutDate"));
		checkoutDueDate.setCellValueFactory(new PropertyValueFactory<CheckoutRecord, String>("dueDate"));

	}

	@FXML
	void openNewMemberWindow(ActionEvent event) throws Exception {
		NewMember nm = new NewMember();
		nm.start(Root.primaryStage);
	}

	@FXML
	void update(ActionEvent event) {
		populateBooksTable();
		populateMembersTable();
		populateCheckoutRecordsTable();
	}

	@FXML
	void newBook(ActionEvent event) throws Exception {
		NewBook nb = new NewBook();
		nb.start(Root.primaryStage);
		
	}

}
