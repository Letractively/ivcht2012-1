package edu.sstu.controller;

import edu.sstu.model.Gruppa;
import edu.sstu.service.GruppaService;
import edu.sstu.service.StudentService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListGruppaController extends HttpServlet{

    GruppaService gruppaService = ServiceInstancer.getGruppaService();
    StudentService studentService = ServiceInstancer.getStudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        Integer i = Integer.parseInt(req.getParameter("i"));

        List<Gruppa> gruppaList = gruppaService.getAllGrupps();
        req.setAttribute("grupps", gruppaList);
        if (i==1) {
        getServletContext().getRequestDispatcher("/addStudent.jsp").forward(req,resp);
        }
       if (i==2) {

            getServletContext().getRequestDispatcher("/gruppaList.jsp").forward(req,resp);
        }
    }
}
