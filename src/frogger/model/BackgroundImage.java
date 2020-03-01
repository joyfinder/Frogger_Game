package frogger.model;

import javafx.scene.image.Image;

/**
 * 
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public class BackgroundImage extends Actor {
	
	@Override
	public void act(long now) {
			
	}
	
	/**
	 * BackgroundImage constructor is used to set up the size of background image.
	 * @param imageLink means the source of image containing fixed alignment.
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 780, 800, true, true));
	}

}
