package controller;

import java.util.Scanner;

import musichub.business.MusicHub;
import view.AudioBookView;
import view.GeneralView;

public class MainController {

	private AlbumController albumCont;
	private AudioBookController audioBookCont;
	private PlayListController playListCont;
	private SongController songCont;
	private GeneralView generalView;
	private MusicHub theHub;

	public MainController() {
		this.theHub = new MusicHub();
		this.albumCont = new AlbumController(theHub);
		this.audioBookCont = new AudioBookController(theHub);
		this.playListCont = new PlayListController(theHub);
		this.songCont = new SongController(theHub); // rajouter music hub
	}

	public void launch() {
		System.out.println("Type h for available commands");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		while (choice.charAt(0) != 'q') {
			switch (choice.charAt(0)) {

				case 'h':
					generalView.printAvailableCommands();
					break;
				case 't':
					//album titles, ordered by date
					System.out.println(theHub.getAlbumsTitlesSortedByDate());
					generalView.printAvailableCommands();
					choice = scan.nextLine();
					break;
				case 'g':
					//songs of an album, sorted by genre
					albumCont.displayAlbumSongOrderedBygenre();
					break;



			}
		}
	}

}
