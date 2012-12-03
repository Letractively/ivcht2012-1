package edu.sstu.controller;

import edu.sstu.model.Student;
import edu.sstu.service.GruppaService;
import edu.sstu.utils.ServiceInstancer;
import edu.sstu.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class AddStudentController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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

//        String id = req.getParameter("id");
        String secondName = req.getParameter("secondName");
        String firstName = req.getParameter("firstName");
        String birthday = req.getParameter("birthday");
        String height = req.getParameter("height");
        Integer grId =  Integer.parseInt( req.getParameter("grId"));

     //  SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Student st = new Student(
                    firstName,
                    secondName,
                    sdf.parse(birthday),
                    Integer.parseInt(height),
                    grId
            );
            studentService.addStudent(st);
            req.setAttribute("result", "Студент успешно добавлен");
            gruppaService.getAllGrupps();
            req.setAttribute("result", "Студент успешно добавлен");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении студента");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/addStudent.jsp").forward(req, resp);
    }
}
