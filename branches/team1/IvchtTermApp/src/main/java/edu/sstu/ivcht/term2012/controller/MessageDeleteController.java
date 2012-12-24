package edu.sstu.ivcht.term2012.controller;

import edu.sstu.ivcht.term2012.model.Message;
import edu.sstu.ivcht.term2012.service.IMessagesService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageDeleteController extends HttpServlet {

    //Получение службы работы с сообщенами
    IMessagesService _messageService = ServiceInstancer.getMessageService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    /**
     * Обработка запроса со страницы messageAdd.jsp
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");

        //Переданный идентификатор темы и сообщеня на удаление
        String id = req.getParameter("id");

        String topicID = req.getParameter("topicID");

        try {
            //Удаление сообщены
            _messageService.deleteMessage(Integer.parseInt(id));

            req.setAttribute("result", "Cообщение успешно удалена");
        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при удалении сообщения");
            e.printStackTrace();
        }

        //Получает список всех сообщен
        List<Message> messageList = _messageService.getMessagesByTopicID(Integer.parseInt(topicID));

        //Устанавливает атрибут, передающийся странице. Атрибут - это список сообщен как раз
        req.setAttribute("messages", messageList);
        req.setAttribute("count", messageList.size());

        //Вызывает страницу, не забывая передать все атрибуты
        getServletContext().getRequestDispatcher("/messageList.jsp").forward(req,resp);
    }


}
