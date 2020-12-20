
package model;

public class Album {

    private long id;
    private String title;
    private String artistName;

    public Album(long id, String title, String artistName) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
    }

    public Album(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }
    public String getTitle() {
        return this.title;
    }
    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.title + " / " + this.id;
    }
}