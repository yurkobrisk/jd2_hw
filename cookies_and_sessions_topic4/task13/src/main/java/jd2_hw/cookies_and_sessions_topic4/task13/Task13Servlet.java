package jd2_hw.cookies_and_sessions_topic4.task13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet (name = "task13Servlet", urlPatterns = "/task13/")
public class Task13Servlet extends HttpServlet {

    private int counter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies == null || cookies.length == 0) {
            counter = 0;
            Cookie cookie = new Cookie("counter", "" + ++counter);
            cookie.setMaxAge(24*60*60);
            resp.addCookie(cookie);
        }

        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>First Servlet</title></head>");
        writer.println("<body><h1>This is Task 13! Cookies, topic 4.</h1>");
        writer.println("Visits per day : " + counter + ".");
        writer.println("</body></html>");
    }


}
