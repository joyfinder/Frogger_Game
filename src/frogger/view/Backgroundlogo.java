package frogger.view;

import frogger.model.Actor;
import javafx.scene.image.Image;

/**
 * Backgroundlogo class is used to determine the size of Frogger logo in the background
 * @author scytl2
 *
 */
public class Backgroundlogo extends Actor {
	
	/**
	 * Backgroundlogo constructor passes imageLink parameter.
	 * It initialises the setup of logo image size and scale.
	 * @param imageLink shows the source of image photo with fixed size.
	 */
	public Backgroundlogo(String imageLink)
	{
		setImage(new Image(imageLink, 200, 150, true, true));
	}

	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
}
