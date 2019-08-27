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

public class EditBookController {

	public List<Author> authors = new ArrayList<>();
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
    private Button findBtn;


    @FXML
    private TextField searchBox;
    
    @FXML
    private Label errorText;
    
    @FXML
    private Label authorsLabel;

   

    @FXML
    void findBtnClicked(ActionEvent event) {
    	DataAccess da = new DataAccessFacade();
    	Book book = da.findBook(searchBox.getText());
    	if(book==null) {
    		errorText.setVisible(true);
    	}else {
    		title.setText(book.getTitle());
    		isbn.setText(book.getIsbn());
    		authors.addAll(book.getAuthors());
    		checkoutLength.setText(book.getCheckoutLength().toString());
    		init();
    	}
    }
    
    
    
	@FXML
	void saveAction(ActionEvent event) {
		Book book = new Book(title.getText(), isbn.getText(), authors, Integer.parseInt(noOfCopy.getText()),
				Integer.parseInt(checkoutLength.getText()));
		DataAccess da = new DataAccessFacade();
		da.saveBook(book);
		EditBook.INSTANCE.close();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		EditBook.INSTANCE.close();
	}

	public void init() {
		authorsLabel.setText(authors.toString());
		errorText.setVisible(false);
	}

	@FXML
	void addAuthor(ActionEvent event) throws Exception {
		NewAuthor.INSTANCE.init(Root.getRootStage());
		NewAuthor.INSTANCE.show();
	}

}
