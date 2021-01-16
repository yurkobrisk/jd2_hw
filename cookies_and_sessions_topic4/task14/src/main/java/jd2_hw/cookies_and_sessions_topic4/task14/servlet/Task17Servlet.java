package jd2_hw.cookies_and_sessions_topic4.task14.servlet;

import jd2_hw.cookies_and_sessions_topic4.task14.data.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Collections;
import java.util.List;

@WebServlet (name = "task17Servlet", urlPatterns = "/task17")
public class Task17Servlet extends HttpServlet {

    DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.MYSQL);
        } catch (ClassNotFoundException e) {
            System.out.println("Database not found!");
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        final List<Expenses> expenses;
        ExpensesDao expensesDao = null;
        try {
            expensesDao = daoFactory.getExpensesDaoImpl();
        } catch (SQLException e) {
            System.out.println("SQL ERROR!");
        }
        if (num == null) {
            expenses = expensesDao.readAll();
        } else {
            Expenses expense = null;
            try {
                expense = expensesDao.read(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                System.out.println("Parse ERROR!");
            }
            expenses = expense != null ? List.of(expense) : Collections.emptyList();
        }

        req.setAttribute("expenses", expenses);
        req.getRequestDispatcher("/jsp/result.jsp").forward(req, resp);

    }
}
