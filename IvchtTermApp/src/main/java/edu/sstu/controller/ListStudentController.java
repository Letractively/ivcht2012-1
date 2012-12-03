package edu.sstu.controller;

import edu.sstu.model.Gruppa;
import edu.sstu.model.Student;
import edu.sstu.service.GruppaService;
import edu.sstu.service.StudentService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ListStudentController extends HttpServlet{

    StudentService studentService = ServiceInstancer.getStudentService();
    GruppaService gruppaService = ServiceInstancer.getGruppaService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        List<Student> studentList = studentService.getAllStudents();
        req.setAttribute("students", studentList);
        List<Gruppa> gruppaList = gruppaService.getAllGrupps();

        HashMap groupMap = new HashMap<Integer, String>();
        for (Gruppa gruppa : gruppaList){
            groupMap.put(gruppa.getId(), gruppa.getnamegrupp());
        }

        req.setAttribute("grupps", gruppaList);
        req.setAttribute("groupMap", groupMap );

        getServletContext().getRequestDispatcher("/studentList.jsp").forward(req,resp);

    }
}
