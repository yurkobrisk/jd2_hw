package jd2_hw.hibernate_topic1.task1.loader;

import jd2_hw.hibernate_topic1.task1.pojos.Address;
import jd2_hw.hibernate_topic1.task1.pojos.Person;
import jd2_hw.hibernate_topic1.task1.service.PersonService;
import jd2_hw.hibernate_topic1.task1.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonLoader {
    public static void main(String[] args) {
        Person person = new Person(null, 42, "Yury", "Korziuk", new Address());
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();

        PersonService.add(new Person(null, 39, "Ivan", "Ivanov", new Address()));
        PersonService.add(new Person(null, 25, "Sidor", "Sidorov", new Address()));
        PersonService.add(new Person(null, 51, "Petr", "Petrov", new Address()));

        person.setSurname("Gagarin");
        PersonService.edit(person);

//        PersonService.delete(3);

        Person person1 = PersonService.get(2);
        System.out.println("Person with id = 2:");
        System.out.println(person1.toString());

        List<Person> personList = PersonService.getAll();
        for (Person person2 : personList) {
            System.out.println(person2.toString());
        }

        HibernateUtil.close();
    }
}
