
package database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ChinookDatabase;
import model.Artist;

public class ArtistDao {
    private ChinookDatabase db = new ChinookDatabase();

    /**
     * Gets all artists from the database
     * @return returns list of artists
     */
    public List<Artist> getAllArtists() {
        PreparedStatement statement = null;
        ResultSet results;
        List<Artist> artists = new ArrayList<>();
        Connection conn = db.connect();
        try {

            statement = conn.prepareStatement("SELECT * FROM Artist");
            results = statement.executeQuery();

            while (results.next()) {
                String name = results.getString("Name");
                long id = results.getLong("ArtistId");
                artists.add(new Artist(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(null, statement, conn);
        }

        return artists;
    }

    /**
     * Deletes an artist from the databse
     * @param artistId id of the artist to be deleted
     * @return returns SQL update query
     */
    public boolean deleteArtist(long artistId) {
        PreparedStatement statement = null;
        Connection conn = db.connect();
        try {
            statement = conn.prepareStatement("DELETE FROM Artist WHERE ArtistId = ?");
            statement.setLong(1, artistId);

            return statement.executeUpdate() != 0;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        finally {
            db.close(null, statement, conn);
        }
    }

    /**
     * Adds a new artist to the database
     * @param newArtist artist to be added to the database
     * @return returns false
     */
    public boolean addArtist(Artist newArtist) {
        PreparedStatement statement = null;
        Connection conn = db.connect();

        try {
          statement = conn.prepareStatement("INSERT INTO Artist (Name) VALUES(?)");
          statement.setString(1, newArtist.getName());

            return statement.executeUpdate() != 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            db.close(null, statement, conn);
        }

        return false;
    }
}