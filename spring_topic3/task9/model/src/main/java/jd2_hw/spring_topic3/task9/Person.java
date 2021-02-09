package jd2_hw.spring_topic3.task9;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
    @AddressAnnotated // аннотация пользовательская для связывания с классом Address
    private IAddress addressUniversal;

    @Autowired
    @Qualifier("addressHome") // имя квалификатора для связывания с классом AddressHome
    private IAddress addressHome;

    @Autowired
    @Qualifier("addressWork") // имя квалификатора для связывания с классом AddressWork
    private IAddress addressWork;

}
