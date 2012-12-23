package edu.sstu.ivcht.term2012.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bodriy
 * Date: 23.12.12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
public class MessageListController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
    String topicID = req.getParameter("topicID");

    }
}
