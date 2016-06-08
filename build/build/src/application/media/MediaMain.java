package application.media;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Version 0.3
 * @author htha9587
 * 6-7-16
 */

/**
 * Loads Stage with FXML and CSS files.
 * @author htha9587
 *
 */
public class MediaMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Media.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("MediaPlayerFX");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launches the application.
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
