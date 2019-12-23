package Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HighScore extends Application {
	private Stage theStage = new Stage();
	
	/**
	 * start the application
	 */
    @Override
    public void start(Stage theStage) throws Exception{
    	 Parent root = FXMLLoader.load(getClass().getResource("HighScore.fxml"));
    	 theStage.setTitle( "Pacman" );
    	 Scene theScene = new Scene( root );
    	 theStage.setScene( theScene );
    	 theStage.show();
    }
    
    /**
     * start the application when other controller calls
     * @throws Exception the fxml file cannot fount or cannot open
     */
    public void switchwin () throws Exception {
    	start(theStage);
    	
    } 
    
    /**
     * Close the stage
     */
    public void closewin() {
    	theStage.close();
    }
}
