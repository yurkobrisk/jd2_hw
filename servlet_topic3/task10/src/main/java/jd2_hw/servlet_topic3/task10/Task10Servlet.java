package jd2_hw.servlet_topic3.task10;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Task10Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();

        String name = req.getParameter("user.name");
        String number = req.getParameter("user.phone.number");
        String mail = req.getParameter("user.mail");

        if (name == "" || number == "" || mail == "") {
            try {
                throw new Exception();
            } catch (Exception e) {
                writer.println("Error ! All the fields of the form are obligatory.");
                e.printStackTrace();
            }
            return;
        }
        writer.println("user name: " + name);
        writer.println("user phone number: " + number);
        writer.println("user e-mail: " + mail);
        System.out.println("user name: " + name);
        System.out.println("user phone number: " + number);
        System.out.println("user e-mail: " + mail);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
