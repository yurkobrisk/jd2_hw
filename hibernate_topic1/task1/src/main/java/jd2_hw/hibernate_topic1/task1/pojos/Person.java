package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table (name = "PERSON")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    @Column (name = "ID")
    private Integer id;
    @Getter
    @Setter
    @Column ( name = "AGE")
    private Integer age;
    @Getter
    @Setter
    @Column ( name = "NAME")
    private String name;
    @Getter
    @Setter
    @Column ( name = "SURNAME")
    private String surname;
}
