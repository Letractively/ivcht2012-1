package edu.sstu.ivcht.term2012.controller;


import edu.sstu.ivcht.term2012.filter.ThemeFilter;
import edu.sstu.ivcht.term2012.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThemeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object themeObject = req.getParameter("theme");
        String theme = "1";
        try {
            int themeNum = Integer.parseInt(themeObject.toString());
            if (themeNum < 1 || themeNum > ThemeFilter.THEMES_COUNT) {
                theme = "1";
            } else theme = themeObject.toString();
        } catch (Exception e) {
        }
        CookieUtils.addCookie(resp, "theme", theme);
        req.getSession().setAttribute("theme", theme);
        getServletContext().getRequestDispatcher("/chooseTheme.jsp").forward(req, resp);
    }
}
