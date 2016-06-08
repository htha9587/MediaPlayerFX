package application.media;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * Version 0.3
 * @author htha9587
 * 6-7-16
 */



public class MediaController implements Initializable
{
	@FXML private MediaView mv;
	 private MediaPlayer mp;
	 private Media me;
	 @FXML private Slider volumeSlider;
	 /**
	  * Initializes media player with video, can pick different one with Open button.
	  */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		String path = new File("src/mediaResource/Vid.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		volumeSlider.setValue(mp.getVolume() * 100);
		volumeSlider.valueProperty().addListener(new InvalidationListener()
		{
			
			/**
			 * Sets up volume slider.
			 */
			@Override
			public void invalidated(Observable observable)
			{
				mp.setVolume(volumeSlider.getValue() / 100);
				
			}
		});
}

	
	/**
	 * Plays the media.
	 * @param event
	 */
			
	public void play(ActionEvent event)
	{
		mp.play();
		mp.setRate(1);
	}
	
	/**
	 * Pauses the media
	 * @param event
	 */
	public void pause(ActionEvent event)
	{
		mp.pause();
	}
	/**
	 * Plays media twice as fast.
	 * @param event
	 */
	public void fast(ActionEvent event)
	{
		mp.setRate(2);
	}
	/**
	 * Plays media half as fast.
	 * @param event
	 */
	public void slow(ActionEvent event)
	{
		mp.setRate(.5);
	}
	/**
	 * Restarts the media.
	 * @param event
	 */
	public void reload(ActionEvent event)
	{
		mp.seek(mp.getStartTime());
		mp.play();
	}
	/**
	 * Starts the player.
	 * @param event
	 */
	public void start(ActionEvent event)
	{
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	/**
	 * Stops the player.
	 * @param event
	 */
	public void last(ActionEvent event)
	{
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
	/**
	 * FileChooser to open and play different forms of media.
	 * @param event
	 */
	public void file(ActionEvent event)
	{
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("*.flv", "*.mp4", "*.mpeg"));
		File file = fc.showOpenDialog(null);
		String path = file.getAbsolutePath();
		path = path.replace("\\", "/");
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		volumeSlider.setValue(mp.getVolume() * 100);
		volumeSlider.valueProperty().addListener(new InvalidationListener()
				{
					
					@Override
					public void invalidated(Observable observable)
					{
						mp.setVolume(volumeSlider.getValue() / 100);
						
					}
				});
	}
	
	
}

