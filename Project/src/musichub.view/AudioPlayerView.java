package musichub.view;

import musichub.model.MusicHub;
import musichub.model.Song;

import java.util.List;

public class AudioPlayerView extends GeneralView{

	public AudioPlayerView(MusicHub theHub) {
		super(theHub);
	}

	public void showAlbumList() {
		System.out.println(theHub.getAlbumsTitlesSortedByArtists());
		System.out.println("Choose an album by taping his title");
	}

	public void showSongList(List<Song> listSong){
		for (int i = 0; i< listSong.size(); i++) {
			System.out.println(i + " :: Titre : " + listSong.get(i).getTitle() + " Auteurs : "+listSong.get(i).getArtist());
		}
		if(listSong.size()> 0 )
			System.out.println("Choissisez votre musique a ecouté en tapant son numéro.");
	}

	public void showChoices() {
		System.out.println("1. pause");
		System.out.println("2. resume");
		System.out.println("3. restart");
		System.out.println("4. stop");
		System.out.println("5. Jump to specific time");

	}
}
