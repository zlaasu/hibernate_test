package pl.coderslab.book;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private int rating;

    private String description;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
