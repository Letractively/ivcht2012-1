package edu.sstu.ivcht.term2012.controller;
import edu.sstu.ivcht.term2012.model.Message;
import edu.sstu.ivcht.term2012.service.IMessagesService;
import edu.sstu.ivcht.term2012.utils.ServiceInstancer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Контроллер-сервлет, добавляющий сообщение в указанную тему
 */
public class MessageAddApplyController extends HttpServlet {

    //Получение службы работы с темами
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
     * Обработка запроса со страницы topicAdd.jsp
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");


        //Извлечение переданных сервлетом переменных
        String topicID = req.getParameter("topicID");
        String contents = req.getParameter("contents");
        if (contents=="")
            contents="<empty>";

        //Попытка добавления темы в БД
        try {
            //Новый экземпляр темы
            Message message = new Message(
                    contents,
                    new Date(),
                    Integer.parseInt(topicID)
            );

            _messageService.addMessage(message);

            req.setAttribute("result", "Сообщение успешно добавлено");

        } catch (Exception e) {
            req.setAttribute("error", "Произошла ошибка при создании сообщения");
            e.printStackTrace();
        }



        //Передает результаты обработки запроса на страницу
        getServletContext().getRequestDispatcher("/messageList?topicID="+Integer.parseInt(topicID)).forward(req, resp);


    }
}