package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Topic;
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

            _topicService.addTopic(new Topic(
                    "Первая тема",
                    "Тема созданная первой",
                    sdf.parse("17.12.2012")
            ));

            _topicService.addTopic(new Topic(
                    "Приветствие",
                    "Тема созданная для ознакомления",
                    sdf.parse("17.12.2012")
            ));

            _topicService.addTopic(new Topic(
                    "Текущая тема",
                    "Рабочая тема",
                    new Date()
            ));

            req.setAttribute("result", "Тестовые темы успешно добавлены");
        } catch (Exception e) {
            req.setAttribute("result", "Произошла ошибка при добавлении тестовых тем");
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/topicList.jsp").forward(req, resp);
    }
}
