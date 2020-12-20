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

@WebServlet("")
public class IndexServlet extends HttpServlet {
    private ArtistDao artistDao = new ArtistDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Artist> allArtists = artistDao.getAllArtists();


        req.setAttribute("allArtists", allArtists);

        req.getRequestDispatcher("/WEB-INF/findAlbum.jsp").forward(req, resp);
    }
}
