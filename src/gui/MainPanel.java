package gui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainPanel extends Stage {
	
	public static MainPanel INSTANCE = new MainPanel();
	public static MainPanelController Controller;

	public void init(Window owner) throws IOException {
		if (Login.INSTANCE.getOwner() == null)
			Login.INSTANCE.initOwner(owner);

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPanel.fxml"));
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
