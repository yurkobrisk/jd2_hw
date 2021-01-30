package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table (name = "T_PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "P_ID")
    private Integer id;
    @Column ( name = "P_AGE")
    private Integer age;
    @Column ( name = "P_NAME")
    private String name;
    @Column ( name = "P_SURNAME")
    private String surname;
}
