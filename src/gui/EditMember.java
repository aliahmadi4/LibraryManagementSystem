package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditMember extends Application {
	public static Stage editMemberStage;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.editMemberStage = new Stage();
		this.editMemberStage.setTitle("Edit Member");
		showStage();
		
	}

	public void showStage() throws IOException	{
		Parent p = FXMLLoader.load(getClass().getResource("EditMember.fxml"));
		Scene scene = new Scene(p);
		editMemberStage.setScene(scene);
		editMemberStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
