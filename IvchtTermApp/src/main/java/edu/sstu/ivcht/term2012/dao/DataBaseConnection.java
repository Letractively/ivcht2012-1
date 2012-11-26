package edu.sstu.ivcht.term2012.dao;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author dkinzel
 */
public class DataBaseConnection {

    private static Connection connection;

    public static Connection getConnection() throws Exception {
        //если соединение небыло ранее установлено или было закрыто
        if (connection == null || !connection.isClosed()) {
             Class.forName("org.hsqldb.jdbcDriver");
            //получаем новое соединение
            connection = DriverManager.getConnection("jdbc:hsqldb:file:C:/Temp/autodatabase");
        }
        return connection;
    }
}

