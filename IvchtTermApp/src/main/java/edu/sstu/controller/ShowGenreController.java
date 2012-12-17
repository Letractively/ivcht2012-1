package edu.sstu.controller;

import edu.sstu.model.Genre;
import edu.sstu.service.GenreService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 12.11.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class ShowGenreController extends HttpServlet {

    GenreService genreService=ServiceInstancer.getGenreService();
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

        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Genre genre = genreService.showGenre(id);
            req.setAttribute("genre", genre);


            } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при редактировании жанра");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/showGenre.jsp").forward(req, resp);
    }

}
