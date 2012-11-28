package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Message;

import java.util.List;

/**
 * Класс, реализующий работу с таблцией сообщений в базе данных
 */
public class MessagesDBDao implements IMessagesDao{

    /**
     * Метод, возвращающий список всех сообщений
     *
     * @return Список всех сообщений
     */
    public List<Message> getAllMessages() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, возвращающий список сообщений указанной темы
     *
     * @return Список сообщений темы
     */
    public List<Message> getTopicMessages(int topicId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, добавляющий сообщение в хранилище
     *
     * @param message Экземпляр сообщения
     */
    public void addMessage(Message message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, изменяющий данные указанного экземпляра сообщения
     *
     * @param id Идентификатор сообщения
     */
    public void editMessage(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, удаляющий указанное сообщение
     *
     * @param id Идентификатор сообщения
     */
    public void deleteMessage(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
