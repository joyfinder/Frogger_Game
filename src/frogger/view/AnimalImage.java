package frogger.view;

import javafx.scene.image.Image;

/**
 * AnimalImage class is used to display the image of frog's movement.
 * Initialising imgSize to be 40.
 * @author scytl2
 * @version 10
 */
public class AnimalImage {
	
	private int imgSize = 40;
	private Image imgW1 = setImgW1(new Image("file:src/frogger/view/froggerUp.png", imgSize, imgSize, true, true));
	private Image imgA1 = setImgA1(new Image("file:src/frogger/view/froggerLeft.png", imgSize, imgSize, true, true));
	private Image imgS1 = setImgS1(new Image("file:src/frogger/view/froggerDown.png", imgSize, imgSize, true, true));
	private Image imgD1 = setImgD1(new Image("file:src/frogger/view/froggerRight.png", imgSize, imgSize, true, true));
	private Image imgW2 = setImgW2(new Image("file:src/frogger/view/froggerUpJump.png", imgSize, imgSize, true, true));
	private Image imgA2 = setImgA2(new Image("file:src/frogger/view/froggerLeftJump.png", imgSize, imgSize, true, true));
	private Image imgS2 = setImgS2(new Image("file:src/frogger/view/froggerDownJump.png", imgSize, imgSize, true, true));
	private Image imgD2 = setImgD2(new Image("file:src/frogger/view/froggerRightJump.png", imgSize, imgSize, true, true));
	private Image imgPauseGame = setImgPauseGame(new Image("file:src/frogger/view/iKogsKW.png", imgSize + 560, imgSize + 760, true, true));

	/**
	 * AnimalImage constructor
	 */
	public AnimalImage() {
		
		
	}
	
	/**
	 * getImgW1 method is used to retrieve the image of frog moving upward
	 * @return imgW1 means the image of frog moving upward.
	 */
	public Image getImgW1() {
		return imgW1;
	}
	
	/**
	 * setImgW1 method is used to pass imgW1 by Image standard class
	 * @param imgW1 means the image of frog moving upward.
	 * @return imgW1 is frog moving upward.
	 */
	public Image setImgW1(Image imgW1) {
		return this.imgW1 = imgW1;
	}

	/**
	 * getImgA1 method retrieves frog moving left.
	 * @return imagA1 is frog moving left-hand side.
	 */
	public Image getImgA1() {
		return imgA1;
	}
	
	/**
	 * setImgA1 method is used to pass imgA1 by Image standard library.
	 * @param imgA1 means the image of showing frog moving left hand side.
	 * @return imgA1 is frog moving left hand side.
	 */
	public Image setImgA1(Image imgA1) {
		return this.imgA1 = imgA1;
	}

	/**
	 * getImgS1 method retrieves frog moving down.
	 * @return imgS1 is frog moving south.
	 */
	public Image getImgS1() {
		return imgS1;
	}
	
	/**
	 * setImgS1 method is used to pass imgA1 by Image standard library.
	 * @param imgS1 means the image of frog moving south.
	 * @return imgS1 is frog moving south.
	 */
	public Image setImgS1(Image imgS1) {
		return this.imgS1 = imgS1;
	}

	/**
	 * getImgD1 method retrieves frog moving right.
	 * @return imgD1 is frog moving right hand side.
	 */
	public Image getImgD1() {
		return imgD1;
	}
	
	/**
	 * setImgD1 method is used to pass imgA1 by Image standard library.
	 * @param imgD1 means the image of frog moving right hand side.
	 * @return imgD1 is frog moving right hand side.
	 */
	public Image setImgD1(Image imgD1) {
		return this.imgD1 = imgD1;
	}
	
	/**
	 * getImgW2 method retrieves frog's jumping movement.
	 * @return imgW2 means the image of frog jumping up movement.
	 */
	public Image getImgW2() {
		return imgW2;
	}

	/**
	 * getImgW2 method is used to pass imgW2 by Image standard library.
	 * @param imgW2 means the image of frog jumping up movement.
	 * @return imgW2 is frog jumping up.
	 */
	public Image setImgW2(Image imgW2) {
		return this.imgW2 = imgW2;
	}
	
	/**
	 * getImgA2 method retrieves the image of frog jumping left hand side. 
	 * @return imgA2 frog jumping left.
	 */
	public Image getImgA2() {
		return imgA2;
	}

	/**
	 * setImgA2 method is used to pass imgA2 by Image standard library.
	 * @param imgA2 means the image of frog jumping left.
	 * @return imgA2 frog jumping left.
	 */
	public Image setImgA2(Image imgA2) {
		return this.imgA2 = imgA2;
	}
	
	/**
	 * getImgS2 method obtains frog jumping downwards.
	 * @return imgS2 frog jumping south.
	 */
	public Image getImgS2() {
		return imgS2;
	}
	
	/**
	 * setImgS2 method is used to pass imgS2 by Image standard library.
	 * @param imgS2 is the image of frog jumping south.
	 * @return imgS2 frog jumping south.
	 */
	public Image setImgS2(Image imgS2) {
		return this.imgS2 = imgS2;
	}
	
	/**
	 * getImgD2 method obtains frog moving right hand side.
	 * @return imgD2 frog jumping right.
	 */
	public Image getImgD2() {
		return imgD2;
	}
	
	/**
	 * setImgD2 method is used to pass imgD2 by Image standard library.
	 * @param imgD2 means the image of frog jumping right.
	 * @return imgD2 frog jumping right.
	 */
	public Image setImgD2(Image imgD2) {
		return this.imgD2 = imgD2;
	}
	
	/**
	 * getImgPauseGame method shows the background image of ending the game.
	 * @return impPauseGame frog pauses and stands at End block.
	 */
	public Image getImgPauseGame() {
		return imgPauseGame;
	}
	
	/**
	 * setImgPauseGame method is used to passing imgPauseGame by Image standard library.
	 * @param imgPauseGame means the image of frog standing at End Block.
	 * @return imgPauseGame frog pausing at end block.
	 */
	public Image setImgPauseGame(Image imgPauseGame) {
		return this.imgPauseGame = imgPauseGame;
	}
}