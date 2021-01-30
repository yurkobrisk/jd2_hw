package jd2_hw.hibernate_topic1.task1.pojos;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {

    SessionFactory factory;

    @Before
    public void setUp() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.test.xml");
//        configuration.addAnnotatedClass(Person.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.test.xml")
                .build();

//        factory = configuration.buildSessionFactory(registry);
        factory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @After
    public void tearDown() {
        factory.close();
    }

    private final static Logger log = Logger.getLogger(BaseTest.class.getName());

    private IDatabaseConnection connection;
    private IDataSet dataSet;

    public void cleanInsert(String resourceName) {
        try {
            if (connection == null) {
                connection = new MySqlConnection(
                        MySqlDataSource.getTestConnection(),
                        "jpadb_test");
            }
            dataSet = new FlatXmlDataSetBuilder().build(BaseTest.class
                    .getResourceAsStream(resourceName));
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void deleteDataset() {
        try {
            DatabaseOperation.DELETE.execute(connection, dataSet);
            connection.close();
        } catch (SQLException | DatabaseUnitException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

class MySqlDataSource {

    private final static Logger log = Logger.getLogger(MySqlDataSource.class.getName());
    private static Properties properties = new Properties();

    static {
        try {
            properties.load(MySqlDataSource.class
                    .getResourceAsStream("/jpadb_test.ds.properties"));
            Class.forName(properties.getProperty("jdbc.drivers"));
        } catch (ClassNotFoundException | IOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(
                properties.getProperty("url"),
                properties
        );
    }

}