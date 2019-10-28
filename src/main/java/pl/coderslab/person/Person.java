package pl.coderslab.person;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.PersonDetails;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String password;

    private String email;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetails personDetails;
}
