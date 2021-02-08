package jd2_hw.spring_topic3.task8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@Configuration
public class Person {

    static {
        System.out.println("creating bean Person...");
    }

    private Integer id;

    private Integer age;

    private String name;

    private String surname;

    @Autowired(required = false) //Автосвязывание, поле проинициализируется null-значением
                                // если required = false и не возникнет исключение
    private IAddress address;

}
