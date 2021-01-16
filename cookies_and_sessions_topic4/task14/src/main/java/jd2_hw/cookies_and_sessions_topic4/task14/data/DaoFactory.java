package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public ExpensesDao getExpensesDaoImpl() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/product?serverTimezone=UTC",
                    "root",
                    "root"
        );
        return new ExpensesDaoImpl(connection);
    }

    public static DaoFactory getInstance(DatabaseName databaseName) throws ClassNotFoundException {
        switch (databaseName) {
            case MYSQL: {
                if (daoFactory == null) {
                    daoFactory = new DaoFactory();
                }
                return daoFactory;
            }
            case ORACLE: {
                // TODO: not implemented
                return null;
            }
            case POSTGRESQL: {
                // TODO: not implemented
                return null;
            }
        }
        throw new IllegalArgumentException("Database name is unknown");
    }
}
