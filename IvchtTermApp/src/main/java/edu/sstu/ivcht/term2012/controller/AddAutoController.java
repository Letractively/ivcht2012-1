package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;
import model.Brand;
import model.Packag;
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
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public class AddAutoController extends HttpServlet {

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
        // Integer id_auto2=0;
        String id_brand= req.getParameter("id_brand");
        //  String price = req.getParameter("price");
        String id_types = req.getParameter("id_types");
        String model = req.getParameter("model");
        String height = req.getParameter("height");
        String width = req.getParameter("width");
        String len = req.getParameter("len");
        String seat = req.getParameter("seat");
        String rating=req.getParameter("rating");
        String price=req.getParameter("price");
        String descr=req.getParameter("descr");



        try {
          Auto  auto= new Auto(parseInt(id_brand), parseInt(id_types),model, parseInt(height), parseInt(width), parseInt(len), parseInt(seat), parseInt(rating),descr,Double.parseDouble(price));
            autoService.addAuto(auto);
            req.setAttribute("result", "Авто добавлено");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при добавлении");
            e.printStackTrace();
        }
        List<Brand> autoList = autoService.getAllBrand();
        req.setAttribute("brand", autoList);
        List<Types> typeList = autoService.getAllTypes();     //получение списка авто для добавления к ним конкретной комплектации
        req.setAttribute("types", typeList);
        getServletContext().getRequestDispatcher("/block/addAuto.jsp").forward(req, resp);
    }
}

