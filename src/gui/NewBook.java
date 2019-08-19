package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewBook extends Application {
	public static Stage newBookStage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.newBookStage = new Stage();
		this.newBookStage.setTitle("New Book");
		showStage();
		
	}

	public void showStage() throws IOException	{
		Parent p = FXMLLoader.load(getClass().getResource("NewBook.fxml"));
		Scene scene = new Scene(p);
		newBookStage.setScene(scene);
		newBookStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
