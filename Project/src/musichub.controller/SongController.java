package musichub.controller;

import musichub.model.MusicHub;
import musichub.model.Song;
import musichub.view.SongView;
import musichub.logger.*;

public class SongController  {

    private MusicHub theHub;
    private SongView songView;

    public SongController(MusicHub theHub ) {
        this.theHub = theHub;
        songView = new SongView();
    }


    public void addNewSong(){
        Logging.log("Adding new Song");
        String[] songValues = songView.getSongInformation();
        for (int i = 0; i < songValues.length; i++) {
            Logging.log(songValues[i]);
        }
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