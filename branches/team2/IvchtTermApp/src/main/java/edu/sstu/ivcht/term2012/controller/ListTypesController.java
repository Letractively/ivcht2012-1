package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import model.Brand;
import edu.sstu.ivcht.term2012.util.*;
import model.Types;

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
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class ListTypesController extends HttpServlet {

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
        List<Types> autoList = autoService.getAllTypes();
        req.setAttribute("types", autoList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}