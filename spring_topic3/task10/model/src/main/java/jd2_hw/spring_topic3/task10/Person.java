package jd2_hw.spring_topic3.task10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@PersonAnnotation
@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {

    static {
        System.out.println("creating bean Person...");
    }

    private Integer id;

    private Integer age;

    private String name;

    private String surname;

    @Autowired
    @Qualifier("address")
    private IAddress addressUniversal;

    @Autowired
    @Qualifier("addressHome")
    private IAddress addressHome;

    @Autowired
    @Qualifier("addressWork")
    private IAddress addressWork;
}
