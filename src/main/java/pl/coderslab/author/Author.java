package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.book.Book;
import pl.coderslab.validate.Age;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @PESEL
    @NotBlank
    private String pesel;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Age(minAge = 21)
    private Integer yearOfBirth;
}
