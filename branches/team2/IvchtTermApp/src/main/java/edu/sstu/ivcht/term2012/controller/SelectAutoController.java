package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 18.12.12
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class SelectAutoController extends HttpServlet {

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

        List<Auto> autoList =null;

            autoList =autoService.getAllAutos(Integer.parseInt(req.getParameter("id")),Integer.parseInt(req.getParameter("tps")),0);

        req.setAttribute("autos", autoList);
        if(autoList.size()==0){
            req.setAttribute("error", "Ничего не найдено");
            getServletContext().getRequestDispatcher("/pageselect.jsp").forward(req,resp);
           // req.setAttribute("autos", 0);
        }
        else{
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    }
}