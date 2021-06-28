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
		audioPlayer = new AudioPlayer();
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
		//jetbrains://idea/navigate/reference?project=Projet-GLPOO&path=Project/files/audios/44136020-dc80-4522-9b71-2b9aad5e3039.wav
		audioPlayer.setAudioPath(System.getProperty("user.dir")+"\\Project\\files\\audios\\"+song.getUUID()+".wav");
		audioPlayer.play();
		audioPlayerView.showChoices();
		String choice = sc.nextLine();
		while(choice.charAt(0) != 'q'){
			switch (choice.charAt(0)) {
				case '1':
					System.out.println("Not Implemented Yet");
					break;
				case '2':
					System.out.println("Not Implemented Yet");
					break;
				case '3':
					System.out.println("Not Implemented Yet");
					break;
				case '4':
					audioPlayer.stop();
					break;
				case '5':
					System.out.println("Not Implemented Yet");
					break;
				default:
					audioPlayer.stop();
					break;

			}
			audioPlayerView.showChoices();
			choice = sc.nextLine();

		}
		audioPlayerView.printAvailableCommands();
	}


}
