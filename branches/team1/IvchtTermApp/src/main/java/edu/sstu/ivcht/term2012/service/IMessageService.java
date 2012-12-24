package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.model.Message;
import edu.sstu.ivcht.term2012.model.Topic;

import java.util.List;

/**
 * Интерфейс, описывающий необходимые методы и операции с сообщениями, требующиеся для сайта
 */
public interface IMessageService {

    /**
     * Метод, возвращающий список всех сообщений
     * @return Список всех сообщений
     */
    public List<Message> getAllMessages();

    /**
     * Метод, добавляющий сообщение в хранилище
     * @param message Экземпляр сообщения
     */
    public void addMessage(Message message);

    /**
     * Метод, возвращающий сообщения указанной темы
     * @param topicID Идентификатор темы
     * @return Найденные сообщения
     */
    public List<Message> getMessagesByTopicID(int topicID);

    /**
     * Поиск тем по строке
     * @param searchString Строка, по которой будет производиться поиск
     * @return Список найденных тем
     */
    public List<Message> getSearchMessagesByString(String searchString);

    /**
     * Метод, изменяющий данные указанного экземпляра темы
     * @param message Измененная темы
     */
    public void editMessage(Message message);

    /**
     * Метод, удаляющий указанную тему
     * @param id Идентификатор темы
     */
    public void deleteMessage(int id);

}
