package jd2_hw.hibernate_topic1.task1.pojos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class CarTest extends BaseTest{

    @Test
    public void create() {
        //Given
        Car car = new Car(null, "BMW", 2.4, "red");

        //When
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Serializable id = session.save(car);
        transaction.commit();

        //Then
        assertNotNull(id);
    }
}
