package org.example.Model;

public class Track {
    public String id;
    public String name;
    public int duration_ms;

    public Track() {
    }

    public Track(String id, String name, int duration_ms) {
        this.id = id;
        this.name = name;
        this.duration_ms = duration_ms;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration_ms() {
        return duration_ms;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration_ms(int duration_ms) {
        this.duration_ms = duration_ms;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", duration_ms=" + duration_ms +
                '}';
    }
}
