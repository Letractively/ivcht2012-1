package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Topic;
import java.util.List;

/**
 * Интерфейс, для классов, реализующих работу с таблцией тем в некоем хранилище
 */
public interface ITopicsDao {

    /**
     * Метод, возвращающий список всех тем
     * @return Список всех тем
     */
    public List<Topic> getAllTopics();

    /**
     * Метод, добавляющий тему в хранилище
     * @param topic Экземпляр темы
     */
    public void addTopic(Topic topic);

    /**
     * Метод, изменяющий данные указанного экземпляра темы
     * @param id Идентификатор темы
     */
    public void editTopic(int id);

    /**
     * Метод, удаляющий указанную тему
     * @param id Идентификатор темы
     */
    public void deleteTopic(int id);

}
