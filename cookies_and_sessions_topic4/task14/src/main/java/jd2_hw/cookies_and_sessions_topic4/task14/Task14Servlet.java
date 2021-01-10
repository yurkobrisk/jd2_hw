package jd2_hw.cookies_and_sessions_topic4.task14;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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
            writer.println("Task 14! Cookies and sessions topic 4.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
