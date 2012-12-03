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

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 12.11.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class ListGrStudentController extends HttpServlet {

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

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<Student> studentList = studentService.getGrStudents(id);
        req.setAttribute("students", studentList);
        List<Gruppa> gruppaList = gruppaService.getAllGrupps();
        Integer count = studentList.size();

        HashMap groupMap = new HashMap<Integer, String>();
        for (Gruppa gruppa : gruppaList){
            groupMap.put(gruppa.getId(), gruppa.getnamegrupp());
        }

        req.setAttribute("grupps", gruppaList);
        req.setAttribute("groupMap", groupMap );
        req.setAttribute("count", count );
        getServletContext().getRequestDispatcher("/studentList.jsp").forward(req,resp);
    }

}
