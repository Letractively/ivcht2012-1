package edu.sstu.controller;

import edu.sstu.model.Genre;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class AddGenreController extends HttpServlet {
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

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");


        String name = req.getParameter("name");
        String info = req.getParameter("info");
        String text = req.getParameter("text");
       // String date1 = "01.02.2000";


        try {
            Genre gn = new Genre(
                    name,
                    info,
                    text
            );
            genreService.addGenre(gn);
            req.setAttribute("result", "Жанр успешно добавлен");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении фильма");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/addGenre.jsp").forward(req, resp);
    }
}
