package org.example.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.Model.Album;
import org.example.Model.Artist;
import org.example.Model.Track;
import org.example.Accessor.SpotifyAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    public Artist getArtists(String artistId) throws Exception{
        SpotifyAccessor accessor3 = new SpotifyAccessor();
        String response3 = accessor3.get("/artists/" + artistId, Map.of());
        JsonObject jsonObject3 = new Gson().fromJson(response3, JsonObject.class);
        List<String> artists = new ArrayList<>();
        Artist artist = new Artist();
        artist.setId(jsonObject3.get("id").getAsString());
        artist.setName(jsonObject3.get("name").getAsString());
        artist.setPopularity(jsonObject3.get("popularity").getAsInt());
        artist.setType(jsonObject3.get("type").getAsString());
        return artist;
    }

    public List<Album> getAlbums(String artistId) throws Exception{
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + artistId + "/albums", Map.of());
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        List<Album> albums = new ArrayList<>();
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        for(JsonElement item:items){
            Album album = new Album();
            album.setId(item.getAsJsonObject().get("id").getAsString());
            album.setName(item.getAsJsonObject().get("name").getAsString());
            album.setAlbum_type(item.getAsJsonObject().get("album_type").getAsString());
            album.setRelease_date(item.getAsJsonObject().get("release_date").getAsString());
            album.setTotal_tracks(item.getAsJsonObject().get("total_tracks").getAsInt());
            albums.add(album);
        }
        return albums;
    }

    public List<Track> getTracks(String artistId) throws Exception {
        SpotifyAccessor accessor = new SpotifyAccessor();
        String response = accessor.get("/artists/" + artistId + "/albums", Map.of());
        JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
        List<String> albums = new ArrayList<>();
        JsonArray items = jsonObject.get("items").getAsJsonArray();
        for (JsonElement item : items) {
            albums.add(item.getAsJsonObject().get("id").getAsString());
        }

        List<Track> tracks = new ArrayList<>();
        for (String albumId : albums) {
            String response2 = accessor.get("/albums/" + albumId + "/tracks", Map.of());
            JsonObject jsonObject2 = new Gson().fromJson(response2, JsonObject.class);
            JsonArray items2 = jsonObject2.get("items").getAsJsonArray();
            for (JsonElement item : items2) {
                Track track = new Track();
                track.setId(item.getAsJsonObject().get("id").getAsString());
                track.setName(item.getAsJsonObject().get("name").getAsString());
                track.setDuration_ms(item.getAsJsonObject().get("duration_ms").getAsInt());
                //Track track = new Track(id, name, duration_ms);
                tracks.add(track);
            }
        }

        return tracks;
    }
}
