package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.AutoService;
import edu.sstu.ivcht.term2012.util.ServiceInstancer;
import model.Auto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 18.12.12
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
public class SelectAutoController extends HttpServlet {

    AutoService autoService = ServiceInstancer.getAutoService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
                            try{
        List<Auto> autoList =null;
        String str="where Auto.id>0 ";
             if(req.getParameter("ch1")!=null && req.getParameter("ch1").hashCode()=="on".hashCode()){
             str=str+" and Auto.id_brand="+Integer.parseInt(req.getParameter("id"));
        }

        if(req.getParameter("ch2")!=null && req.getParameter("ch2").hashCode()=="on".hashCode()){
            str=str+" and Auto.id_types="+Integer.parseInt(req.getParameter("tps"));
        }

        if(req.getParameter("ch3")!=null && req.getParameter("ch3").hashCode()=="on".hashCode()){
            str=str+" and package.price>"+Double.parseDouble(req.getParameter("price1"));
        }
        if(req.getParameter("ch4")!=null && req.getParameter("ch4").hashCode()=="on".hashCode()){
            str=str+" and package.price<"+Double.parseDouble(req.getParameter("price2"));
        }
        autoList=autoService.getSelectAutos(str);
           // autoList =autoService.getAllAutos(Integer.parseInt(req.getParameter("id")),Integer.parseInt(req.getParameter("tps")),0);

        req.setAttribute("autos", autoList);
        if(autoList.size()==0){
            req.setAttribute("error", "Ничего не найдено");
            getServletContext().getRequestDispatcher("/pageselect.jsp").forward(req,resp);
           // req.setAttribute("autos", 0);
        }
        else{
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
                            }
                            catch (Exception e){
                                req.setAttribute("error", "1");
                                getServletContext().getRequestDispatcher("/pageselect.jsp").forward(req,resp);
                            }
    }
}
