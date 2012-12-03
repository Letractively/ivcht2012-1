package edu.sstu.ivcht.term2012.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Класс подключения к базе данных
 */
public class ConnectionDBDao {

    /**
     * Поле, хранящее подключение
     */
    private static Connection _connection;

    /**
     * Геттер для получения подключения
     * @return Подключение к базе данных
     * @throws Exception Исключение?
     */
    public static Connection getConnection() throws Exception {

        //Если соедиение не создано или закрыто
        if (_connection == null || !_connection.isClosed()) {

            Class.forName("org.hsqldb.jdbcDriver");

            //Создаем новое подключение
            _connection = DriverManager.getConnection("jdbc:hsqldb:file:C:/Temp/Team1/database");

        }

        return _connection;
    }
}
