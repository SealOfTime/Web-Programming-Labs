package ru.sealoftime.weblab4.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Data
@Entity
public class UserData{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Integer id;

    @Column(unique = true)
    private String username;

    private String password;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Point> points;
}
