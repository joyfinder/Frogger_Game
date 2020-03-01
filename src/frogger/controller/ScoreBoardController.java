package frogger.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import frogger.view.ScoreBoardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * scoreBoardController class is used to control high score board shown.
 * Before high score board is displayed, player will enter their name in the textfield.
 * The interface moves on to final high score board showing player's score
 * after pressing submit button.
 * @author scytl2, 20027098
 *
 */
public class ScoreBoardController {
	
	// Controller
	@FXML
	public TextField userInput;
	
	@FXML
	public Button button;
	
	private String playerName;

	ArrayList<String> inputPlayerList = new ArrayList<String>();
	ArrayList<String> outputPlayerList2 = new ArrayList<String>();
	
	/**
	 * scoreBoardController constructor leaves no initialisation
	 */
	public ScoreBoardController()
	{
	}
	
	/**
	 * Uses button ActionEvent to control triggering the event.
	 * If user enters any input in the textfield,
	 * the user input will be saved into playerName String variable
	 * and stored into an array list in the inputPlayerList declared variable.
	 * Eventually, stored in player named text file.
	 * else the output will print out the message of "No player's name entered"
	 * As BufferedReader finishes its task of reading user's input
	 * Subsequently, it will open up high score board via scoreBoardShow variable
	 * @param event is used to identify button trigger 
	 * @throws IOException if an input or output exception occurred
	 */
	@FXML
	public void buttonController(ActionEvent event) throws IOException
	{
		Stage stage = (Stage) button.getScene().getWindow();
		if(userInput.getText() != null && !userInput.getText().isEmpty())
		{
			playerName = userInput.getText();
			FileWriter file = new FileWriter("src/frogger/model/player.txt");
			BufferedWriter script = new BufferedWriter(file);	
			inputPlayerList.add(userInput.getText());
			
			for(String playerName : inputPlayerList)
			{
				file.write(playerName + System.lineSeparator());
			}
			script.close();
		}
		else
		{
			System.out.println("No player's name entered");
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/frogger/model/player.txt")))
        {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                outputPlayerList2.add(sCurrentLine);
                System.out.println(sCurrentLine);
//                getPlayerName();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }	
		stage.close();
		ScoreBoardScene scoreBoardShow = new ScoreBoardScene();
	}
	
	/**
	 * getPlayerName is used to obtain player's name in different class
	 * @return the player's name
	 */
	public String getPlayerName()
	{
		return this.playerName;
	}
}
