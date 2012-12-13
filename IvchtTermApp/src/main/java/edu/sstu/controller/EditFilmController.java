package edu.sstu.controller;

import edu.sstu.model.Film;
import edu.sstu.service.FilmService;
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
public class EditFilmController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
        req.setCharacterEncoding("UTF-8");
        Integer id =  Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String info = req.getParameter("info");
        String country = req.getParameter("country");
        Boolean d3 =  Boolean.parseBoolean(req.getParameter("d3"));
        String date = req.getParameter("date");
        String genreId = req.getParameter("genreId");

        try {
            Film film = new Film(id,
                    name,
                    info,
                    country,
                    d3,
                    sdf.parse(date),
                    Integer.parseInt(genreId)
            );
           filmService.editFilm(film);
            req.setAttribute("result", "Данные обновлены");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении фильма");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/editFilm.jsp").forward(req, resp);

    }
}