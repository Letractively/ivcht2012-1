package edu.sstu.service;

import edu.sstu.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author dkinzel
 */
public class DatabaseService2 {
       private final static String CREATE_FILM_TABLE = "CREATE TABLE films (id IDENTITY , name VARCHAR(100), info VARCHAR (100),  birthday DATE, height INTEGER, grId INTEGER)";
    private final static String CREATE_GENRE_TABLE = "CREATE TABLE genres (id IDENTITY , namegrupp VARCHAR(100), info VARCHAR (1000))";

    public void createDatabaseTables()  throws Exception{
        Connection connection = DataBaseConnection.getConnection();
       Statement statement = connection.createStatement();
      statement.executeUpdate(CREATE_FILM_TABLE);
       statement.close();
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(CREATE_GENRE_TABLE);
        statement2.close();
        // ... create other table

    }


}
