package jd2_hw.hibernate_topic1.task1.service;

import jd2_hw.hibernate_topic1.task1.pojos.Car;
import jd2_hw.hibernate_topic1.task1.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarService {
    /**
     * Adds a new Cars
     * @param car Cars
     */
    public static void add(Car car) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
