package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Message;
import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.IMessagesService;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageListController extends HttpServlet {

    //Получение службы работы с сообщениями
    IMessagesService _messageService = ServiceInstancer.getMessageService();

    //Получение службы работы с темами
    ITopicsService _topicService = ServiceInstancer.getTopicService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //Полученный номер темы
        String topicID = req.getParameter("topicID");

        //Получает список всех сообщений в данной теме, для передачи в отображение
        List<Message> messageList = _messageService.getMessagesByTopicID(Integer.parseInt(topicID));

        //Получает текущую тему, чтобы передать её аттрибуты в отображение
        Topic topic = _topicService.getTopicByID(Integer.parseInt(topicID));

        //Устанавливает атрибут, передающийся странице. Атрибут - это список тем как раз
        req.setAttribute("messages", messageList);
        req.setAttribute("count", messageList.size());
        req.setAttribute("topicID", Integer.parseInt(topicID));
        req.setAttribute("topic", topic);

        //Вызывает страницу, не забывая передать все атрибуты
        getServletContext().getRequestDispatcher("/messageList.jsp").forward(req, resp);

    }
}