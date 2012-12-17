package edu.sstu.controller;

import edu.sstu.model.Film;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;
import edu.sstu.service.FilmService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class AddFilmController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
        String name = req.getParameter("name");
        String info = req.getParameter("info");
//        String d31 = (req.getParameter("d3"));
        Boolean d3 =  req.getParameter("d3")== null ? false : true;

        String country = req.getParameter("country");
        String date = req.getParameter("date");
        Integer genreId =  Integer.parseInt( req.getParameter("genreId"));


        try {
            Film fl = new Film(
                    name,
                    info,
                    country,
                    d3,
                    sdf.parse(date),
                    genreId
            );
            filmService.addFilm(fl);
            req.setAttribute("result", "Фильм успешно добавлен");
//            genreService.getAllGenres();
//            req.setAttribute("result", "Фильм успешно добавлен");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении фильма");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/addFilm.jsp").forward(req, resp);
    }
}
