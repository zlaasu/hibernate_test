package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPropositionTrue();

    List<Book> findByPropositionFalse();

    List<Book> findByTitle(String title);

    List<Book> findByCategoryId(Long id);

    List<Book> findByAuthorsId(Long authorId);

    List<Book> findByPublisherId(Long id);

    List<Book> findByRating(int id);

    Book findFirstByCategoryIdOrderByTitle(Long id);
}
