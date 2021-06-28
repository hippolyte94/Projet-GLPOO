package musichub.controller;

import java.util.Scanner;

import musichub.model.MusicHub;
import musichub.view.AlbumView;
import musichub.view.AudioBookView;
import musichub.view.GeneralView;
import musichub.logger.*;

public class MainController {

	private AlbumController albumCont;
	private AudioBookController audioBookCont;
	private PlayListController playListCont;
	private SongController songCont;
	private GeneralView generalView;
	private MusicHub theHub;
	private Logging logger;
	private AudioPlayerController audioPlayerController;


	public MainController() {
		this.theHub = new MusicHub();
		this.albumCont = new AlbumController(theHub);
		this.audioBookCont = new AudioBookController(theHub);
		this.playListCont = new PlayListController(theHub);
		this.songCont = new SongController(theHub); // rajouter music hub
		this.audioPlayerController = new AudioPlayerController(theHub);
		this.generalView = new GeneralView(theHub) { @Override protected void tellIfAdded(boolean bool) {} };
		logger = new Logging();
	}

	public void launch() {
		System.out.println("Type h for available commands");
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine();

		while (choice.charAt(0) != 'q') {

			switch (choice.charAt(0)) {
			
			case 'h':
				Logging.log("Choose h Option");
				generalView.printAvailableCommands();
				break;
			case 't':
				// album titles, ordered by date
				Logging.log("Choose t Option");
				System.out.println(theHub.getAlbumsTitlesSortedByDate());
				generalView.printAvailableCommands();
				break;
			case 'g':
				// songs of an album, sorted by genre
				Logging.log("Choose g Option");
				albumCont.displayAlbumSongOrderedBygenre();
				break;
				case 'd':
				Logging.log("Choose d Option");
				albumCont.displayAllSong();
				break;
			case 'u':
				Logging.log("Choose u Option");
				audioBookCont.displayAudioBookOrderedByGenre();
				break;
			case 'b':
				Logging.log("Choose b Option");
				theHub.getAlbumsTitlesSortedByArtists();
				break;
			case  'r': // Play Music
				Logging.log("Choose r Option");
				audioPlayerController.chooseMusicToPlay();
				break;
			case 'c':
				Logging.log("Choose c Option");
				songCont.addNewSong();
				break;
			case 'a':
				Logging.log("Choose a Option");
				albumCont.addNewAlbum();
				break;
			case '+':
				Logging.log("Choose + Option");
				albumCont.addSongToAalbum();
				break;
			case 'l':
				Logging.log("Choose l Option");
				audioBookCont.addNewAudioBook();
				break;
			case 'p':
				Logging.log("Choose p Option");
				playListCont.createNewPlaylist();
				break;
			case '-':
				Logging.log("Choose - Option");

				playListCont.deletePlaylist();
				break;
			case 'x':
				Logging.log("Choose x Option");

				albumCont.deleteAlbum();
				break;

			case 's':
				Logging.log("Choose s Option");

				// generalView.save();
				break;
			default:
				break;
			}
			choice = scan.nextLine();
		}
		Logging.log("Choose q Option");
		Logging.log("Exit Program : Status 0");
		scan.close();
	}

}
