package jd2_hw.database_topic1;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Task4 {
    /**
     * Метод выводит информационное сообщение об ошибке
     */
    public static void printError(){
        System.out.println("Arguments or data are in invalid format. Use this format:");
        System.out.println("paydate     | number of receiver         | value, BYR");
        System.out.println("            | 1 - Internet-provider Solo | ");
        System.out.println("yyyy-MM-dd  | 2 - Gipermarket Korona     | int number");
        System.out.println("            | 3 - MTS                    | ");
    }

    public static void main( String[] args ) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date payDate;
        int receiverNumber;
        int value;

        if (args.length != 3) {
            printError();
            return;
        } else {
            try {
                payDate = formatter.parse(args[0]);
                receiverNumber = Integer.parseInt(args[1]);
                value = Integer.parseInt(args[2]);
            } catch (NumberFormatException | ParseException e) {
                printError();
                e.printStackTrace();
                return;
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/listexpenses?serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(dbUrl, "root", "root");
            Statement statement = connection.createStatement();
            // удаление записей из базы если их больше четырех
//            String deleteQuery = "DELETE FROM listexpenses.expenses WHERE listexpenses.expenses.num > 4";
//            statement.executeUpdate(deleteQuery);
            // получение номера последней записи в таблице
            ResultSet maxSet = statement.executeQuery("SELECT * FROM listexpenses.expenses ORDER BY listexpenses.expenses.num DESC LIMIT 1");
            int num = 0;
            while (maxSet.next()) {
                num = maxSet.getInt(1);
            }
            // добавление записи в базу
            num++;
            String addQuery = "INSERT INTO listexpenses.expenses VALUE(" + "" + num +
                    ", \"" + formatter.format(payDate) + "\"" +
                    ", " + receiverNumber +
                    ", " + value + ")";
            statement.executeUpdate(addQuery);
            String query = "SELECT * FROM listexpenses.expenses";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("number: " + resultSet.getInt(1) +
                        " paydate: " + resultSet.getDate(2) +
                        " receiver: " + resultSet.getInt(3) +
                        " value: " + resultSet.getBigDecimal(4));
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver JDBC...");
            e.printStackTrace();
        } catch (SQLException throwables) {
            System.out.println("Error trying connection with JDBC...");
            throwables.printStackTrace();
        }

    }
}
