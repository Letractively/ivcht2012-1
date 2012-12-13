package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Brand;
import model.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 13.12.12
 * Time: 13:12
 * To change this template use File | Settings | File Templates.
 */
public class DeleteAutoController extends HttpServlet {

    AutoService autoService = ServiceInstancer.getAutoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
        autoService.deleteAuto(parseInt(req.getParameter("id")));
            req.setAttribute("result_deleteauto", "Авто удалено");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error_deleteauto", "Авто не удалено");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        }

    }
}

