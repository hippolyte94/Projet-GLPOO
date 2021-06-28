package controller;

import musichub.business.MusicHub;
import musichub.business.Song;
import view.SongView;

public class SongController  {

    private final MusicHub theHub;
    private final SongView songView;

    public SongController(MusicHub theHub) {
        this.theHub = theHub;
        songView = new SongView();
    }


    public void addNewSong(){
        String[] songValues = songView.getSongInformation();
        addElementToHub(songValues);
    }

    private void addElementToHub(String[] songValues) {
        theHub.addElement(new Song(songValues[0], songValues[1], Integer.parseInt(songValues[3]), songValues[2], songValues[4]));
    }
}