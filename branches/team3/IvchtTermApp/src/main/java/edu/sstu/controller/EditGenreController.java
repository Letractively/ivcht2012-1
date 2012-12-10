package edu.sstu.controller;

import edu.sstu.model.Film;
import edu.sstu.model.Genre;
import edu.sstu.service.FilmService;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 02.11.12
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class EditGenreController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    GenreService genreService = ServiceInstancer.getGenreService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("UTF-8");
        Integer id =  Integer.parseInt(req.getParameter("id"));
        String genre = req.getParameter("genre");
        String info = req.getParameter("info");
        String date = req.getParameter("date");

        try {
            Genre gn = new Genre( id,
                    genre,
                    info,
                    sdf.parse(date)
            );
            genreService.editGenre(gn);
            req.setAttribute("result", "Данные обновлены");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении фильма");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/editGenre.jsp").forward(req, resp);

    }
}