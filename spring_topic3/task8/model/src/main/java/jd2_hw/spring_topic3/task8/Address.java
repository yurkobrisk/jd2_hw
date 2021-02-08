package jd2_hw.spring_topic3.task8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Address implements IAddress {

    private Long id;

    private String street;

    private String city;

    private String country;

    private String email;
}
