package pl.coderslab.publisher;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.book.Book;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
