package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.service.DatabaseService;
import model.Brand;
import edu.sstu.ivcht.term2012.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 13:22
 * To change this template use File | Settings | File Templates.
 */
public class ListBrandController extends HttpServlet {

    AutoService autoService = ServiceInstancer.getAutoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
       // List<Brand> autoList = autoService.getAllBrand();
       // req.setAttribute("brand", autoList);
        DatabaseService.getPageData(getServletContext(), req);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}