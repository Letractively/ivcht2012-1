package edu.sstu.service;

import edu.sstu.dao.DataBaseConnection;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @author dkinzel
 */
public class DatabaseService {
    private final static String CREATE_FILM_TABLE = "CREATE TABLE films (id IDENTITY , name VARCHAR(100), info VARCHAR (1000), country VARCHAR (100), D3 Boolean, date DATE,  genreId INTEGER)";
    private final static String CREATE_GENRE_TABLE = "CREATE TABLE genres (id IDENTITY , genre VARCHAR(100), info VARCHAR (1000), date DATE)";

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
