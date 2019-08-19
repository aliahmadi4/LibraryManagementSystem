package gui;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import classes.Address;
import classes.Author;
import classes.Book;
import classes.Member;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewBookControler implements Initializable {
	public static List<Author> authors = new ArrayList<>();
	@FXML
    private Button cancelBtn;

    @FXML
    private TextField isbn;

    @FXML
    private TextField checkoutLength;

    @FXML
    private TextField title;

    @FXML
    private TextField noOfCopy;

    @FXML
    private Button saveBtn;
    

    @FXML
    private Label authorsLabel;

	
	@FXML
	void saveAction(ActionEvent event) {
		Book book = new Book(title.getText(), isbn.getText(), authors, Integer.parseInt(noOfCopy.getText()), Integer.parseInt(checkoutLength.getText()));
		DataAccess da = new DataAccessFacade();
		da.saveBook(book);
		NewBook.newBookStage.close();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		NewBook.newBookStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	@FXML
    void addAuthor(ActionEvent event) throws Exception {
		NewAuthor na = new NewAuthor();
		na.start(Root.primaryStage);
    }

}
