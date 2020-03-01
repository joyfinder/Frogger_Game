package frogger.model;

import javafx.scene.image.Image;

/**
 * 
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	/**
	 * Log constructor is used to define its location shown in the world
	 * @param imageLink means the source of log image.
	 * @param size indicates the size of log shown in the world.
	 * @param xpos means the x-cooridnate of log.
	 * @param ypos means the ey-cooridnate of log.
	 * @param flowSpeed means the flow speed of log.
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double flowSpeed) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = flowSpeed;
		
	}
	
	/**
	 * getLeft means Log would disappear in the world.
	 * @return speed less than 0
	 */
	public boolean getLeft() {
		return speed < 0;
	}
}
