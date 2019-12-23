package Stage;

import Control.Gamemanager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainStage extends Application {
	private Stage theStage = new Stage(); 

	@Override
	public void start(Stage theStage) throws Exception {
		Group root = new Group();
		//Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );        
        theScene.setFill(Color.WHITE);
        
        Canvas canvas = new Canvas( 1000, 600 );
        root.getChildren().add( canvas );
        Gamemanager gameManager = new Gamemanager(root);
        
        theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.moveSurvivor(event));
        theScene.addEventHandler(KeyEvent.KEY_RELEASED, event -> gameManager.stopSurvivor(event));
        //theScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> gameManager.restartGame(event));
        
        theStage.show();
	}
	
	/**
     * start the application when other controller calls
     * @throws Exception the fxml file cannot fount or cannot open
     */
    public void switchtowin () throws Exception {
    	start(theStage);
    }
}
