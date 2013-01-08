package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Message;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, реализующий работу с таблцией сообщений в базе данных
 */
public class MessagesDBDao implements IMessagesDao{

    public List<Message> getAllMessages() {
        //Создаем список сообщен в виде связанного списка
        List<Message> messageList = new LinkedList<Message>();

        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Создаем и получаем результат запроса
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM messages");

            //Заполнение списка
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getString("contents"),
                        resultSet.getDate("createDate"),
                        resultSet.getInt("messageID")
                );
                messageList.add(message);
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messageList;
    }

    public void addMessage(Message message) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //Создаем или получаем подключение
            Connection connection =  ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Формируем строку SQL запроса
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("INSERT INTO messages (id, contents, createDate, topicID) VALUES (").append(
                    "'" + message.getId() + "', ").append(
                    "'" + message.getContents() + "', ").append(
                    "'" + sdf.format(message.getCreateDate()) + "', ").append(
                    "'" + message.getTopicID() + "')");

            //Выполняем запрос
            statement.executeUpdate(sqlStringBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Message> getMessagesByTopicID(int topicID) {
        //Создаем список студентов в виде связанного списка
        List<Message> messageList = new LinkedList<Message>();


        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Создаем и получаем результат запроса
            String sql = "SELECT * FROM messages WHERE topicID="+topicID;
            ResultSet resultSet =  statement.executeQuery(sql);

            //Заполнение списка
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getString("contents"),
                        resultSet.getDate("createDate"),
                        resultSet.getInt("topicID")
                );
                messageList.add(message);
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return messageList;
}

    public List<Message> getSearchMessagesByString(String searchString) {

        //Создаем список студентов в виде связанного списка
        List<Message> messageList = new LinkedList<Message>();

        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();
            //Создаем запрос?
            Statement statement = connection.createStatement();
            //Создаем и получаем результат запроса
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM messages WHERE LOWER(subject) LIKE LOWER('%"+searchString+"%')");

            //Заполнение списка
            while (resultSet.next()) {
                Message message = new Message(
                        resultSet.getInt("id"),
                        resultSet.getString("contents"),
                        resultSet.getDate("createDate"),
                        resultSet.getInt("topicID")
                );
                messageList.add(message);
            }

            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return messageList;
    }

    public void editMessage(Message message) {
        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();

            //Создаем запрос?
            Statement statement = connection.createStatement();

            //Создаем строку запроса и выполняем запрос
            String sql = "UPDATE messages SET contents='"+message.getContents()
                    + "' WHERE id="+message.getId();

            statement.executeUpdate(sql);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMessage(int id) {
        try {
            //Создаем или получаем подключение
            Connection connection = ConnectionDBDao.getConnection();

            //Создаем запрос?
            Statement statement = connection.createStatement();

            //Создаем строку запроса и выполняем запрос
            String sql = "DELETE FROM messages WHERE id="+ id;
            statement.executeUpdate(sql);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
