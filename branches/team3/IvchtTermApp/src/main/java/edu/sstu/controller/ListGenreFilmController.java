package edu.sstu.controller;

import edu.sstu.model.Genre;
import edu.sstu.model.Film;
import edu.sstu.service.FilmService;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 12.11.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class ListGenreFilmController extends HttpServlet {

    FilmService filmService = ServiceInstancer.getFilmService();
    GenreService genreService = ServiceInstancer.getGenreService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<Film> filmList = filmService.getGenreFilms(id);
        req.setAttribute("films", filmList);
        List<Genre> genreList = genreService.getAllGenres();
        Integer count = filmList.size();

        HashMap genreMap = new HashMap<Integer, String>();
        for (Genre genre : genreList){
            genreMap.put(genre.getId(), genre.getName());
        }

        req.setAttribute("genres", genreList);
        req.setAttribute("genreMap", genreMap );
        req.setAttribute("count", count );
        getServletContext().getRequestDispatcher("/filmList.jsp").forward(req,resp);
    }

}
