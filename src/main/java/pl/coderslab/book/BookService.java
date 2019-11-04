package pl.coderslab.book;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public Book findOne(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book findBookWithAuthors(Long id) {
        Book book = findOne(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findAll() {
        List<Book> books =  bookRepository.findAll();

        books.forEach(s -> Hibernate.initialize(s.getAuthors()));

        return books;
    }

    public List<Book> findAllPropositions() {
        List<Book> books =  bookRepository.findByPropositionTrue();

        books.forEach(s -> Hibernate.initialize(s.getAuthors()));

        return books;
    }

    public List<Book> findAllPBooks() {
        List<Book> books =  bookRepository.findByPropositionFalse();

        books.forEach(s -> Hibernate.initialize(s.getAuthors()));

        return books;
    }
}
