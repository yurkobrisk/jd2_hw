package jd2_hw.hibernate_topic1.task1.pojos;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "C_ID")
    private Integer carId;

//    @Column(name = "C_MODEL")
    private String model;

    @Transient
//    @Column(name = "C_ENGINE")
    private Double engine;

    @Transient
//    @Column(name = "C_COLOR")
    private String color;
}