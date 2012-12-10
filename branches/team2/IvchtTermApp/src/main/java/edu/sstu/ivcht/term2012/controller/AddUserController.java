package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;
import model.Usr;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 10.12.12
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class AddUserController extends HttpServlet {
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

        try {
        int prava=Integer.parseInt(req.getParameter("kontrol"));
        Usr user=new Usr(0,user_name,user_pass,prava);
        userService.addUser(user);
        List<Usr> userList = userService.getAllUser();
        req.setAttribute("result", "Пользователь добавлен");
        req.setAttribute("users", userList);


    }
        catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении");
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/block/adduser.jsp").forward(req, resp);

}
}
