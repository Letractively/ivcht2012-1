package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.dao.ConnectionDBDao;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Класс обслуживания базы данных
 */
public class DatabaseService {


    /**
     * Константная строка - SQL запрос создания таблицы тем
     */

    //TODO: остановился тут
    private final static String CREATE_STUDENT_TABLE = "CREATE TABLE topics (id IDENTITY , firstName VARCHAR(100), secondName VARCHAR (100),  birthday DATE, height INTEGER)";



    public void createDatabaseTables()  throws Exception{

        Connection connection = ConnectionDBDao.getConnection();

        Statement statement = connection.createStatement();

        statement.executeUpdate(CREATE_STUDENT_TABLE);

        // ... create other table

        statement.close();
    }
}
