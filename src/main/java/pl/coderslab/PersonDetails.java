package pl.coderslab;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.person.Person;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_details")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String streetNumber;

    private String street;

    private String city;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
