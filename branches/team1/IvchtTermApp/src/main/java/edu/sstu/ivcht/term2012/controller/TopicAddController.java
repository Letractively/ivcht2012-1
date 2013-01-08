package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Контроллер-сервлет, вызывающший страницу со списком тем
 */
public class TopicAddController extends HttpServlet {

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

    /**
     * Обработка запроса со страницы topicAdd.jsp
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        //Извлечение переданных сервлетом переменных
        String subject = req.getParameter("subject");
        if (subject=="")
             subject="<empty>";
        String description = req.getParameter("description");

        boolean closed = (req.getParameter("closed") != null);

        //Попытка добавления темы в БД
        try {
            //Новый экземпляр темы
            Topic topic = new Topic(
                    subject,
                    description,
                    new Date(),
                    closed
            );

            _topicService.addTopic(topic);

            req.setAttribute("result", "Тема успешно добавлена, вы будете переведены на главную страницу");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при создании темы");
            e.printStackTrace();
        }

        //Передает результаты обработки запроса на страницу
        getServletContext().getRequestDispatcher("/topicAdd.jsp").forward(req, resp);
    }

}
