package jd2_hw.spring_topic3.task10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@PersonAnnotation
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Address implements IAddress{

    static {
        System.out.println("creating bean Address...");
    }

    private Long id;

    private String city;

    private String country;

}
