package edu.sstu.controller;


import edu.sstu.service.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DatabaseController extends HttpServlet{

    DatabaseService databaseService = new DatabaseService();


    public DatabaseController() {
        createDatabase();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createDatabase();
        getServletContext().getRequestDispatcher("/studentList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        createDatabase();
        getServletContext().getRequestDispatcher("/studentList.jsp").forward(req,resp);
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
