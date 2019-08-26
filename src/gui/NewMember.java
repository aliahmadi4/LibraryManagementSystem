package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class NewMember extends Stage {

	
	
	public static NewMember INSTANCE = new NewMember();
	public static NewMemberController Controller;

	public void init(Window owner) throws IOException {
		if (Login.INSTANCE.getOwner() == null)
			Login.INSTANCE.initOwner(owner);

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("NewMember.fxml"));
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
