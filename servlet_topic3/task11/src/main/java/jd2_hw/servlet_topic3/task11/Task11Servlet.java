package jd2_hw.servlet_topic3.task11;

import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Task11Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter writer = resp.getWriter();
        String header = req.getHeader("User-agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        writer.println("Приветствую пользователя " + userAgent.getBrowser().getName());
        System.out.println("Приветствую пользователя " + userAgent.getBrowser().getName());
    }
}
