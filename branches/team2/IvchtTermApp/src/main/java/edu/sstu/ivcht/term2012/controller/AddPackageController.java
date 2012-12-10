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
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 05.12.12
 * Time: 9:58
 * To change this template use File | Settings | File Templates.
 */
public class AddPackageController extends HttpServlet {

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
      //  String price = req.getParameter("price");
        String motor = req.getParameter("motor");
        String transmission = req.getParameter("transmission");
        String drive = req.getParameter("drive");
        String price = req.getParameter("price");
        String checked = req.getParameter("checked");
        Integer chk=0;
        Packag packag=null;

        try {
         if (checked=="on"){
            chk=1;
         }

            packag= new Packag(Integer.parseInt(id_auto),Integer.parseInt(motor),transmission,drive,Double.parseDouble(price),chk);
                packageService.addPackage(packag);
                req.setAttribute("result", "Комплектация добавлена");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении");
            e.printStackTrace();
        }
        AutoService autoService = ServiceInstancer.getAutoService();
        List<Auto> autoList = autoService.getAllAutos(0,0);     //получение списка авто для добавления к ним конкретной комплектации
        req.setAttribute("autos", autoList);
        getServletContext().getRequestDispatcher("/block/addPackag.jsp").forward(req, resp);
    }
}

