package edu.sstu.service;

import edu.sstu.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author dkinzel
 */
public class DatabaseService {
   private final static String CREATE_STUDENT_TABLE = "CREATE TABLE students (id IDENTITY , firstName VARCHAR(100), secondName VARCHAR (100),  birthday DATE, height INTEGER, grId INTEGER)";
    private final static String CREATE_GRUPPA_TABLE = "CREATE TABLE gruppa (id IDENTITY , namegrupp VARCHAR(100), info VARCHAR (1000))";

    public void createDatabaseTables()  throws Exception{
        Connection connection = DataBaseConnection.getConnection();
       Statement statement = connection.createStatement();
      statement.executeUpdate(CREATE_STUDENT_TABLE);
       statement.close();
        Statement statement2 = connection.createStatement();
        statement2.executeUpdate(CREATE_GRUPPA_TABLE);
        statement2.close();
        // ... create other table

    }


}
