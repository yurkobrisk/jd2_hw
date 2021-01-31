package jd2_hw.hibernate_topic1.task1.pojos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CarTest extends BaseTest{

    @Test
    public void create() {
        //Given
        Car car = new Car(null, "BMW", 2.4, "red",
                new Address("Minsk", "Gikalo", "220000"));

        //When
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Serializable id = session.save(car);
        transaction.commit();

        //Then
        assertNotNull(id);
    }

    @Test
    public void printId(){
        //Given
        Car car = new Car(null, "OPEL", 1.6, "white", new Address());

        //When
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < 9; i++) {
            session.save(new Car(null, "Mersedes", 2.0, "black", new Address()));
            session.save(car);
        }
        transaction.commit();

        Query<Car> query = session.createQuery("from Car ", Car.class);
        List<Car> cars = query.list();

        //Then
        assertNotNull(cars);
        assertEquals(10, cars.size());
        System.out.println("------------ Car HI/LO ID`s : ------------");
        System.out.println(cars
                .stream()
                .map(c -> {
                    return c.getCarId().toString();})
                .collect(Collectors.joining(", ")));
        session.close();
    }
}
