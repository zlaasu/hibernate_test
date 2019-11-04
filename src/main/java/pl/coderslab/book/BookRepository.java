package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByPropositionTrue();

    List<Book> findByPropositionFalse();

    List<Book> findByTitle(String title);

    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findByTitleQuery(String title);

    List<Book> findByCategoryId(Long id);

    @Query("SELECT b FROM Book b WHERE b.category.id = :categoryId")
    List<Book> findByCategoryIdQuery(@Param("categoryId") Long id);

    List<Book> findByAuthorsId(Long authorId);

    List<Book> findByPublisherId(Long id);

    @Query("SELECT b FROM Book b WHERE b.publisher.id = ?1")
    List<Book> findByPublisherIdQuery(Long id);

    List<Book> findByRating(int id);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN ?1 AND ?2")
    List<Book> findByRatingQuery(int start, int stop);

    Book findFirstByCategoryIdOrderByTitle(Long id);

    @Query(value="SELECT b.* FROM books AS b WHERE publisher_id = ?1 ORDER BY b.title LIMIT 1"
            , nativeQuery = true)
    Book findFirstByCategoryIdOrderByTitleQuery(Long id);
}
