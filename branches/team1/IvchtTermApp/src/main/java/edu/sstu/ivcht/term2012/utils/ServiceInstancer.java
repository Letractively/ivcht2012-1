package edu.sstu.ivcht.term2012.utils;

import edu.sstu.ivcht.term2012.service.IMessagesService;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.service.MessagesDaoService;
import edu.sstu.ivcht.term2012.service.TopicsDaoService;

/**
 * Я не понимаю зачем этот класс, являющийся обёткой TopicBaseService,
 * который в свою очередь является оберткой TopicsDBDao
 * (ServiceInstancer.TopicService -> TopicBaseService -> TopicsDBDao)
 * (utils -> service -> dao)
 */
public class ServiceInstancer {

    /**
     * Статичный метод получения экземпляра сервиса работы с темами из service
     * @return Служба работы с темами
     */
    public static ITopicsService getTopicService(){
        //Получить же конкретно выбранный вариант !!!
        return TopicsDaoService.getInstance();
    }

    /**
     * Статичный метод получения экземпляра сервиса работы с темами из service
     * @return Служба работы с темами
     */
    public static IMessagesService getMessageService(){
        return MessagesDaoService.getInstance();
    }

}
