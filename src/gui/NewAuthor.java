package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class NewAuthor extends Stage {
	public static NewAuthor INSTANCE = new NewAuthor();
	public static NewAuthorController Controller;

	public void init(Window owner) throws IOException {
		

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewAuthor.fxml"));
			Scene scene = new Scene(loader.load());
			Controller = loader.getController();

			resizableProperty().setValue(Boolean.FALSE);
			setScene(scene);

			Controller.init();

		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
}
