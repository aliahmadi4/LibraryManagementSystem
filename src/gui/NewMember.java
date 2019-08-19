package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewMember extends Application {
	public static Stage newMemberStage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.newMemberStage = new Stage();
		this.newMemberStage.setTitle("New Member");
		showStage();
		
	}

	public void showStage() throws IOException	{
		Parent p = FXMLLoader.load(getClass().getResource("NewMember.fxml"));
		Scene scene = new Scene(p);
		newMemberStage.setScene(scene);
		newMemberStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
