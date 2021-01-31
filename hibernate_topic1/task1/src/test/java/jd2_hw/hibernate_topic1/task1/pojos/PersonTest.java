package jd2_hw.hibernate_topic1.task1.pojos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest extends BaseTest{

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
        String uuid = "4028e4cb77575bd20177575bd5cc0001";

        //When
        Session session = factory.openSession();
        Person person = session.get(Person.class, uuid);
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
        assertNull(session.get(Person.class, uuid));
        session.close();
    }

    @Test
    public void query() {
        //Given
        cleanInsert("PersonTest.xml");

        //When
        Session session = factory.openSession();
        Query<Person> query = session.createQuery("from Person where surname like 'Ivanova'", Person.class);
        List<Person> persons = query.list();

        //Then
        assertNotNull(persons);
        assertEquals(1, persons.size());
        session.close();
    }

    @Test
    public void printId(){
        //Given
        Person person = new Person(null, 20, "Natalya", "Ivanova");

        //When
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();

        Query<Person> query = session.createQuery("from Person where surname like 'Ivanova'", Person.class);
        List<Person> persons = query.list();

        //Then
        assertNotNull(persons);
        assertEquals(1, persons.size());
        System.out.println("-------- Person UUID = " + persons.get(0).getId() + " --------");
        session.close();
    }

}