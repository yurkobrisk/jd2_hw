package jd2_hw.spring_topic3.task9;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component  // Spring компонент
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddressHome implements IAddress{

    static {
        System.out.println("creating bean AddressHome...");
    }

    private Long id;

    private String street;

    private String city;

    private String country;

    private String email;
}
