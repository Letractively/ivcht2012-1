package edu.sstu.controller;

import edu.sstu.model.Student;
import edu.sstu.service.StudentService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 12.11.12
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
public class ShowStudentController extends HttpServlet {

    StudentService studentService = ServiceInstancer.getStudentService();

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

        try {

            Integer id = Integer.parseInt(req.getParameter("id"));
            Student  student = studentService.showStudent(id);
            req.setAttribute("student", student);
            } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении студента");
            e.printStackTrace();
        }
       // Student student = studentService.showStudent(Integer id);
        //req.setAttribute("students", student);
        getServletContext().getRequestDispatcher("/editStudent.jsp").forward(req, resp);
    }

}
