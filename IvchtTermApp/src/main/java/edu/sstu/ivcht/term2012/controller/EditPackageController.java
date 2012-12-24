package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;
import model.Packag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 18.12.12
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class EditPackageController extends HttpServlet {

    AutoService packageService = ServiceInstancer.getAutoService();

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
        // Integer id_auto2=0;
        String id_auto= req.getParameter("id_auto");
        String id = req.getParameter("id");
        String motor = req.getParameter("motor");
        String transmission = req.getParameter("transmission");
        String drive = req.getParameter("drive");
        String price = req.getParameter("price");
        //String checked = req.getParameter("checked");
        Integer chk=0;
        Packag packag=null;



                    try {
                packag= new Packag(Integer.parseInt(id),Integer.parseInt(motor),transmission,drive,Double.parseDouble(price),chk);
                packageService.editPackage(packag);
                req.setAttribute("result_editpackag", "Комплектация изменена");

                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                    }
                    catch (Exception e) {
                        req.setAttribute("error", "Произошла ошибка при изменении");
                        getServletContext().getRequestDispatcher("/readpackag?id="+req.getParameter("id")).forward(req, resp);
                        e.printStackTrace();
                    }






    }
}
