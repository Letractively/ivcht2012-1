package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.service.DatabaseService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Packag;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 18.12.12
 * Time: 14:47
 * To change this template use File | Settings | File Templates.
 */
public class ReadPackageController extends HttpServlet {

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
        Packag pac=null;
        List listtransm=new LinkedList();
        listtransm.add("AT");
        listtransm.add("MT");
        List listprivod=new LinkedList();
        listprivod.add("Передний");
        listprivod.add("Задний");
        listprivod.add("Полный");
        req.setAttribute("listtransm",listtransm);
        req.setAttribute("listprivod",listprivod);
        DatabaseService.getPageData(getServletContext(), req);
        req.setAttribute("flag", req.getParameter("flag"));
        List arr=new LinkedList();
        req.setAttribute("packag",  autoService.readPackag(parseInt(req.getParameter("id"))));
        pac= (Packag) req.getAttribute("packag");
        req.setAttribute("auto", autoService.readAuto(pac.getId_auto()));
        arr.add(listprivod.get(0).hashCode());
        arr.add(listprivod.get(1).hashCode());
        arr.add(listprivod.get(2).hashCode());
        arr.add(pac.getDrive().hashCode());


        req.setAttribute("arr",arr);
        getServletContext().getRequestDispatcher("/pageeditpackage.jsp").forward(req, resp);
    }
}