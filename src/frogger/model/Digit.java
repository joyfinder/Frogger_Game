package frogger.model;

import javafx.scene.image.Image;

/**
 * 
 * @author scytl2, 20027098
 * @version 10
 * @since 17/11/2019
 */
public class Digit extends Actor{
	int dim;
	private Image image1;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Digit class constructor specifying 
	 * Digit represents the coordinated unit frog has been moving during the game.
	 * @param digitOfNumber means the digit number of frog's image being displayed in the world
	 * @param dimension indicates dimension of the image
	 * @param xCoordinate stores the x-coordinate position of score 
	 * @param yCoordinate stores the y-coordinate position of score 
	 */
	public Digit(int digitOfNumber, int dimension, int xCoordinate, int yCoordinate) {
		image1 = new Image("file:src/frogger/view/"+digitOfNumber+".png", dimension, dimension, true, true);
		setImage(image1);
		setX(xCoordinate);
		setY(yCoordinate);
	}
	
	
}
