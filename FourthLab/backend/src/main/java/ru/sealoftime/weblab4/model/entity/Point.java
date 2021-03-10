package ru.sealoftime.weblab4.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data @FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Point {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "ownerId")
    UserData user;

    Double x;
    Double y;
    Double r;
    boolean inside;
    String color;
}
