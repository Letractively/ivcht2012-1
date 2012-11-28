package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 27.11.12
 * Time: 17:07
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseController extends HttpServlet {

    DatabaseService databaseService = new DatabaseService();


    public DatabaseController() {
        createDatabase();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createDatabase();
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createDatabase();
        resp.sendRedirect("/index.jsp");
    }

    private void createDatabase(){
        try{
            databaseService.createDatabaseTables();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
