package frogger;

import java.util.ArrayList;

import frogger.model.Actor;
import frogger.model.End;
import frogger.model.Log;
import frogger.model.Obstacle;
import frogger.model.Turtle;
import frogger.model.WetTurtle;
import frogger.view.AnimalImage;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Animal class is used to control frog and objects' activities shown in the world.
 * @author scytl2, scytl2@nottingham.ac.uk
 * @version 10
 */
public class Animal extends Actor {
	
	AnimalImage animal_image = new AnimalImage();
	
	private int imgSize = 40; 
	private int points = 0;
	private int end = 0;
	private int carD = 0;
	private boolean second = false;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean noMove = false;
	boolean stop = false;
	boolean changeScore = false;
	double movement = 13.333333 * 2; // 13.3333333*2
	double movementX = 10.666666*2;
	double w = 800;
	
	ArrayList<End> inter = new ArrayList<End>();
	
	/**
	 * Animal constructor defines the original position of where frog locates
	 * As player presses key button W, S, A or D, then releases it
	 * Frog will move up, down, left or right direction towards End blocks, respectively.
	 * @param imageLink links to the saved frog's image and displays it on game screen
	 */
	public Animal(String imageLink) {

		setX(300);
		setY(679.8+movement);
	
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (event.getCode() == KeyCode.W) {	  
		                move(0, -movement);
		                changeScore = false;
		                setImage(animal_image.getImgW1());
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	            	
		            	 move(-movementX, 0);
		            	 setImage(animal_image.getImgA1());
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {	            	
		            	 move(0, movement);
		            	 setImage(animal_image.getImgS1());
		            	 second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	            	
		            	 move(movementX, 0);
		            	 setImage(animal_image.getImgD1());
		            	 second = false;
		            }
				}
				else if (event.getCode() == KeyCode.W) {	            	
	                move(0, -movement);
	                setImage(animal_image.getImgW2());
	                second = true;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(animal_image.getImgA2());
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(animal_image.getImgS2());
	            	 second = true;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(animal_image.getImgD2());
	            	 second = true;
	            }
			}
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {}
				else {
				if (event.getCode() == KeyCode.W) {	  
					if (getY() < w) {
						changeScore = true;
						w = getY();
						points+=10;
					}
	                move(0, -movement);
	                setImage(animal_image.getImgW1());
	                second = false;
	            }
	            else if (event.getCode() == KeyCode.A) {	            	
	            	 move(-movementX, 0);
	            	 setImage(animal_image.getImgA1());
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.S) {	            	
	            	 move(0, movement);
	            	 setImage(animal_image.getImgS1());
	            	 second = false;
	            }
	            else if (event.getCode() == KeyCode.D) {	            	
	            	 move(movementX, 0);
	            	 setImage(animal_image.getImgD1());
	            	 second = false;
	            }
	        }
			}
			
		});
	}
	
	@Override
	public void act(long now) {
		if (getY()<0 || getY()>734) {
			setX(300);
			setY(679.8+movement);
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			carDeath(now);
		}
		if (waterDeath) {
			waterDeath(now);
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			w=800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setX(300);
			setY(679.8+movement);
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	
	/**
	 * getStop means how many times frog enteres into End block
	 * Game will be finished
	 * @return end the game when the times frog enters End block
	 */
	public boolean getStop() {
		return end== 5;
	}
	
	/**
	 * getPoints determines how many points player scores during the game
	 * @return points which contain player's score.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * changeScore determines the score has been changed during the game or not
	 * Then it will automatically update the score via boolean changeScore
	 * @return true or false
	 */
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	
	/**
	 * carDeath explains when frog crashes the car and shows its consequence image
	 * 
	 * @param now means current time of encountering car death.
	 */
	public void carDeath(long now)
	{
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:src/frogger/view/cardeath1.png", imgSize, imgSize, true, true));
		}
		if (carD==2) {
			setImage(new Image("file:src/frogger/view/cardeath2.png", imgSize, imgSize, true, true));
		}
		if (carD==3) {
			setImage(new Image("file:src/frogger/view/cardeath3.png", imgSize, imgSize, true, true));
		}
		if (carD == 4) {
			setX(300);
			setY(679.8+movement);
			carDeath = false;
			carD = 0;
			setImage(new Image("file:src/frogger/view/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
		}
	}
	
	/**
	 * waterDeath defines when frog gets drawn in the water while crossing logs
	 * @param now means the current time of facing water death.
	 */
	public void waterDeath(long now)
	{
		noMove = true;
		if ((now)% 11 ==0) {
			carD++;
		}
		if (carD==1) {
			setImage(new Image("file:src/frogger/view/waterdeath1.png", imgSize,imgSize , true, true));
		}
		if (carD==2) {
			setImage(new Image("file:src/frogger/view/waterdeath2.png", imgSize,imgSize , true, true));
		}
		if (carD==3) {
			setImage(new Image("file:src/frogger/view/waterdeath3.png", imgSize,imgSize , true, true));
		}
		if (carD == 4) {
			setImage(new Image("file:src/frogger/view/waterdeath4.png", imgSize,imgSize , true, true));
		}
		if (carD == 5) {
			setX(300);
			setY(679.8+movement);
			waterDeath = false;
			carD = 0;
			setImage(new Image("file:src/frogger/view/froggerUp.png", imgSize, imgSize, true, true));
			noMove = false;
			if (points>50) {
				points-=50;
				changeScore = true;
			}
		}
	}
	

}
