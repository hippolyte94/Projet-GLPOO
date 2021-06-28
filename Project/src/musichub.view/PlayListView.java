package view;

import java.util.Iterator;
import java.util.Scanner;

import musichub.business.AudioElement;
import musichub.business.MusicHub;

public class PlayListView extends GeneralView{

	Scanner scan = new Scanner(System.in);
	String albumTitle = null;
	String choice = scan.nextLine();
	MusicHub theHub = new MusicHub();

	public void displayAvailableElements() {
		System.out.println("Available elements: ");
		Iterator<AudioElement> itael = theHub.elements();
		while (itael.hasNext()) {
			AudioElement ae = itael.next();
			System.out.println(ae.getTitle());
		}
	}

	public void isDeleted() {
		System.out.println("Playlist deleted!");
		printAvailableCommands();
		choice = scan.nextLine();
	}

	@Override
	protected void tellIfAdded(boolean bool) {
		// TODO Auto-generated method stub

	}
}
