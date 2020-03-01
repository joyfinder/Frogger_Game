package frogger.model;

import javafx.scene.image.Image;

/**
 * 
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public class End extends Actor{
	
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method st
	}
	
	/**
	 * 
	 * @param x represents x-axis of End image
	 * @param y means y-axis of End image
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/frogger/view/End.png", 60, 60, true, true));
	}
	
	/**
	 * setEnd is to set up end blocks' position.
	 */
	public void setEnd() {
		setImage(new Image("file:src/frogger/view/frogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	
	/**
	 * isActivated is used to launch end block function
	 * @return activated
	 */
	public boolean isActivated() {
		return activated;
	}
	

}
