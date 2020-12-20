package servlet;

import database.dao.AlbumDao;
import database.dao.ArtistDao;
import model.Album;
import model.Artist;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/album-search")
public class SearchAlbumServlet extends HttpServlet {
    private AlbumDao albumDao = new AlbumDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String albumName = req.getParameter("album");

        List<Album> allAlbums = albumDao.getAlbumByKeyword(albumName);

        req.setAttribute("allAlbums", allAlbums);

        // forward the request to the createArtist.jsp page
        req.getRequestDispatcher("/WEB-INF/findAlbum.jsp").forward(req, resp);
    }
}
