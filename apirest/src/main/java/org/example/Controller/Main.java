package org.example.Controller;

import org.example.Model.Album;
import org.example.Model.Artist;
import org.example.Model.Track;
import org.example.Sqlite.SqliteMusicDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<String, String> artists = Map.of(
            "2Pac", "1ZwdS5xdxEREPySFridCfh", "The Notorius B.I.G", "5me0Irg2ANcsgc93uaYrpb", "Juice WRLD", "4MCBfE4596Uoi2O4DtmEMz",
            "Drake", "3TVXtAsR1Inumwj472S9r4", "F0Cent", "3q7HBObVc0L8jNeTe5Gofh"
    );

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        List<Artist> artists1 = new ArrayList<>();

        for(String artistId : artists.values()) {
            Artist artist = controller.getArtists(artistId);
            artists1.add(artist);
        }

        SqliteMusicDatabase sq = new SqliteMusicDatabase("/Users/adoojeda/Desktop/GCID/Primer semestre/DACD/entrega1/apirest/src/main/java/org/example/table.db");
        sq.init();

        for (Artist artist : artists1) {
            sq.insertArtists(artist);
        }

        for(String artistId : artists.values()) {
            List<Album> albums = controller.getAlbums(artistId);
            for (Album album : albums) {
                sq.insertAlbums(album);
            }
        }
        for(String artistId : artists.values()) {
            List<Track> tracks = controller.getTracks(artistId);
            System.out.println(tracks);
            for (Track track : tracks) {
                sq.insertTracks(track);
            }
        }

    }
}