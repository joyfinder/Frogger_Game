package frogger.view;

import frogger.Animal;
import frogger.MyStage;
import frogger.controller.ScoreBoardController;
import frogger.model.BackgroundImage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * scoreBoardScene represents displaying high score board
 * Its background image is retrieved from frogHSB.png and being called by BackgroundImage class
 * @author scytl2, 20027098
 *
 */
public class ScoreBoardScene extends ScoreBoardController {
	
	ScoreBoardController obj = new ScoreBoardController();
	String scoreStr;
	
	/**
	 * scoreBoardScene constructor specifying final high score board being displayed at the end of game
	 * After frogger game is finished, then high score board will display immediately.
	 * Furthermore, scoreBoardScene retrieves score from ScoreImageButton class and player name from ScoreBoardController class.
	 */
	public ScoreBoardScene()
	{	
		Stage primaryStage = new Stage();
		primaryStage.setTitle("High Score board");
		MyStage mystage = new MyStage();
		
		BackgroundImage hiscoreimage = new BackgroundImage("file:src/frogger/view/frogHSB.png");
		mystage.add(hiscoreimage);
		
		Text text = new Text();
		text.setText("Player: " + obj.getPlayerName());
		text.setFont(Font.font("Verdana",32));
		text.setX(290);
		text.setY(250);
		text.setFill(Color.WHITE);
		
		Text text2 = new Text();
		text2.setText("1st                              " + scoreStr + "  pts.");
		text2.setFont(Font.font("Verdana",32));
		text2.setX(140);
		text2.setY(300);
		text2.setFill(Color.WHITE);
		
		Text text3 = new Text();
		text3.setText("2nd                              " + scoreStr + " pts.");
		text3.setFont(Font.font("Verdana",32));
		text3.setX(140);
		text3.setY(350);
		text3.setFill(Color.WHITE);
		
		Text text4 = new Text();
		text4.setText("3rd                              " + scoreStr + "  pts.");
		text4.setFont(Font.font("Verdana",32));
		text4.setX(140);
		text4.setY(400);
		text4.setFill(Color.WHITE);
		
		Text text5 = new Text();
		text5.setText("4th                              " + scoreStr + "  pts.");
		text5.setFont(Font.font("Verdana",32));
		text5.setX(140);
		text5.setY(450);
		text5.setFill(Color.WHITE);
		
		Text text6 = new Text();
		text6.setText("5th                              " + scoreStr + "  pts.");
		text6.setFont(Font.font("Verdana",32));
		text6.setX(140);
		text6.setY(500);
		text6.setFill(Color.WHITE);
		
		Group obj = new Group(text, text2, text3, text4, text5, text6);

		mystage.getChildren().add(obj);
		Scene endScene = new Scene(mystage, 780, 580);
		primaryStage.setScene(endScene);
		primaryStage.show();
	}
	
	/**
	 * scoreBoard method is used to print out player's name on 
	 */
	public void scoreBoard()
	{
		
	}
	
	/**
	 * getScore method passes ScoreImageButton class to retrieve its score
	 * @param player used to receive score point
	 */
	public void getScore(ScoreImageButton player)
	{
		player.getPlayerScore();
	}
	
	/**
	 * getPlayerName class is used to receive player name from scoreBoardController class
	 * @param player means passing player name from scoreBoardController class
	 */
//	public void getPlayerName(ScoreBoardController player)
//	{
//		this.playerName = player.getPlayerName();
//	}


}

