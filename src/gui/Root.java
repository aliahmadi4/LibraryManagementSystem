package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Root extends Application {
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws IOException{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Library Management System");
		showStage();
	}

	public void showStage() throws IOException	{
		Parent root = FXMLLoader.load(getClass().getResource("MainPanel.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
