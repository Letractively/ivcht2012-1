package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.dao.ITopicsDao;
import edu.sstu.ivcht.term2012.dao.TopicsDBDao;
import edu.sstu.ivcht.term2012.model.Topic;

import java.util.List;

/**
 * Класс, служба работы с данными, в тоже время обёртка класса работы с базой данных, но с дополнительным функционалом
 * благодаря обработки данных полученных из БД
 */
public class TopicsDaoService implements ITopicsService {

    //                          Поля

    //Один экземпляр службы должен быть, здесь его и храним
    private static TopicsDaoService topicsDaoService;

    //Задает вариант использования DAO
    private ITopicsDao topicsDao = new TopicsDBDao();

    //                          Конструкторы

    /**
     * Конструктор - пустейший
     */
    private TopicsDaoService(){
    }

    //                          Свои методы

    /**
     * Метод статический, позволяющий всегда иметь один экземпляр данного класса
     * @return Экземпляр службы обработки тем
     */
    public static TopicsDaoService getInstance() {
        if (topicsDaoService == null) {
            topicsDaoService = new TopicsDaoService();
        }
        return topicsDaoService;
    }

    //                          Обертки

    /**
     * Получить список всех тем
     * @return Список всех тем
     */
    public List<Topic> getAllTopics() {
        return topicsDao.getAllTopics();
    }

    /**
     * Добавить тему
     * @param topic Новая тема
     */
    public void addTopic(Topic topic) {
        topicsDao.addTopic(topic);
    }

    /**
     * Редактировать тему
     * @param id Уникальный идентификатор темы
     */
    public void editTopic(int id) {
        //TODO: fill
    }

    /**
     * Удалить тему
     * @param id Уникальный идентификатор темы
     */
    public void deleteTopic(int id) {
        //TODO: fill
    }
}
