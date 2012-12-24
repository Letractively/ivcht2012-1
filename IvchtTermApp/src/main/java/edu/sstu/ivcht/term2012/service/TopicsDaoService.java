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
    private static ITopicsService _topicsService;

    //Задает вариант использования DAO
    private ITopicsDao _topicsDao = new TopicsDBDao();

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
    public static ITopicsService getInstance() {
        if (_topicsService == null) {
            _topicsService = new TopicsDaoService(); //Self
        }
        return _topicsService;
    }

    //                          Обертки

    /**
     * Получить список всех тем
     * @return Список всех тем
     */
    public List<Topic> getAllTopics() {
        return _topicsDao.getAllTopics();
    }

    /**
     * Добавить тему
     * @param topic Новая тема
     */
    public void addTopic(Topic topic) {
        _topicsDao.addTopic(topic);
    }

    /**
     * Метод, возвращающий экземпляр темы по её идентификатору
     *
     * @param id Идентификатор темы
     * @return Найденная тема
     */
    public Topic getTopicByID(int id) {
       return _topicsDao.getTopicByID(id);
    }

    /**
     * Поиск тем по строке
     *
     * @param searchString Строка, по которой будет производиться поиск
     * @return Список найденных тем
     */
    public List<Topic> getSearchTopicsByString(String searchString) {
        return _topicsDao.getSearchTopicsByString(searchString);
    }

    /**
     * Редактировать тему
     * @param topic Измененная тема
     */
    public void editTopic(Topic topic) {
        _topicsDao.editTopic(topic);
    }

    /**
     * Удалить тему
     * @param id Уникальный идентификатор темы
     */
    public void deleteTopic(int id) {
        _topicsDao.deleteTopic(id);
    }
}
