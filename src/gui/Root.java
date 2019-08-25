package gui;

import java.io.IOException;

import classes.UserRole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Root extends Application {
	public static Stage rootStage;
	public static UserRole userRole;
	
	public static Stage getRootStage() {
		return rootStage;
	}



	public static void setRootStage(Stage rootStage) {
		Root.rootStage = rootStage;
	}



	public static UserRole getUserRole() {
		return userRole;
	}



	public static void setUserRole(UserRole userRole) {
		Root.userRole = userRole;
	}



	@Override
	public void start(Stage primaryStage) throws IOException{
		rootStage = primaryStage;
		primaryStage.setTitle("Library management System");
		Login.INSTANCE.init(primaryStage);
		Login.INSTANCE.show();
	}

	
	
	public static void main(String[] args) {
		launch(args);
	}
}
