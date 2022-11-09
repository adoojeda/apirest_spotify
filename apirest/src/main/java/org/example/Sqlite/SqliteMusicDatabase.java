package org.example.Sqlite;

import org.example.Model.Album;
import org.example.Model.Artist;
import org.example.Model.Track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteMusicDatabase {
    Connection conn = null;

    public SqliteMusicDatabase(String dbPath) throws SQLException {
        String url = "jdbc:sqlite:" + dbPath;
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
    }

    public Statement init() throws SQLException {
        Statement statement = conn.createStatement();
        createTable(statement);
        return statement;
    }

    public void insertArtists(Artist artist) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DmlTranslate.insertArtist(artist));
    }

    public void insertAlbums(Album album) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DmlTranslate.insertAlbum(album));
    }

    public void insertTracks(Track track) throws  SQLException{
        Statement statement = conn.createStatement();
        statement.execute(DmlTranslate.insertTrack(track));
    }

    private void createTable(Statement statement) throws SQLException {
        statement.execute("CREATE TABLE IF NOT EXISTS artists (" +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "popularity NUMBER," +
                "type TEXT" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS albums (" +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "album_type TEXT," +
                "release_date TEXT," +
                "total_tracks NUMBER" +
                ");");
        statement.execute("CREATE TABLE IF NOT EXISTS tracks (" +
                "name TEXT," +
                "id TEXT PRIMARY KEY," +
                "duration_ms NUMBER" +
                ");");
    }
}
