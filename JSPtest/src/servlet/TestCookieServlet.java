package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-24
 * Time: ÏÂÎç5:32
 * To change this template use File | Settings | File Templates.
 */
public class TestCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        Cookie idCookie = new Cookie("id", id);
        idCookie.setPath("/jsptest");
        idCookie.setMaxAge(1 * 30 * 24 * 3600);
        Cookie nameCookie = new Cookie("name", name);
        nameCookie.setPath("/jsptest");
        nameCookie.setMaxAge(1 * 30 * 24 * 3600);
        response.addCookie(idCookie);
        response.addCookie(nameCookie);
        request.getRequestDispatcher("/testCookie.jsp").forward(request, response);
    }
}
