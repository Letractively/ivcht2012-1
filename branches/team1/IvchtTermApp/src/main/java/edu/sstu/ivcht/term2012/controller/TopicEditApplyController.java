package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Контроллер-сервлет, обрабатывающий запрос на применение изменений темы
 */
public class TopicEditApplyController extends HttpServlet {

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
     * Обработка полученных данных о текущем состоянии темы
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        //Извлечение переданных сервлетом переменных
        String id = req.getParameter("id");
        String subject = req.getParameter("subject");
        if (subject=="")
            subject="<empty>";
        String description = req.getParameter("description");

        String createDate = req.getParameter("createDate");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        //Попытка изменения темы в БД
        try {

            //Новый экземпляр темы для передачи в метод изменения данных темы
            Topic topic = new Topic(
                    Integer.parseInt(id),
                    subject,
                    description,
                    sdf.parse(createDate)
            );

            //Применение изменений темы
            _topicService.editTopic(topic);

            req.setAttribute("result", "Тема успешно изменена");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при изменении темы");
            e.printStackTrace();
        }

        //Передает результаты обработки запроса на страницу
        getServletContext().getRequestDispatcher("/topicEdit.jsp").forward(req, resp);

    }
}
