package edu.citytech.games;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class GamesController {
    @FXML
    private FlowPane fpGames;
    @FXML
    private Button btnReset;  
    @FXML
    private Label lblMessage;  
    @FXML
    private Label lbl_1;
    @FXML
    private Label lbl_2;
    @FXML
    private Label lbl_3;   
    @FXML
    private Label lbl_4;
    @FXML
    private Label lbl_5;
    @FXML
    private Label lbl_6;   
    @FXML
    private Label lbl_7;
    @FXML
    private Label lbl_8;
    @FXML
    private Label lbl_9;
    @FXML
    private Label lbl_name;
    @FXML
    private Label lbl_turnLabel;
    @FXML
    private Label lbl_turn;

    private boolean isX = false;
    private boolean winner = false;
    
    @FXML
    void onMouseClicked(MouseEvent event) {
    	Label label = (Label) event.getSource();
		lblMessage.setText("");		
		//If no winner yet
		if(!winner) 
		{
			if(! label.getText().equals("?"))
			{
				lblMessage.setText("Illegal Move, Cheater!");
				return;
			}
			String nextMove = isX? "X":"O";
			label.setText(nextMove);
			isX = !isX;
			lbl_turn.setText(isX? "X":"O");
			winner =   playGame(lbl_1, lbl_2, lbl_3, lblMessage)
					|| playGame(lbl_4, lbl_5, lbl_6, lblMessage)
					|| playGame(lbl_7, lbl_8, lbl_9, lblMessage)
					|| playGame(lbl_1, lbl_4, lbl_7, lblMessage)
					|| playGame(lbl_2, lbl_5, lbl_8, lblMessage)
					|| playGame(lbl_3, lbl_6, lbl_9, lblMessage)
					|| playGame(lbl_1, lbl_5, lbl_9, lblMessage)
					|| playGame(lbl_3, lbl_5, lbl_7, lblMessage);
		}
		//If winner is true
		else
		{
			lblMessage.setText("Please press reset to play again.");
		}
    }

    @FXML
    void reset(ActionEvent event) {
    	Label[] labelArray = new Label[] {lbl_1, lbl_2, lbl_3, lbl_4, lbl_5, lbl_6, lbl_7, lbl_8, lbl_9, };
    	for(Label l : labelArray)
    	{
    		l.setStyle("-fx-text-fill: black");
    		l.setText("?");
    	}
    	lblMessage.setText("");
    	winner = false;
    }
    //Check if 3 labels have the same text; set style; display if a winner; return if win
    public static boolean playGame(Label x1, Label x2, Label x3, Label msg)
    {
    	String a1 = x1.getText();
    	String a2 = x2.getText();
    	String a3 = x3.getText();
    	if(!a1.equals("?") && a2.equals(a3) && a3.equals(a1))
    	{
    		x1.setStyle("-fx-text-fill: red");
    		x2.setStyle("-fx-text-fill: red");
    		x3.setStyle("-fx-text-fill: red");
    		msg.setText(a1 + " wins the game. Press reset to play again.");
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
};