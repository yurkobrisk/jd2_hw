package jd2_hw.hibernate_topic1.task1.loader;

import jd2_hw.hibernate_topic1.task1.pojos.Person;
import jd2_hw.hibernate_topic1.task1.util.HibernateUtil;

import javax.persistence.EntityManager;

public class PersonLoader {
    public static void main(String[] args) {
        Person person = new Person(null, 42, "Yury", "Korziuk");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        HibernateUtil.close();
    }
}
