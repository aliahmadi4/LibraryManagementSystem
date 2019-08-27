package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class EditBook extends Stage {
	public static EditBook INSTANCE = new EditBook();
	public static EditBookController controller;
	
	
	
	public void init(Window owner) throws IOException {
		if (Login.INSTANCE.getOwner() == null)
			Login.INSTANCE.initOwner(owner);
		try {
			FXMLLoader  loader = new FXMLLoader(getClass().getResource("EditBook.fxml"));
			Scene scene = new Scene(loader.load());
			controller = loader.getController();
			setScene(scene);
			controller.init();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
