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
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Контроллер-сервлет, заполняющий таблицы тестовыми данными
 */
public class DatabaseFillingController extends HttpServlet {

    //Получение службы работы с темами
    ITopicsService _topicService = ServiceInstancer.getTopicService();

    //Получение службы работы с сообщениями
    IMessagesService _messageService = ServiceInstancer.getMessageService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            //Темы
            _topicService.addTopic(new Topic(
                    0,
                    "Первая тема",
                    "Тема созданная первой",
                    sdf.parse("17.12.2012"),
                    true
            ));

            _topicService.addTopic(new Topic(
                    1,
                    "Приветствие",
                    "Тема созданная для ознакомления",
                    sdf.parse("17.12.2012"),
                    false
            ));

            _topicService.addTopic(new Topic(
                    2,
                    "Текущая тема",
                    "Рабочая тема",
                    new Date(),
                    false
            ));

            //Сообщения
            _messageService.addMessage(new Message(
                    0,
                    "first",
                    new Date(),
                    0
            ));

            _messageService.addMessage(new Message(
                    1,
                    "second",
                    new Date(),
                    0
            ));

            _messageService.addMessage(new Message(
                    2,
                    "third",
                    new Date(),
                    0
            ));

            _messageService.addMessage(new Message(
                    3,
                    "Иванов",
                    new Date(),
                    1
            ));

            _messageService.addMessage(new Message(
                    4,
                    "Петров",
                    new Date(),
                    1
            ));

            _messageService.addMessage(new Message(
                    5,
                    "Сидоров",
                    new Date(),
                    1
            ));

            _messageService.addMessage(new Message(
                    6,
                    "Весна",
                    new Date(),
                    2
            ));
            _messageService.addMessage(new Message(
                    7,
                    "Зима",
                    new Date(),
                    3
            ));
            _messageService.addMessage(new Message(
                    8,
                    "Лето",
                    new Date(),
                    4
            ));

            req.setAttribute("result", "Тестовые темы и сообщения успешно добавлены");
        } catch (Exception e) {
            req.setAttribute("result", "Произошла ошибка при добавлении тестовых тем");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/topicList.jsp").forward(req, resp);
    }
}

