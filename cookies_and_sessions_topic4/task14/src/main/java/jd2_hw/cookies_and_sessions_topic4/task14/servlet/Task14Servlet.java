package jd2_hw.cookies_and_sessions_topic4.task14.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "task14Servlet",
        urlPatterns = "/task14",
        initParams = {
                @WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/listexpenses?serverTimezone=UTC"),
                @WebInitParam(name = "user", value = "root"),
                @WebInitParam(name = "password", value = "root")
        })
public class Task14Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ServletConfig config = getServletConfig();

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    config.getInitParameter("url"),
                    config.getInitParameter("user"),
                    config.getInitParameter("password"));
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from listexpenses.expenses");

            PrintWriter writer = resp.getWriter();
            while (resultSet.next()) {
                writer.println("" + resultSet.getInt(1) + " " +
                                    resultSet.getDate(2) + " " +
                                    resultSet.getInt(3) + " " +
                                    resultSet.getBigDecimal(4));
            }
            writer.println("Task 14! Cookies and sessions topic 4. Init Param.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Что-то пошло не так в модуле задания 14! В данный момент все исправляется.");
        }
    }
}
