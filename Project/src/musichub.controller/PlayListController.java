package musichub.controller;

import musichub.model.MusicHub;
import musichub.model.NoElementFoundException;
import musichub.model.NoPlayListFoundException;
import musichub.model.PlayList;
import musichub.view.PlayListView;
import musichub.logger.*;
import java.util.Iterator;
import java.util.Scanner;

public class PlayListController {
	
	private MusicHub theHub ;
	private PlayListView playListView;
	public PlayListController(MusicHub theHub) {
		this.theHub = theHub;
		playListView = new PlayListView(theHub);
	}
	
	Scanner scan = new Scanner(System.in);
	String albumTitle = null;

	public void createNewPlaylist() {
		Logging.log("Creating new PlayList");

		//create a new playlist from existing elements
		System.out.println("Add an existing song or audiobook to a new playlist");
		System.out.println("Existing playlists:");
		Iterator<PlayList> itpl = theHub.playlists();
		while (itpl.hasNext()) {
			PlayList pl = itpl.next();
			System.out.println(pl.getTitle());
		}
		System.out.println("Type the name of the playlist you wish to create:");
		String playListTitle = scan.nextLine();
		Logging.log(playListTitle);
		PlayList pl = new PlayList(playListTitle);
		theHub.addPlaylist(pl);
		playListView.displayAvailableElements();

		String choice = "y";
		while (choice.charAt(0)!= 'n') 	{
			System.out.println("Type the name of the audio element you wish to add or 'n' to exit:");
			String elementTitle = scan.nextLine();
			Logging.log(elementTitle);
            try {
                theHub.addElementToPlayList(elementTitle, playListTitle);
            } catch (NoPlayListFoundException | NoElementFoundException ex) {
                System.out.println (ex.getMessage());
            }

			System.out.println("Type y to add a new one, n to end");
			choice = scan.nextLine();
			Logging.log(choice);
		}
		System.out.println("Playlist created!");
		playListView.printAvailableCommands();

	}
	
	public void deletePlaylist() {
		Logging.log("Deleting Playlist");
		System.out.println("Delete an existing playlist. Available playlist :");
		Iterator<PlayList> itp = theHub.playlists();
		while (itp.hasNext()) {
			PlayList p = itp.next();
			System.out.println(p.getTitle());
		}
		String plTitle = scan.nextLine();
		Logging.log(plTitle);
		try {
			theHub.deletePlayList(plTitle);
		}	catch (NoPlayListFoundException ex) {
			System.out.println (ex.getMessage());
		}
		playListView.isDeleted();
	}
	
}
