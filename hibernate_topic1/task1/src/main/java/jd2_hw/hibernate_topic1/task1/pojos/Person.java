package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    @Column
    private Integer id;
    @Getter
    @Setter
    @Column ( name = "age")
    private Integer age;
    @Getter
    @Setter
    @Column ( name = "name")
    private String name;
    @Getter
    @Setter
    @Column ( name = "surname")
    private String surname;
}
