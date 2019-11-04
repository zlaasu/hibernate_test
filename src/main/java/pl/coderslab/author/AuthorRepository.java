package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    List<Author> findByEmailStartsWith(String prefix);

    @Query(value = "SELECT * FROM authors a WHERE a.email LIKE ?1%", nativeQuery = true)
    List<Author> findByEmailStartsWithQuery(String prefix);

    List<Author> findByPeselStartsWith(String prefix);
}