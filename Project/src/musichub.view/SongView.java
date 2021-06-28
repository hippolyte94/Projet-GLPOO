package view;

import musichub.business.AudioElement;
import musichub.business.MusicHub;
import musichub.business.Song;

import java.util.Iterator;
import java.util.Scanner;

public class SongView extends GeneralView {

    Scanner scan = new Scanner(System.in);
    //String choice = scan.nextLine();
    //MusicHub theHub = new MusicHub();

    public String[] getSongInformation(){
        String[] returnTab;
        System.out.println("Enter a new song: ");
        System.out.println("Song title: ");
        String title = scan.nextLine();
        System.out.println("Song genre (jazz, classic, hiphop, rock, pop, rap):");
        String genre = scan.nextLine();
        System.out.println("Song artist: ");
        String artist = scan.nextLine();
        System.out.println ("Song length in seconds: ");
        String length = scan.nextLine();
        System.out.println("Song content: ");
        String content = scan.nextLine();
        returnTab = new String[]{title, genre, artist, length, content};

        //theHub.addElement(s);
        //System.out.println("New element list: ");
        //Iterator<AudioElement> it = theHub.elements();
        //while (it.hasNext()) System.out.println(it.next().getTitle());

        if (title != null && genre != null && artist != null && length != null && content != null)
            return returnTab;
        return null;
    }

    @Override
    protected void tellIfAdded(boolean bool) {
        if (bool)
            System.out.println("Song created !");
        else
            System.out.println("Can't creat this song !");
    }
}