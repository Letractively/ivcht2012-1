package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.*;

import model.Auto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static edu.sstu.ivcht.term2012.util.ServiceInstancer.*;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class ListAutoController extends HttpServlet {

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
              Integer id,tps;
        if  (req.getParameter("tps")==null){
            tps=0;
        }
        else
        {
            tps=Integer.parseInt(req.getParameter("tps"));
        }
               if (req.getParameter("id")==null){
                 id=0;
               }
        else
               {
                   id=Integer.parseInt(req.getParameter("id"));
               }
        List<Auto> autoList = autoService.getAllAutos(id,tps);
        req.setAttribute("autos", autoList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
