package Control;

import Stage.MainStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {
	@FXML
	private Button startB;
	
	/**
	 * Start button action, press to start
	 * @param event action event
	 * @throws Exception start exception
	 */
	@FXML
	public void pressbuttonStart(ActionEvent event) throws Exception {	
		Stage stage = (Stage)startB.getScene().getWindow();
		MainStage open = new MainStage();
		open.switchtowin();
		stage.close();
	}
}
