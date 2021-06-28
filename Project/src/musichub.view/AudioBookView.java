package musichub.view;

import musichub.model.AudioElement;
import musichub.model.MusicHub;

import java.util.Iterator;
import java.util.Scanner;



public class AudioBookView extends GeneralView{
	private MusicHub theHub;
	Scanner scan = new Scanner(System.in);
	String albumTitle = null;

	public AudioBookView(MusicHub theHub) {
		this.theHub = theHub;
	}

	String choice;
	public void getAudiobooksTitlesSortedByAuthor() {

		System.out.println(theHub.getAudiobooksTitlesSortedByAuthor());
		printAvailableCommands();
		choice = scan.nextLine();
	}

	public void getAudioBook() {
		System.out.println("Audiobook created! New element list: ");
		Iterator<AudioElement> itl = theHub.elements();
		while (itl.hasNext()) System.out.println(itl.next().getTitle());
		printAvailableCommands();
		choice = scan.nextLine();
	}

	@Override
	protected void tellIfAdded(boolean bool) {
		// TODO Auto-generated method stub

	}
}
