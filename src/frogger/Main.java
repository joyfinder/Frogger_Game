package frogger;

import java.io.IOException;

import frogger.controller.StartWindow;
import frogger.model.Digit;
import frogger.view.BackgroundAdd;
import frogger.view.ScoreImageButton;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main is used to execute the program.
 * @author scytl2
 * @version 10
 */
public class Main extends Application {
	
	Animal animal;
	AnimationTimer timer;
	public static MyStage background = new MyStage();


	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		StartWindow startwindow = new StartWindow("file:src/frogger/view/froggerimage.png");
		
		BackgroundAdd backgroundStart = new BackgroundAdd(background);
		
		animal = new Animal("file:src/frogger/view/froggerUp.png");
		background.add(animal);
		
		background.start();
		start();
		
	}
	
	/**
	 * When frog completes running into End blocks, the screen pops up total time players spend playing
	 */
	public void createTimer() {
        timer = new AnimationTimer() {
        	
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		
            		background.stopMusic();
            		stop();
            		background.stop();  
            		
            		ScoreImageButton frogScoreBoard = new ScoreImageButton(animal);
            		try {
						frogScoreBoard.scoreImage();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	
            	}
            }
        };
    }
	
	/**
	 * start method determines when Frogger launches, then it will automatically play background music.
	 */
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }
	
	/**
	 * stop meethod is used as pausing background music.
	 */
    public void stop() {
        timer.stop();
    }
    
    /**
     * setNumber is defined as counting frog's movement
     * @param numberOfMoves represents the number of frog's movement towards End blocks
     */
    public void setNumber(int numberOfMoves) {
    	int shift = 0;
    	while (numberOfMoves > 0) {
    		  int distance = numberOfMoves / 10;
    		  int unitOfNumber = numberOfMoves - distance * 10;
    		  numberOfMoves = distance;
    		  background.add(new Digit(unitOfNumber, 30, 500 - shift, 25));
    		  shift+=30;
    		}
    }
    
    
}
