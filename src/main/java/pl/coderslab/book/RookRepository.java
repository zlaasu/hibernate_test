package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RookRepository extends JpaRepository<Book, Long> {
}
