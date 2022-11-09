package org.example.Model;

public class Album {
    public String id;
    public String name;
    public String album_type;
    public int total_tracks;
    public String release_date;

    public Album(String id, String name, String album_type, int total_tracks) {
        this.id = id;
        this.name = name;
        this.album_type = album_type;
        this.release_date = release_date;
        this.total_tracks = total_tracks;
    }

    public Album() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlbum_type() {
        return album_type;
    }

    public int getTotal_tracks() {
        return total_tracks;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlbum_type(String album_type) {
        this.album_type = album_type;
    }

    public void setTotal_tracks(int total_tracks) {
        this.total_tracks = total_tracks;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", album_type='" + album_type + '\'' +
                ", total_tracks=" + total_tracks +
                ", release_date='" + release_date + '\'' +
                '}';
    }
}
