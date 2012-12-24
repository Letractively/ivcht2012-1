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
 * Контроллер-сервлет, возвращающий результаты поиска по названию тем
 */
public class TopicSearchController extends HttpServlet {

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

        String searchString =  req.getParameter("searchString");

        //Получает список найденных тем
        List<Topic> topicList = _topicService.getSearchTopicsByString(searchString);

        //Устанавливает атрибут, передающийся странице. Атрибут - это список тем как раз
        req.setAttribute("topics", topicList);
        req.setAttribute("count", topicList.size());

        //Вызывает страницу, не забывая передать все атрибуты
        getServletContext().getRequestDispatcher("/topicSearchResult.jsp").forward(req,resp);

    }

}
