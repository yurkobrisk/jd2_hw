package jd2_hw.spring_topic3.task8;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@Configuration
public class Address implements IAddress {

    static {
        System.out.println("creating bean Address...");
    }

    private Long id;

    private String street;

    private String city;

    private String country;

    private String email;
}
