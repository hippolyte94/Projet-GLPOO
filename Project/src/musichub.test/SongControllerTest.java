package musichub.test;

import static org.junit.jupiter.api.Assertions.*;

import musichub.controller.SongController;
import musichub.model.MusicHub;
import musichub.view.SongView;

class SongControllerTest {

	@org.junit.jupiter.api.Test
	void addNewSongTest() {
		MusicHub theHub = new MusicHub();
		SongController songCont = new SongController(theHub);
		String [] songValuesEqualsNull = {null};
		String [] songValuesCorrectFormat = {"test","test"};
		
		// On test ici le cas ou l'utilisateur n'a rien saisi
		assertFalse(songCont.addElementToHub(songValuesEqualsNull));
		assertTrue(songCont.addElementToHub(songValuesCorrectFormat));
	}

}
