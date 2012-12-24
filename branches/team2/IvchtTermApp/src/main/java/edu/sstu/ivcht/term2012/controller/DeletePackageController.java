package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 24.12.12
 * Time: 11:31
 * To change this template use File | Settings | File Templates.
 */
public class DeletePackageController  extends HttpServlet {

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
            autoService.deletePackag(parseInt(req.getParameter("id")));
            req.setAttribute("result_deletepackage", "Комплектация  удалена");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error_deletepackage", "Комплектация не удалена");
            getServletContext().getRequestDispatcher("/readpackag?id="+req.getParameter("id")).forward(req, resp);

        }

    }
}
