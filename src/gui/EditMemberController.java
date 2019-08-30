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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditMemberController {

	@FXML
	private TextField zip;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField search;

	@FXML
	private TextField phoneNumber;

	@FXML
	private TextField city;

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField street;

	@FXML
	private Button findBtn;

	@FXML
	private TextField state;

	@FXML
	private TextField id;

	@FXML
	private Button saveBtn;

	@FXML
	private Label findError;
	
	@FXML
	private Label phoneError;

	@FXML
	private Label firstNameError;

	@FXML
	private Label lastNameError;

	@FXML
	private Label stateError;

	@FXML
	private Label streetError;

	@FXML
	private Label zipError;
	@FXML
	private Label cityError;

	@FXML
	void findAction(ActionEvent event) {
		DataAccess da = new DataAccessFacade();
		Member mmbr = da.findMember(Integer.parseInt(search.getText()));
		if (mmbr == null) {
			findError.setVisible(true);
		} else {
			id.setText(mmbr.getMemberId().toString());
			firstName.setText(mmbr.getFirstName());
			lastName.setText(mmbr.getLastName());
			phoneNumber.setText(mmbr.getPhoneNumber());
			street.setText(mmbr.getAddress().getStreet());
			city.setText(mmbr.getAddress().getCity());
			state.setText(mmbr.getAddress().getState());
			zip.setText(mmbr.getAddress().getZip().toString());
		}
	}

	@FXML
	void saveAction(ActionEvent event) {
		
		Boolean firstNameErrorr = Validation.isValid(firstName.getText(), "String", firstNameError);
		Boolean lastNameErrorr = Validation.isValid(lastName.getText(), "String", lastNameError);
		Boolean phoneErrorr=  Validation.isValid(phoneNumber.getText(), "Number", phoneError);
		Boolean streetErrorr= Validation.isValid(street.getText(), "Address", streetError);
		Boolean cityErrorr = Validation.isValid(city.getText(), "Address", cityError);
		Boolean stateErrorr= Validation.isValid(state.getText(), "Address", stateError);
		Boolean zipErrorr= Validation.isValid(zip.getText(), "Number", zipError);
		
		if(!firstNameErrorr || !lastNameErrorr || !phoneErrorr || !streetErrorr || !cityErrorr || !stateErrorr || !zipErrorr) {
			return;
		}
		
		Address address = new Address(street.getText(), city.getText(), state.getText(),
				Integer.parseInt(zip.getText()));
		Member mmr = new Member(firstName.getText(), lastName.getText(), address, phoneNumber.getText(),
				Integer.parseInt(id.getText()));

		DataAccess da = new DataAccessFacade();
		da.saveMember(mmr);
		EditMember.INSTANCE.hide();
	}

	@FXML
	void cancelAction(ActionEvent event) {
		EditMember.INSTANCE.hide();
	}

	public void init() {
		findError.setVisible(false);
		
	}

}
