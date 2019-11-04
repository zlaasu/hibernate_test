package pl.coderslab.book;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private boolean proposition;

    @NotNull(groups = {BookValidatorGroup.class, PropositionValidatorGroup.class})
    @Size(min = 5, groups = {BookValidatorGroup.class, PropositionValidatorGroup.class})
    private String title;

    @Range(min = 1, max = 10, groups = BookValidatorGroup.class)
    private int rating;

    @Min(value = 2, groups = BookValidatorGroup.class)
    private int pages;

    @NotBlank(groups = PropositionValidatorGroup.class)
    @Size(max = 600, groups = {BookValidatorGroup.class, PropositionValidatorGroup.class})
    private String description;

    @NotNull(groups = BookValidatorGroup.class)
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotEmpty(groups = BookValidatorGroup.class)
    @ManyToMany
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", proposition=" + proposition +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                '}';
    }
}
