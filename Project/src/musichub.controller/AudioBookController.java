package musichub.controller;

import java.util.Scanner;

import musichub.model.AudioBook;
import musichub.model.MusicHub;
import musichub.view.AudioBookView;
import musichub.logger.*;
public class AudioBookController {
	
	private MusicHub theHub;

	public AudioBookController(MusicHub theHub) {
		this.theHub = theHub;
	}

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;

	AudioBookView audioBookView = new AudioBookView(theHub);
	
	public void addNewAudioBook() {
		 System.out.println("Enter a new audiobookLogging");
		 Logging.log("Creating new audiobook");
		 System.out.println("AudioBook title: ");
         String bTitle = scan.nextLine();
         Logging.log(bTitle);
         System.out.println("AudioBook category (youth, novel, theater, documentary, speech)");
         String bCategory = scan.nextLine();
		 Logging.log(bCategory);
		 System.out.println("AudioBook artist: ");
         String bArtist = scan.nextLine();
		 Logging.log(bArtist);
		 System.out.println ("AudioBook length in seconds: ");
         int bLength = Integer.parseInt(scan.nextLine());
		 Logging.log(bLength+"");
		 System.out.println("AudioBook content: ");
         String bContent = scan.nextLine();
		 Logging.log(bContent);
		 System.out.println("AudioBook language (french, english, italian, spanish, german)");
         String bLanguage = scan.nextLine();
		 Logging.log(bLanguage);
		AudioBook b = new AudioBook (bTitle, bArtist, bLength, bContent, bLanguage, bCategory);
         theHub.addElement(b);
	}
	
	public void displayAudioBookOrderedByGenre() {
		audioBookView.getAudiobooksTitlesSortedByAuthor();
	}
	
	
	
	
}
