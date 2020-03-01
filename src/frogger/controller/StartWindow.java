package frogger.controller;

import frogger.Main;
import frogger.MyStage;
import frogger.model.BackgroundImage;
import frogger.view.Backgroundlogo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * StartWindow class is used to present start screen of guiding player to proceed further action.
 * @author scytl2
 *
 */
public class StartWindow {
	
	Stage primaryStage = new Stage(); 
	MyStage mystage = new MyStage(); 
	
	BackgroundImage startbackground = new BackgroundImage("file:src/frogger/view/froggerimage.jpg");
	Backgroundlogo froggerlogo = new Backgroundlogo("file:src/frogger/view/froggerlogo.png");
	InstructionController ins = new InstructionController();
	
	Scene startScene = new Scene(mystage, 780, 500);
	
	/**
	 * StartWindow is the beginning phase of showing pop up interface
	 * When pop up screen shows up, it does include three options for player to choose
	 * The first one is Start Game, which is to execute game directly
	 * The second one is Instruction, which gives player a guidance about how to play Frogger.
	 * The third one is Exit, which is to leave the game.
	 * @param imageLink links to self-made frogger image
	 */
	public StartWindow(String imageLink)
	{
		mystage.add(startbackground);
		mystage.add(froggerlogo);
		
		Button btn = new Button("Start Game");
		Button btn2 = new Button("Instruction");
		Button btn3 = new Button("Exit");
		
		btn.setLayoutX(80);
		btn.setLayoutY(200);
		btn.setScaleX(1.5);
		btn.setScaleY(1.5);
		btn2.setLayoutX(80);
		btn2.setLayoutY(300);
		btn2.setScaleX(1.5);
		btn2.setScaleY(1.5);
		
		btn3.setLayoutX(80);
		btn3.setLayoutY(400);
		btn3.setScaleX(1.5);
		btn3.setScaleY(1.5);
		
		btn.setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent event)
					{						
					    primaryStage.setScene(new Scene((Main.background), 550, 800));
					}
				});
		
		btn2.setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent event)
					{
						primaryStage.setScene(ins.getInstructionScene());
					}
				});
		
		btn3.setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent event)
					{
						primaryStage.close();
					}
				});
		mystage.addButton(btn);
		mystage.addButton(btn2);
		mystage.addButton(btn3);

		primaryStage.setScene(startScene);
		primaryStage.show();

	}
}
