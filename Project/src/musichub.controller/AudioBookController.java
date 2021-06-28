package musichub.controller;

import java.util.Scanner;

import musichub.model.AudioBook;
import musichub.model.MusicHub;
import musichub.view.AudioBookView;

public class AudioBookController {
	
	private MusicHub theHub;
	
	public AudioBookController(MusicHub theHub) {
		this.theHub = theHub;
	}

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;
	String choice = scan.nextLine();
	AudioBookView audioBookView = new AudioBookView();
	
	public void addNewAudioBook() {
		 System.out.println("Enter a new audiobook: ");
         System.out.println("AudioBook title: ");
         String bTitle = scan.nextLine();
         System.out.println("AudioBook category (youth, novel, theater, documentary, speech)");
         String bCategory = scan.nextLine();
         System.out.println("AudioBook artist: ");
         String bArtist = scan.nextLine();
         System.out.println ("AudioBook length in seconds: ");
         int bLength = Integer.parseInt(scan.nextLine());
         System.out.println("AudioBook content: "); 
         String bContent = scan.nextLine();
         System.out.println("AudioBook language (french, english, italian, spanish, german)");
         String bLanguage = scan.nextLine();
         AudioBook b = new AudioBook (bTitle, bArtist, bLength, bContent, bLanguage, bCategory);
         theHub.addElement(b);
	}
	
	public void displayAudioBookOrderedByGenre() {
		audioBookView.getAudiobooksTitlesSortedByAuthor();
	}
	
	
	
	
}
