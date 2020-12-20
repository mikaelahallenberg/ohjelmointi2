package servlet;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import model.Artist;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artists")
public class ArtistServlet extends HttpServlet {
    private ArtistDao artistDao = new ArtistDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Artist> allArtists = artistDao.getAllArtists();

         req.setAttribute("allArtists", allArtists);

        req.getRequestDispatcher("/WEB-INF/findAlbum.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        boolean success = artistDao.deleteArtist(id);

        List<Artist> allArtists = artistDao.getAllArtists();

        req.setAttribute("deleteResult", success);
        if (success) {
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }
    }

}
