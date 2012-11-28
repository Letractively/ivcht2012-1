package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Message;
import java.util.List;

/**
 * Интерфейс, для классов, реализующих работу с таблцией сообщений в некоем хранилище
 */
public interface IMessagesDao {

    /**
     * Метод, возвращающий список всех сообщений
     * @return Список всех сообщений
     */
    public List<Message> getAllMessages();

    /**
     * Метод, возвращающий список сообщений указанной темы
     * @return Список сообщений темы
     */
    public List<Message> getTopicMessages(int topicId);

    /**
     * Метод, добавляющий сообщение в хранилище
     * @param message Экземпляр сообщения
     */
    public void addMessage(Message message);

    /**
     * Метод, изменяющий данные указанного экземпляра сообщения
     * @param id Идентификатор сообщения
     */
    public void editMessage(int id);

    /**
     * Метод, удаляющий указанное сообщение
     * @param id Идентификатор сообщения
     */
    public void deleteMessage(int id);

}
