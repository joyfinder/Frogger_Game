package frogger.model;

import javafx.scene.image.Image;

/**
 * Obstacle class contains controlling the speed of obstacle objects
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public class Obstacle extends Actor {
	private int speed;

	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	/**
	 * Obstacle constructor is used to set up obstacles shown in the world
	 * @param imageLink is used as linking the images of obstacles
	 * @param xPosition explains obstacles' x coordinates
	 * @param yPosition means obstacles' y coordinates
	 * @param Speed represents the speed of obstacle moving during Frogger game
	 * @param width defines the width of obstacle
	 * @param height determines the height of obstacle
	 */
	public Obstacle(String imageLink, int xPosition, int yPosition, int Speed, int width, int height) {
		
		setImage(new Image(imageLink, width,height, true, true));
		setX(xPosition);
		setY(yPosition);
		speed = Speed;
	}

}
