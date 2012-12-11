package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;
import model.Brand;
import model.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 11.12.12
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class ReadAutoController extends HttpServlet {

    AutoService autoService = ServiceInstancer.getAutoService();

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
        List<Brand> autoList = autoService.getAllBrand();
        req.setAttribute("brand", autoList);
        List<Types> typeList = autoService.getAllTypes();     //получение списка авто для добавления к ним конкретной комплектации
        req.setAttribute("types", typeList);
        req.setAttribute("auto",  autoService.readAuto(parseInt(req.getParameter("id"))));
        getServletContext().getRequestDispatcher("/block/editAuto.jsp").forward(req, resp);
    }
}
