package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table (name = "T_PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue (generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Column (name = "P_ID")
    private String id;
    @Column ( name = "P_AGE")
    private Integer age;
    @Column ( name = "P_NAME")
    private String name;
    @Column ( name = "P_SURNAME")
    private String surname;
}
