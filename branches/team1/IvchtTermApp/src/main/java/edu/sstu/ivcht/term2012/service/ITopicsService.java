package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.model.Topic;
import java.util.List;

/**
 * Интерфейс, описывающий необходимые методы и операции с темами, требующиеся для сайта
 */
public interface ITopicsService {

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
