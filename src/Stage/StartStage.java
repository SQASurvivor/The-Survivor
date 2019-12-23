package Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartStage extends Application {
	private Stage theStage = new Stage();
	
	@Override
	public void start(Stage theStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
     	theStage.setTitle( "The Survivor" );
     	Scene theScene = new Scene( root );
     	theStage.setScene( theScene );
     	theStage.show();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        launch(args);
     }
}
