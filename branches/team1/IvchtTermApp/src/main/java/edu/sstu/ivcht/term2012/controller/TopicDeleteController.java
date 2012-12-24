package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Контроллер-сервлет, удаляющий тему из БД
 */
public class TopicDeleteController extends HttpServlet {

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

        //Переданный идентификатор темы
        String id = req.getParameter("id");

        try {

            //Удаление темы
            _topicService.deleteTopic(Integer.parseInt(id));

            req.setAttribute("result", "Тема успешно удалена");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при удалении темы");
            e.printStackTrace();
        }

        //Получает список всех тем
        List<Topic> topicList = _topicService.getAllTopics();

        //Устанавливает атрибут, передающийся странице. Атрибут - это список тем как раз
        req.setAttribute("topics", topicList);
        req.setAttribute("count", topicList.size());

        //Вызывает страницу, не забывая передать все атрибуты
        getServletContext().getRequestDispatcher("/topicList.jsp").forward(req,resp);
    }

}
