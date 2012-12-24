package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Topic;
import edu.sstu.ivcht.term2012.service.ITopicsService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Контроллер-сервлет, вызывающий форму редактирования темы, с заполненными полями текущими данными
 */
public class TopicEditShowController extends HttpServlet {

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

        //Переданный идентификатор темы
        String id = req.getParameter("id");

        //Создает переменную темы, которая будет передана на страницу потом
        Topic topic = new Topic();

        try {

            //Получение текущих данных темы
            topic = _topicService.getTopicByID(Integer.parseInt(id));

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при поиске темы");
            e.printStackTrace();
        }

        //Устанавливает атрибут, передающийся странице. Атрибут - это список тем как раз
        req.setAttribute("topic", topic);

        //Вызывает страницу, не забывая передать все атрибуты
        getServletContext().getRequestDispatcher("/topicEdit.jsp").forward(req,resp);
    }

}
