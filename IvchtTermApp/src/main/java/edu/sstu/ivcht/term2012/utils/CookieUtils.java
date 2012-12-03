package edu.sstu.ivcht.term2012.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    private final static String SITE_PREFIX = "mySite";

    //устанавливаем время хранения cookie по умолчанию 90 дней
    private final static int DEFAULT_MAX_AGE = 60 * 60 * 24 * 90;


    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        addCookie(response, cookieName, cookieValue, DEFAULT_MAX_AGE);
    }

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
        Cookie cookie = new Cookie(SITE_PREFIX + cookieName, cookieValue);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String cookieName) {
        String searchValue = SITE_PREFIX + cookieName;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //если эта искомая cookie
            if (searchValue.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
