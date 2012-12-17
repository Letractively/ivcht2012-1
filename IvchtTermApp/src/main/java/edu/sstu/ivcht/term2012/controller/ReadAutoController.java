package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.service.DatabaseService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;
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
 * Date: 11.12.12
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class ReadAutoController extends HttpServlet {

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
        req.setCharacterEncoding("UTF-8");
        DatabaseService.getPageData(getServletContext(), req);
        req.setAttribute("flag",req.getParameter("flag"));
        req.setAttribute("auto",  autoService.readAuto(parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/editpageauto.jsp").forward(req, resp);
    }
}
