package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

    private String city;

    private String street;

    private String postalCode;
}
