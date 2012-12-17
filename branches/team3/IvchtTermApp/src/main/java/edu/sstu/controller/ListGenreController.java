package edu.sstu.controller;

import edu.sstu.model.Genre;
import edu.sstu.service.FilmService;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListGenreController extends HttpServlet{

    GenreService genreService = ServiceInstancer.getGenreService();
    FilmService filmService = ServiceInstancer.getFilmService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        List<Genre> genreList = genreService.getAllGenres();
        req.setAttribute("genres", genreList);
        getServletContext().getRequestDispatcher("/genreList.jsp").forward(req,resp);

    }
}
