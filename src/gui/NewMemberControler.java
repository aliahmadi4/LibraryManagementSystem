package gui;


import java.net.URL;
import java.util.ResourceBundle;

import classes.Address;
import classes.Member;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewMemberControler implements Initializable {

	@FXML
	private TextField zip;
	
	@FXML
	private TextField id;


	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField city;

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField street;

	@FXML
	private TextField state;

	@FXML
	private Button saveBtn;

	@FXML
	void saveAction(ActionEvent event) {
		Address address = new Address(street.getText(), city.getText(), state.getText(), Integer.parseInt(zip.getText()));
		Member mmr = new Member(firstName.getText(), lastName.getText(), address, phoneNumber.getText(), Integer.parseInt(id.getText()));
		
		DataAccess da = new DataAccessFacade();
		da.saveMember(mmr);
		NewMember.newMemberStage.close();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		NewMember.newMemberStage.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
