package controller;

import java.util.Iterator;
import java.util.Scanner;

import musichub.business.MusicHub;
import musichub.business.NoElementFoundException;
import musichub.business.NoPlayListFoundException;
import musichub.business.PlayList;
import view.PlayListView;

public class PlayListController {

	private MusicHub theHub = new MusicHub();

	public PlayListController(MusicHub theHub) {
		this.theHub = theHub;
	}

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;
	String choice = scan.nextLine();
	PlayListView playListView = new PlayListView();

	public void createNewPlaylist() {
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
		PlayList pl = new PlayList(playListTitle);
		theHub.addPlaylist(pl);
		playListView.displayAvailableElements();
		while (choice.charAt(0)!= 'n') 	{
			System.out.println("Type the name of the audio element you wish to add or 'n' to exit:");
			String elementTitle = scan.nextLine();
			try {
				theHub.addElementToPlayList(elementTitle, playListTitle);
			} catch (NoPlayListFoundException ex) {
				System.out.println (ex.getMessage());
			} catch (NoElementFoundException ex) {
				System.out.println (ex.getMessage());
			}

			System.out.println("Type y to add a new one, n to end");
			choice = scan.nextLine();
		}
		System.out.println("Playlist created!");
		playListView.printAvailableCommands();
		choice = scan.nextLine();
	}

	public void deletePlaylist() {
		System.out.println("Delete an existing playlist. Available playlists:");
		Iterator<PlayList> itp = theHub.playlists();
		while (itp.hasNext()) {
			PlayList p = itp.next();
			System.out.println(p.getTitle());
		}
		String plTitle = scan.nextLine();
		try {
			theHub.deletePlayList(plTitle);
		}	catch (NoPlayListFoundException ex) {
			System.out.println (ex.getMessage());
		}
		playListView.isDeleted();
	}

}
