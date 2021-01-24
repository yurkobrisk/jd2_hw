package jd2_hw.hibernate_topic1.task1.pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest extends BaseTest{

    private SessionFactory factory;

    @Before
    public void setUp() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.test.xml");
        configuration.addAnnotatedClass(Person.class);

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        factory = configuration.buildSessionFactory(registry);
    }

    @Test
    public void create() {
        //Given
        Person person = new Person(null, 24, "Ignat", "Ignatov");

        //When
        Session session = factory.openSession();
        Transaction tx = null;
        Serializable id;
        try {
            tx = session.beginTransaction();
            //do some work
            id = session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        //Then
        assertNotNull(id);
    }

    @Test
    public void delete() {
        //Given
        cleanInsert("PersonTest.xml");

        //When
        Session session = factory.openSession();
        Person person = session.get(Person.class, 3);
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            //do some work
            session.delete(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        //Then
        assertNull(session.get(Person.class, 3));
        session.close();
        deleteDataset();
    }

    @Test
    public void query() {
        //Given
        cleanInsert("PersonTest.xml");

        //When
        Session session = factory.openSession();
        Query query = session.createQuery("from Person where surname like 'Ivanova'", Person.class);
        List<Person> persons = query.list();

        //Then
        assertEquals(1, persons.size());
        deleteDataset();
    }

    @After
    public void tearDown() {
        factory.close();
    }
}