package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewAuthor extends Application {
	public static Stage newAuthorStage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.newAuthorStage = new Stage();
		this.newAuthorStage.setTitle("New Author");
		showStage();
		
	}

	public void showStage() throws IOException	{
		Parent p = FXMLLoader.load(getClass().getResource("NewAuthor.fxml"));
		Scene scene = new Scene(p);
		newAuthorStage.setScene(scene);
		newAuthorStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
