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
import java.text.SimpleDateFormat;

public class AddGruppaController extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
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

       try {
           Gruppa gruppa = new Gruppa( "Gr1", "info Gr1");
           gruppaService.addGruppa(gruppa);

            req.setAttribute("result", "Студент успешно добавлен");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении студента");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/addGruppa.jsp").forward(req, resp);
    }
}
