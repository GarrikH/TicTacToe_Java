package edu.citytech.games;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GamesMain extends Application {

	public static void main(String[] args) {
		Application.launch(GamesMain.class, args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Games.fxml"));
		stage.setTitle("Tic Tac Toe");
		stage.setScene(new Scene(root));
		
		URL url = this.getClass().getResource("Games.css");
		if(url == null) {
			System.out.println("Resource not found. Aborting.");
			System.exit(-1);
		}
		
		stage.show();
	}

}