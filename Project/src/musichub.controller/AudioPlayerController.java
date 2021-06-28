package musichub.controller;

import musichub.model.AudioPlayer;
import musichub.model.MusicHub;
import musichub.model.NoAlbumFoundException;
import musichub.model.Song;
import musichub.view.AlbumView;
import musichub.view.AudioPlayerView;
import musichub.logger.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AudioPlayerController {

	private MusicHub theHub;
	private AudioPlayerView audioPlayerView;
	private AlbumView albumView;
	private AudioPlayer audioPlayer;

	public Scanner sc = new Scanner(System.in);

	public AudioPlayerController(MusicHub theHub) {
		this.theHub = theHub;
		audioPlayerView = new AudioPlayerView(theHub);

	}

	public Song chooseMusicToPlay() {
		Song song = null;
		try {
			audioPlayerView.showAlbumList();
			List<Song> listSong = theHub.getAlbumSongsSortedByGenre(sc.nextLine());
			audioPlayerView.showSongList(listSong);
			int numMusic = Integer.parseInt(sc.nextLine());
			if (numMusic < listSong.size() && numMusic>= 0 ){
				song = listSong.get(numMusic);
			}else{
				System.out.println("Numéro de musique incorrecte");
				Logging.log("Choose a wrong music number");
			}

		} catch (NoAlbumFoundException e) {
			Logging.fatal(e.getMessage());
		}
		return song;
	}

	public void controlPlayer(){
		Song song = chooseMusicToPlay();
		audioPlayer.setAudioPath(System.getProperty("user.dir")+"\\Project\\files\\audios\\"+song.getUUID()+".wav");
		audioPlayerView.showChoices();
		String choice = sc.nextLine();
		while(choice.charAt(0) != '9'){
			try {
				switch (choice.charAt(0)) {
					case '1':
						audioPlayer.pause();
						break;
					case '2':
						audioPlayer.resumeAudio();
						break;
					case '3':
						audioPlayer.restart();
						break;
					case '4':
						audioPlayer.stop();
						break;
					case '5':
						System.out.println("Enter time (" + 0 +
								", " + audioPlayer.getClip().getMicrosecondLength() + ")");
						long c1 = sc.nextLong();
						audioPlayer.jump(c1);
						break;

				}
			} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			Logging.fatal(e.getMessage());
			}
		}

	}


}
