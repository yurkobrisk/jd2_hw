package jd2_hw.spring_topic3.task9;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component  // Spring компонент
@AddressAnnotated // аннотация для связывания
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
