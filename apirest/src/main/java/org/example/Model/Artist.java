package org.example.Model;

public class Artist {
    public String id;
    public String name;
    public int popularity;
    public String type;

    public Artist(String id, String name, int popularity, String type) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.type = type;
    }

    public Artist() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public void setType(String type) {
        this.type = type;
    }
}
