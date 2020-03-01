package frogger.model;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * 
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public abstract class Actor extends ImageView{

	/**
	 * move defines frog's movement
	 * @param dx is the x-axis position of frog's move
	 * @param dy is the y-axis position of frog's move
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * getWorld defines the objects in the world.
     * @return the objects in the World
     */
    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * getWidth method is used to retrieve actor's width.
     * @return the width of actor object.
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * geetHeight method is used to retrieve actor's height.
     * @return the height of actor object.
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * @return return all the objects that intersect this object.
     *
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    public void manageInput(InputEvent e) {
        
    }

    public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
                break;
            }
        }
        return someArray.get(0);
    }

	public void act(long now) {
		// TODO Auto-generated method stub
		
	}

}
