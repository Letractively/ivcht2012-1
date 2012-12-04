package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.service.DatabaseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Контроллер-сервлет, создающий базу данных и таблицы в ней
 */
public class DatabaseCreationController extends HttpServlet {

    /**
     * Экземпляр класса обслуживания базы данных
     */
    DatabaseService _databaseService = new DatabaseService();

    /**
     * Метод, непосредственно выполняющий создание БД и таблиц
     */
    private void createDatabase(){
        try{
            _databaseService.createDatabaseTables();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Конструктор, вызывающие метод создания БД и таблиц
     */
    public DatabaseCreationController() {
        //Создание БД и таблиц
        createDatabase();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Создание БД и таблиц
        createDatabase();
        getServletContext().getRequestDispatcher("/topicList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Создание БД и таблиц
        createDatabase();
        getServletContext().getRequestDispatcher("/topicList.jsp").forward(req,resp);
    }
}
