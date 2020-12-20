package servlet;

import database.dao.ArtistDao;
import model.Artist;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/artist-new")
public class CreateArtistServlet extends HttpServlet {
    ArtistDao artistDao = new ArtistDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/createArtist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artist = req.getParameter("artist");

        if (artist.isEmpty()) {
            doGet(req, resp);
            return;
        }

        Artist addedArtist = new Artist(0, artist);

        boolean artistAdded = artistDao.addArtist(addedArtist);

        if (artistAdded ) {
            resp.setStatus(200);
        } else {
            resp.setStatus(404);
        }

       req.setAttribute("addedArtist", addedArtist.getName());
       doGet(req, resp);

    }

}
