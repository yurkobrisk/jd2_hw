package jd2_hw.spring_topic3.task8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component  //Spring компонент
public class Person {

    private Integer id;

    private Integer age;

    private String name;

    private String surname;

    @Autowired(required = false) //Автосвязывание, поле проинициализируется null-значением
    private IAddress address;

}
