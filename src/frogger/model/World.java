package frogger.model;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * 
 * @author scytl2, 20027098
 * @version 10
 */
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    /**
     * World constructor indicating the interaction of objects and frog in the world scene
     */
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {
						
						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**
     * Create a timer to count the time
     */
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }
    
    /**
     * start method is used as beginning the game
     */
    public void start() {
    	createTimer();
        timer.start();
    }
    
    /**
     * stop method is used to pause Frogger game.
     */
    public void stop() {
        timer.stop();
    }
    
    /**
     * add method is consistently used to add objects in the world.
     * @param actor means adding elements in Frogger's background, including turtle, obstacles and frog
     */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    /**
     * remove method is used to remove objects in the world.
     * @param actor indicates added elements including turtle, obstacles and frog in Frogger's background
     */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }
    
    /**
     * addButton method is used to add buttons
     * @param button generates number of buttons.
     */
    public void addButton(Button button) {
    	getChildren().add(button);
    	
    }
    
  
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
