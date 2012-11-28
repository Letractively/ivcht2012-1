package edu.sstu.ivcht.term2012.dao;

import edu.sstu.ivcht.term2012.model.Topic;

import java.util.List;

/**
 * Класс, реализующий работу с таблцией тем в базе данных
 */
public class TopicsDBDao implements ITopicsDao{

    /**
     * Метод, возвращающий список всех тем
     *
     * @return Список всех тем
     */
    public List<Topic> getAllTopics() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, добавляющий тему в хранилище
     *
     * @param topic Экземпляр темы
     */
    public void addTopic(Topic topic) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, изменяющий данные указанного экземпляра темы
     *
     * @param id Идентификатор темы
     */
    public void editTopic(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Метод, удаляющий указанную тему
     *
     * @param id Идентификатор темы
     */
    public void deleteTopic(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
