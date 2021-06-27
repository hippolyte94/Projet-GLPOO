package controller;

import java.util.Iterator;
import java.util.Scanner;

import musichub.business.Album;
import musichub.business.AudioElement;
import musichub.business.MusicHub;
import musichub.business.NoAlbumFoundException;
import musichub.business.NoElementFoundException;
import musichub.business.Song;
import view.AlbumView;


public class AlbumController{

	private MusicHub theHub;

	public AlbumController(MusicHub theHub) {
		this.theHub = theHub;
	}

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;
	String choice = scan.nextLine();
	AlbumView viewAlbum = new AlbumView();

	public void addNewAlbum() {
		System.out.println("Enter a new album: ");
		System.out.println("Album title: ");
		String aTitle = scan.nextLine();
		System.out.println("Album artist: ");
		String aArtist = scan.nextLine();
		System.out.println ("Album length in seconds: ");
		int aLength = Integer.parseInt(scan.nextLine());
		System.out.println("Album date as YYYY-DD-MM: ");
		String aDate = scan.nextLine();
		Album a = new Album(aTitle, aArtist, aLength, aDate);
		theHub.addAlbum(a);
		viewAlbum.showsAlbums();
	}

	public void addSongToAalbum() {
		//add a song to an album:
		System.out.println("Add an existing song to an existing album");
		System.out.println("Type the name of the song you wish to add. Available songs: ");
		Iterator<AudioElement> itae = theHub.elements();
		while (itae.hasNext()) {
			AudioElement ae = itae.next();
			if ( ae instanceof Song) System.out.println(ae.getTitle());
		}
		String songTitle = scan.nextLine();

		System.out.println("Type the name of the album you wish to enrich. Available albums: ");
		Iterator<Album> ait = theHub.albums();
		while (ait.hasNext()) {
			Album al = ait.next();
			System.out.println(al.getTitle());
		}
		String titleAlbum = scan.nextLine();
		try {
			theHub.addElementToAlbum(songTitle, titleAlbum);
		} catch (NoAlbumFoundException ex){
			System.out.println (ex.getMessage());
		} catch (NoElementFoundException ex){
			System.out.println (ex.getMessage());
		}
		viewAlbum.newSongToAlbumAdded();
	}

	public void displayAlbumSongOrderedBygenre() {
		viewAlbum.albumSongsOrderedByGenre();
	}


}
