package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.dao.IMessagesDao;
import edu.sstu.ivcht.term2012.dao.MessagesDBDao;
import edu.sstu.ivcht.term2012.model.Message;

import java.util.List;

public class MessagesDaoService implements IMessagesService {

    //                          Поля
    private static IMessagesService _messagesService;
    private IMessagesDao _messagesDao = new MessagesDBDao();

    //                          Конструкторы
    private MessagesDaoService(){
    }

    //                          Свои методы
    public static IMessagesService getInstance() {
        if (_messagesService == null) {
            _messagesService = new MessagesDaoService();
        }
        return _messagesService;
    }

    //                          Обертки
    public List<Message> getAllMessages() {
        return _messagesDao.getAllMessages();
    }

    public void addMessage(Message message) {
        _messagesDao.addMessage(message);
    }

    public List<Message> getMessagesByTopicID(int topicID) {
        return _messagesDao.getMessagesByTopicID(topicID);
    }

    public List<Message> getSearchMessagesByString(String searchString) {
        return _messagesDao.getSearchMessagesByString(searchString);
    }

    public void editMessage(Message message) {
        _messagesDao.editMessage(message);
    }

    public void deleteMessage(int id) {
        _messagesDao.deleteMessage(id);
    }
}
