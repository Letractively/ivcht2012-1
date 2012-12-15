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
    private final static String CREATE_TOPICS_TABLE = "CREATE TABLE topics (id IDENTITY, subject VARCHAR(100), description VARCHAR (100), createDate DATE)";

    /**
     * Константная строка - SQL запрос создания таблицы сообщений
     */
    private final static String CREATE_MESSAGES_TABLE = "CREATE TABLE messages (id IDENTITY, subject VARCHAR(100), text VARCHAR (100), createDate DATE, topicID INTEGER)";

    /**
     * Метод, создающий необходимые таблицы в базе данных
     * @throws Exception
     */
    public void createDatabaseTables()  throws Exception{

        //Экземпляр подключения к БД
        Connection connection = ConnectionDBDao.getConnection();

        //Экземпляр обращения к БД
        Statement statement = connection.createStatement();

        //Выполнение команды БД
        //Создание таблиц тем и сообщений
        statement.executeUpdate(CREATE_TOPICS_TABLE);
        statement.executeUpdate(CREATE_MESSAGES_TABLE);

        //Закрытие обращения к БД
        statement.close();
    }
}
