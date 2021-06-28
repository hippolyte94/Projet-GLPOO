package musichub.model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import musichub.logger.*;
import musichub.main.main.Main;

public class AudioPlayer {

	Long timeLine;
	Clip clip;
	String status;
	AudioInputStream audioIS;
	private String filePath;

	public AudioPlayer() {
	}


	public void setAudioPath(String filepath){
		this.filePath = filepath;
		loadAudio();
	}

	public void loadAudio(){
		try{
			File file = new File(filePath);
			audioIS = AudioSystem.getAudioInputStream(file.getAbsoluteFile());

			clip = AudioSystem.getClip();

			clip.open(audioIS);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		}catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex){
			Logging.fatal(ex.getMessage());
		}
	}

	public void play(){
		clip.start();
		status = "play";
	}

	public void pause()
	{
		if (status.equals("paused"))
		{
			System.out.println("L'audio est deja en pause");

		}else {
			this.timeLine =
					this.clip.getMicrosecondPosition();
			clip.stop();
			status = "paused";
		}
	}

	public void restart() throws IOException, LineUnavailableException,UnsupportedAudioFileException
	{
		clip.stop();
		clip.close();
		resetAudioStream();
		timeLine = 0L;
		clip.setMicrosecondPosition(0);
		this.play();
	}

	public void resumeAudio() throws UnsupportedAudioFileException,IOException, LineUnavailableException
	{
		if (status.equals("play"))
		{
			System.out.println("Audio is already "+
					"being played");
			return;
		}
		clip.close();
		resetAudioStream();
		clip.setMicrosecondPosition(timeLine);
		this.play();
	}

	public void stop()
	{
		timeLine = 0L;
		clip.stop();
		clip.close();
	}

	public void jump(long c) throws UnsupportedAudioFileException, IOException,LineUnavailableException
	{
		if (c > 0 && c < clip.getMicrosecondLength())
		{
			clip.stop();
			clip.close();
			resetAudioStream();
			timeLine = c;
			clip.setMicrosecondPosition(c);
			this.play();
		}
	}

	public void resetAudioStream() throws UnsupportedAudioFileException, IOException,LineUnavailableException
	{
		audioIS = AudioSystem.getAudioInputStream(
				new File(filePath).getAbsoluteFile());
		clip.open(audioIS);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public Clip getClip() {
		return clip;
	}
}
