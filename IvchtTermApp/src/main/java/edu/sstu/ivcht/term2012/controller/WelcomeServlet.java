package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.WelcomeService;
import edu.sstu.ivcht.term2012.service.WelcomeServiceBaseImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    private WelcomeService welcomeService = new WelcomeServiceBaseImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
//TODO тут нужно кое что сделатьть
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("welcomeMessage", welcomeService.getWelcomeMessage());
        getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}
