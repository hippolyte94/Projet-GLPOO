package view;

import java.util.Scanner;

public abstract class GeneralView {

    Scanner scan = new Scanner(System.in);
    String choice = scan.nextLine();

    protected void printHelp() {
        printAvailableCommands();
        choice = scan.nextLine();
    }

    public void printAvailableCommands() {
        System.out.println("t: display the album titles, ordered by date");
        System.out.println("g: display songs of an album, ordered by genre");
        System.out.println("d: display songs of an album");
        System.out.println("u: display audiobooks ordered by author");
        System.out.println("c: add a new song");
        System.out.println("a: add a new album");
        System.out.println("+: add a song to an album");
        System.out.println("l: add a new audiobook");
        System.out.println("p: create a new playlist from existing songs and audio books");
        System.out.println("-: delete an existing playlist");
        System.out.println("s: save elements, albums, playlists");
        System.out.println("q: quit program");
    }

    protected abstract void  tellIfAdded(boolean bool);

}