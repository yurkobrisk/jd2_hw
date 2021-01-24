package jd2_hw.hibernate_topic1.task1.util;

import jd2_hw.hibernate_topic1.task1.pojos.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    //Core init
    private static final EntityManagerFactory emFactory;
    private static final SessionFactory sessionFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("jd2_hw.hibernate_topic1.task1");

        //create Session Factory
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            configuration.addAnnotatedClass(Person.class);

            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(registry);

        } catch (Throwable e) {
            //TODO:Make log
            System.out.println();
            System.err.print("Inition SessionFactory creation failed. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    //create Entity Manager
    public static EntityManager getEntityManager(){
        return emFactory.createEntityManager();
    }

    public static void close(){
        emFactory.close();
    }

    //create Session
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
