
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		
		FXMLLoader fxml = new FXMLLoader();
		fxml.setLocation(getClass().getResource("GenView.fxml"));
    	AnchorPane gen = (AnchorPane) fxml.load();
    	
        GenController genController = fxml.getController();
        genController.PrimaryStage = primaryStage;

        Scene scene = new Scene(gen);
        
        primaryStage.setTitle("Gen Pass - Générer un mot de passe facilement.");
        
        primaryStage.getIcons().add(new Image("file:icon.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
