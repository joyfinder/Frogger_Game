package frogger;

import java.io.File;

import frogger.model.World;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * 
 * @author Ta-Liang Lu, scytl2@nottingham.ac.uk
 * @version 10
 */
public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}
	
	/**
	 * MyStage constructor
	 */
	public MyStage() {
		
	}
	
	/**
	 * playMusic is used to play Frogger background music
	 */
	public void playMusic() {
		String musicFile = "src/frogger/model/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**
	 * stopMusic method is used to stop background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

	public void add(Text text) {
		
		
		
	}

}
