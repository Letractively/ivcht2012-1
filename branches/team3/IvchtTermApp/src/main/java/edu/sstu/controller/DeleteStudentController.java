package edu.sstu.controller;

import edu.sstu.model.Student;
import edu.sstu.service.StudentService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 02.11.12
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */
public class DeleteStudentController extends HttpServlet {

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

        try{
            Integer id = Integer.parseInt(req.getParameter("id"));
            studentService.deleteStudent(id);
        }
        catch (Exception e){

        }
        List<Student> studentList = studentService.getAllStudents();
        req.setAttribute("students", studentList);
        getServletContext().getRequestDispatcher("/studentList.jsp").forward(req,resp);    }

}

