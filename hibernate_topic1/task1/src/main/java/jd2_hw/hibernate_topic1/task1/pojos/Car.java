package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
//@Table(name = "T_CAR")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_generator")
    @GenericGenerator(
            name = "hilo_generator",
            strategy = "sequence",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "hilo_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "10"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "4"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")

            })
//    @Column(name = "C_ID")
    private Long carId;

//    @Column(name = "C_MODEL")
    private String model;

    @Transient
//    @Column(name = "C_ENGINE")
    private Double engine;

    @Transient
//    @Column(name = "C_COLOR")
    private String color;
}