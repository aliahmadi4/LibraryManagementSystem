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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import classes.*;

public class LoginController {
	@FXML
	private PasswordField password;

	@FXML
	private Button loginBtn;

	@FXML
	private Button cancelBtn;

	@FXML
	private TextField username;
	@FXML
	private Label errorMsg;

	@FXML
	void loginClick(ActionEvent event) throws IOException {
		
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> users = da.readUsers();

		if (users.containsKey(username.getText())) {
			if (users.get(username.getText()).getPassword().equals(password.getText())) {
				Root.setUserRole(users.get(username.getText()).getUserRole());
				MainPanel.INSTANCE.init(Root.getRootStage());
				MainPanel.INSTANCE.show();
				Login.INSTANCE.hide();
			}else {
				errorMsg.setVisible(true);
			}
		}else {
			errorMsg.setVisible(true);
		}

	}

	@FXML
	void cancelClick(ActionEvent event) {
		System.exit(0);
	}

	public void init() {
		errorMsg.setVisible(false);
	}

}
