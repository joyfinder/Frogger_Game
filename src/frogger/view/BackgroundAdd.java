package frogger.view;

import frogger.MyStage;
import frogger.model.BackgroundImage;
import frogger.model.Digit;
import frogger.model.End;
import frogger.model.Log;
import frogger.model.Obstacle;
import frogger.model.Turtle;
import frogger.model.WetTurtle;

public class BackgroundAdd {
	
	BackgroundImage froggerbackground = new BackgroundImage("file:src/frogger/view/froggerbackground.png");
	static MyStage background = new MyStage();
	
	/**
	 * backgroundAdd constructor controls Frogger's background scene.
	 * @param background represents the objects shown on Frogger's game page
	 * In the main page, it includes log, turtle, wet turtle and obstacles.
	 * The background argument specifies the images being presented in the world
	 */
	public BackgroundAdd(MyStage background)
	{
		background.add(froggerbackground);
		
		background.add(new Log("file:src/frogger/view/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 220, 166, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/frogger/view/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:src/frogger/view/logs.png", 300, 0, 276, -2));
		background.add(new Log("file:src/frogger/view/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/frogger/view/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 50, 329, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 270, 329, 0.75));
		background.add(new Log("file:src/frogger/view/log3.png", 150, 490, 329, 0.75));
//		//background.add(new Log("file:src/frogger/view/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 376, -1, 330, 330));
		background.add(new Turtle(300, 376, -1, 130, 130));
		background.add(new WetTurtle(700, 376, -1, 130, 130));
		background.add(new WetTurtle(600, 217, -1, 130, 130));
		background.add(new WetTurtle(400, 217, -1, 130, 130));
		background.add(new WetTurtle(200, 217, -1, 130, 130));
		
		background.add(new End(13,96));
		background.add(new End(141,96));
		background.add(new End(141 + 141-13,96));
		background.add(new End(141 + 141-13+141-13+1,96));
		background.add(new End(141 + 141-13+141-13+141-13+3,96));
		
		// note from 56 to 67
	background.add(new Obstacle("file:src/frogger/view/truck1"+"Right.png", 0, 649, 1, 120, 120));
	background.add(new Obstacle("file:src/frogger/view/truck1"+"Right.png", 300, 649, 1, 120, 120));
//	background.add(new Obstacle("file:src/frogger/view/truck1"+"Right.png", 600, 649, 1, 120, 120));
//	//background.add(new Obstacle("file:src/frogger/view/truck1"+"Right.png", 720, 649, 1, 120, 120));
	background.add(new Obstacle("file:src/frogger/view/car1Left.png", 100, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/frogger/view/car1Left.png", 250, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/frogger/view/car1Left.png", 400, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/frogger/view/car1Left.png", 550, 597, -1, 50, 50));
	background.add(new Obstacle("file:src/frogger/view/truck2Right.png", 0, 540, 1, 200, 200));
//	background.add(new Obstacle("file:src/frogger/view/truck2Right.png", 500, 540, 1, 200, 200));
//	background.add(new Obstacle("file:src/frogger/view/car1Left.png", 500, 490, -5, 50, 50));
	background.add(new Digit(0, 30, 500, 25));
	
	
	}
	

}
