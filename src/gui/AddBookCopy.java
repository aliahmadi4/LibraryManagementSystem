package gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AddBookCopy extends Stage {
	public static AddBookCopy INSTANCE = new AddBookCopy();
	public static AddBookCopyController controller;
	
	
	
	public void init(Window owner) throws IOException {
		
		try {
			FXMLLoader  loader = new FXMLLoader(getClass().getResource("AddBookCopy.fxml"));
			Scene scene = new Scene(loader.load());
			controller = loader.getController();
			setScene(scene);
			controller.init();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
