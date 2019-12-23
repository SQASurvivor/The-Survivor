package Control;

import Character.User;
import Check.SortScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableController {
	@FXML
	private TableView<User> scoreT;
	
	@FXML
	private Button closeB;
	
	@FXML
	private TableColumn<User, Integer> Col1;
	
	@FXML
	private TableColumn<User, Integer> Col2;
	
	/**
	 * set the content of TableView
	 * @throws Exception IOException
	 */
	@FXML
	public void ShowScore () throws Exception {
		SortScore ss = new SortScore("Score.txt");
		int[] arr = ss.sortArray();
		int size = ss.getSize();
		if(size > 30) {
			size = 30;
		}
		
		ObservableList<User> list = FXCollections.observableArrayList();		
		for(int i = 0; i < size; ++i) {
			User usr = new User();
			usr.setRank(i+1);
			usr.setScore(arr[i]);
			list.add(usr);
		}

		Col1.setCellValueFactory(new PropertyValueFactory<User, Integer>("rank"));
		Col2.setCellValueFactory(new PropertyValueFactory<User, Integer>("score"));
		scoreT.setItems(list);
	}
	
	/**
	 * Close bottom, press to close stage
	 * @param event action event 
	 */
	@FXML
	public void pressbuttonClose(ActionEvent event) {	
		Stage stage = (Stage)closeB.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * show the content of TableView directly when open the stage
	 * @throws Exception IOException
	 */
	@FXML
	public void initialize() throws Exception {
		ShowScore();
	}  

	
}
