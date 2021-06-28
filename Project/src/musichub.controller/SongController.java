package musichub.controller;

import musichub.model.MusicHub;
import musichub.model.Song;
import musichub.view.SongView;

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

    public boolean addElementToHub(String[] songValues) {
       if (songValues!= null) {
    	   theHub.addElement(new Song(songValues[0], songValues[1], Integer.parseInt(songValues[3]), songValues[2], songValues[4]));
    	   return true;
       }
       return false;
       
    }
}