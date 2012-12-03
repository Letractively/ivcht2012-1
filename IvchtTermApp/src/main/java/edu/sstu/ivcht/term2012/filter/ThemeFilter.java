package edu.sstu.ivcht.term2012.filter;

import edu.sstu.ivcht.term2012.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ThemeFilter implements Filter {

    public final static int THEMES_COUNT = 2;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        if (session.getAttribute("themeCount") == null) {
            session.setAttribute("themeCount", THEMES_COUNT);
        }
        if (session.getAttribute("theme") == null) {
            String theme = CookieUtils.getCookie((HttpServletRequest) servletRequest, "theme");
            if (theme == null) {
                theme = "1";
                CookieUtils.addCookie((HttpServletResponse) servletResponse, "theme", theme);
            }
            session.setAttribute("theme", theme);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
