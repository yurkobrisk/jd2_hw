package jd2_hw.hibernate_topic1.task1.service;

import jd2_hw.hibernate_topic1.task1.pojos.Person;
import jd2_hw.hibernate_topic1.task1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonService {
    /**
     * Retrievs all Persons
     * @return list of Person
     */
    public static List<Person> getAll() {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Person");
        return query.list();
    }

    /**
     * Retrievs a single Person
     * @param id Persons
     * @return Person
     */
    public static Person get(Integer id) {
        Session session = HibernateUtil.getSession();
        return session.get(Person.class, id);
    }

    /**
     * Adds a new Person
     * @param person Person
     */
    public static void add(Person person) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /**
     * Deletes an existing Person
     * @param id Persons
     */
    public static void delete(Integer id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Person personForDelete = session.get(Person.class, id);
            session.delete(personForDelete);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    /**
     * Edits an existing Person
     * @param person Person
     */
    public static void edit(Person person) {
        Session session = HibernateUtil.getSession();
        Person existingPerson = session.get(Person.class, person.getId());

        existingPerson.setAge(person.getAge());
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(existingPerson);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
