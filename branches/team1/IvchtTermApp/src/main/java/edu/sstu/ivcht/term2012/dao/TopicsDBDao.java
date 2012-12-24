package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.ITopicsService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, реализующий работу с таблцией тем в базе данных
 * наследует интерфейс вариантов источников данных
 * и интерфейс службы, говорящий о том, какие методы нужны
 */
public class TopicsDBDao implements ITopicsDao,ITopicsService {

    /**
     * Метод, возвращающий список всех тем
     * @return Список всех тем
     */
    public List<Topic> getAllTopics() {

        //Создаем список студентов в виде связанного списка
        List<Topic> topicList = new LinkedList<Topic>();

        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Создаем и получаем результат запроса
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM topics");

            //Заполнение списка
            while (resultSet.next()) {
                Topic topic = new Topic(
                        resultSet.getInt("id"),
                        resultSet.getString("subject"),
                        resultSet.getString("description"),
                        resultSet.getDate("createDate")
                );
                topicList.add(topic);
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return topicList;
    }

    /**
     * Метод, добавляющий тему в хранилище
     * @param topic Экземпляр темы
     */
    public void addTopic(Topic topic) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Создаем или получаем подключение
            Connection connection =  ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Формируем строку SQL запроса
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("INSERT INTO topics (subject, description, createDate) VALUES (").append(
                    "'" + topic.getSubject() + "', ").append(
                    "'" + topic.getDescription() + "', ").append(
                    "'" + sdf.format(topic.getCreateDate()) + "')");

            //Выполняем запрос
            statement.executeUpdate(sqlStringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, возвращающий экземпляр темы по её идентификатору
     *
     * @param id Идентификатор темы
     * @return Найденная тема
     */
    public Topic getTopicByID(int id) {

        //Создаем переменную темы, которую будем возвращать
        Topic topic = new Topic();

        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Создаем и получаем результат запроса
            String sql = "SELECT * FROM topics WHERE id="+id;
            ResultSet resultSet =  statement.executeQuery(sql);

            resultSet.next();

            //Применяем изменения
                     topic.setId(resultSet.getInt("id"));
                topic.setSubject(resultSet.getString("subject"));
            topic.setDescription(resultSet.getString("description"));
             topic.setCreateDate(resultSet.getDate("createDate"));

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return topic;
    }

    /**
     * Метод, изменяющий данные указанного экземпляра темы
     * @param topic Измененная темы
     */
    public void editTopic(Topic topic) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();

            //Создаем запрос?
            Statement statement = connection.createStatement();

            //Создаем строку запроса и выполняем запрос
            String sql = "UPDATE topics SET subject="+topic.getSubject()
                    + ", description="+topic.getDescription()
                    + ", createDate="+sdf.format(topic.getCreateDate())
                    + " WHERE id="+topic.getId();

            statement.executeUpdate(sql);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, удаляющий указанную тему
     * @param id Идентификатор темы
     */
    public void deleteTopic(int id) {
        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();

            //Создаем запрос?
            Statement statement = connection.createStatement();

            //Создаем строку запроса и выполняем запрос
            String sql = "DELETE FROM topics WHERE id="+ id;
            statement.executeUpdate(sql);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
