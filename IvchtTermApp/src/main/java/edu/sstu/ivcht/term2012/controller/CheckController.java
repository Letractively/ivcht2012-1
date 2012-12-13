package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 13.12.12
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
public class CheckController extends HttpServlet {
    AutoService userService = ServiceInstancer.getAutoService();

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
        String user_name=req.getParameter("user");
        String user_pass=req.getParameter("pass");

        if("what".equals(req.getParameter("what")))  {
        getServletContext().getRequestDispatcher("/editauto?id="+req.getParameter("id")).forward(req, resp);
        }
    }

}
