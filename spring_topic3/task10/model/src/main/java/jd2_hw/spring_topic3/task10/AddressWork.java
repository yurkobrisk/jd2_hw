package jd2_hw.spring_topic3.task10;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressWork implements IAddress {

    static {
        System.out.println("creating bean AddressWork...");
    }

    private Long id;

    private String street;

    private String city;

    private String country;

    private String email;

    private Integer postIndex;
}
