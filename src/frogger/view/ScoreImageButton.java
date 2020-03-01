package frogger.view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import frogger.Animal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * scoreImageButton means API of displaying button image before high score board shows
 * @author scytl2
 *
 */
public class ScoreImageButton {
	
	Stage primaryStage = new Stage();
	
	/**
	 * Class constructor: initializing score point at the end of game.
	 * Before high score board shows up,
	 * Score will be stored in scoreImageButton class and display on high score board next.
	 * @param animal is used as retrieving score point players achieves during the game.
	 */
	public ScoreImageButton(Animal animal){
		this.score = animal.getPoints();
	}
	
	int score;
	String scoreStr;
	
	ArrayList<String> playerScore = new ArrayList<String>();
	
	/**
	 * scoreImage consists of scoreBoard fxml used to generate button event image
	 * This API requests player to enter their name in the textfield
	 * @throws IOException if an input or output 
	 */
	public void scoreImage() throws IOException
	{
		
		try {
			AnchorPane playerGUI = (AnchorPane)FXMLLoader.load(getClass().getResource("scoreBoard.fxml"));
			Scene scene = new Scene(playerGUI, 500, 300);
			primaryStage.setTitle("Frogger HiScore Board");
	
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		 FileWriter file = new FileWriter("src/frogger/model/score.txt");
		 BufferedWriter script = new BufferedWriter(file);
		 scoreStr = String.valueOf(score);
		 playerScore.add(scoreStr);
		 
		 for(String scoreList : playerScore)
		 {
			 file.write(scoreList + System.lineSeparator());
		 }
		 
		 script.close();
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/frogger/model/score.txt")))
		{
			String iCurrentLine;
			
			while((iCurrentLine = br.readLine()) != null) {
				playerScore.add(iCurrentLine);
				
				// print out the score result on scoreBoard scene
				System.out.println("Player's score: " + iCurrentLine);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
			
		}
		
	}
	
	public int getPlayerScore()
	{
		return score;
	}
	
}
