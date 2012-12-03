package edu.sstu.controller;

import edu.sstu.model.Student;
import edu.sstu.service.StudentService;
import edu.sstu.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 02.11.12
 * Time: 20:45
 * To change this template use File | Settings | File Templates.
 */
public class EditStudentController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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
        req.setCharacterEncoding("UTF-8");
        Integer id =  Integer.parseInt(req.getParameter("id"));
        String secondName = req.getParameter("secondName");
        String firstName = req.getParameter("firstName");
        String birthday = req.getParameter("birthday");
        String height = req.getParameter("height");
        String grId = req.getParameter("grId");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Student student = new Student(   id,
                    firstName,
                    secondName,
                    sdf.parse(birthday),
                    Integer.parseInt(height),
                    Integer.parseInt(grId)
            );
           studentService.editStudent(student);
            req.setAttribute("result", "Данные обновлены");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении студента");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/editStudent.jsp").forward(req, resp);

    }
}