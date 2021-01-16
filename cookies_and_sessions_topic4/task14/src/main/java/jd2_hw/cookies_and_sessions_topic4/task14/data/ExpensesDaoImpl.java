package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ExpensesDaoImpl implements ExpensesDao {

    private final Connection connection;

    public ExpensesDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Expenses expenses) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into listexpenses.expenses (num, paydate, receiver, value)\n" +
                        "values(?, ?, ?, ?)"
        )) {
            preparedStatement.setInt(1, expenses.getNum());
            preparedStatement.setDate(2, expenses.getPaydate());
            preparedStatement.setInt(3, expenses.getReceiver());
            preparedStatement.setBigDecimal(4, expenses.getValue());
            System.out.println("create " + preparedStatement.executeUpdate());

        } catch (SQLException throwables) {
            System.out.println("Error to add in database!");
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Expenses read(int num) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "select * from listexpenses.expenses where num=" + num))
        {
            resultSet.next();
            Expenses expense = new Expenses();

            expense.setNum(resultSet.getInt("num"));
            expense.setPaydate(resultSet.getDate("paydate"));
            expense.setReceiver(resultSet.getInt("receiver"));
            expense.setValue(resultSet.getBigDecimal("value"));
            return expense;

        } catch (SQLException throwables) {
            System.out.println("Reading ERROR!");
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Expenses> readAll() {
        List<Expenses> expenses = new LinkedList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from listexpenses.expenses"))
        {
            while (resultSet.next()) {
                Expenses expense = new Expenses();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getDate("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getBigDecimal("value"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.out.println("Reading ERROR from Database table Expenses!");
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public void update(Expenses expenses) {
    }

    @Override
    public void delete(Expenses expenses) {
    }
}
