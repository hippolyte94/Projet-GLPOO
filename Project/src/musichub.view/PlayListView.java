package musichub.view;

import musichub.model.AudioElement;
import musichub.model.MusicHub;

import java.util.Iterator;
import java.util.Scanner;



public class PlayListView extends GeneralView{
	private MusicHub theHub;
	Scanner scan = new Scanner(System.in);
	String albumTitle = null;

	public PlayListView(MusicHub theHub) {
		this.theHub = theHub;
	}

	public void displayAvailableElements() {
		System.out.println("Available elements: ");
		Iterator<AudioElement> itael = theHub.elements();
		while (itael.hasNext()) {
			AudioElement ae = itael.next();
			System.out.println(ae.getTitle());
		}
	}

	public void isDeleted() {
		String choice = scan.nextLine();
		System.out.println("Playlist deleted!");
		printAvailableCommands();
		choice = scan.nextLine();
	}

	@Override
	protected void tellIfAdded(boolean bool) {
		// TODO Auto-generated method stub

	}
}
