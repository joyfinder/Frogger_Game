package frogger.controller;

import javafx.event.EventHandler;
import frogger.MyStage;
import frogger.model.BackgroundImage;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * InstructionController class represents displaying instruction page.
 * As clicking instruction button on pop up screen,
 * The scene will be adjusted into a further instruction page.
 * @author scytl2
 *
 */
public class InstructionController {
	
	Stage ins_primaryStage = new Stage();
	MyStage ins_mystage = new MyStage();
	
	BackgroundImage ins = new BackgroundImage("file:src/frogger/froggerInstruction.png");
	
	Scene insScene = new Scene(ins_mystage, 580, 500);
	
	/**
	 * InstructionController constructor specifying the guidance of playing Frogger game
	 * For instruction button, making use of both setLayout and setScale method to adjust button's coordinates
	 */
	public InstructionController()
	{	
		ins_mystage.add(ins);
		
		Button btn = new Button("Back");
		
		btn.setLayoutX(80);
		btn.setLayoutY(400);
		btn.setScaleX(1.5);
		btn.setScaleY(1.5);
		
		ins_mystage.addButton(btn);
		
		btn.setOnAction(new EventHandler<ActionEvent>()
				{
					public void handle(ActionEvent event)
					{

					}
				});
	}
	
	 /**
	  * getInstructionScene method is used to change scene into frogger's instruction page
	  * @return the instruction scene
	  */
	public Scene getInstructionScene()
	{
		return insScene;
	}
}
