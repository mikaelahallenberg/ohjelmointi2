package database.dao;

import database.ChinookDatabase;
import model.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {
    private ChinookDatabase db = new ChinookDatabase();

    /**
     * Gets albums by keyword
     * @param keyword keyword as string
     * @return albums as list, which match any part of the keyword
     */
    public List<Album> getAlbumByKeyword(String keyword) {
        PreparedStatement statement = null;
        ResultSet results;
        List<Album> albums = new ArrayList<>();
        Connection conn = db.connect();

        try {
            statement = conn.prepareStatement("SELECT * FROM Album JOIN Artist ON Artist.ArtistId = Album.ArtistId WHERE Title LIKE ? ORDER BY Title");
            statement.setString(1, "%" + keyword + "%");
            results = statement.executeQuery();

            while (results.next()) {
                String title = results.getString("Title");
                long id = results.getLong("AlbumId");

                String name = results.getString("Name");


                albums.add(new Album(id, title, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close(null, statement, conn);
        }

        return albums;
    }

}
