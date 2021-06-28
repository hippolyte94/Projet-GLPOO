package musichub.test;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import musichub.model.Album;
import musichub.model.AudioElement;
import musichub.model.MusicHub;
import musichub.model.NoPlayListFoundException;
import musichub.model.PlayList;

class MusicHubTest {

	MusicHub musichub = new MusicHub();
	MusicHub musicHubAfterDelete = new MusicHub();
	Album a = new Album("QUALF", "Damso", 1200, "17-07-2020");
	PlayList p = new PlayList("ZEN");
	PlayList p1 = new PlayList("");
	
	
	@Test
	void addElementTest() {
		assertFalse(musichub.addElement(null));
	}
	
	@Test
	void addAlbumTest() {
		assertFalse(musichub.addAlbum(null));
		assertTrue(musichub.addAlbum(a));
	}
	
	@Test
	void addPlaylistTest() {
		assertTrue(musichub.addPlaylist(p));
		assertFalse(musichub.addPlaylist(p1));
	}
	
	@Test
	void deletePlaylisTest() throws NoPlayListFoundException {
		musichub.addPlaylist(p);
		musicHubAfterDelete.addPlaylist(p);
		musicHubAfterDelete.deletePlayList("ZEN");
		
		// On supprime un element et on comprare la taille de la playlist de base et celle de la 
		// playlist avec un son enlev�.
		assertEquals(musichub.getPlaylists().size()-1, musicHubAfterDelete.getPlaylists().size());
	}
	


}
