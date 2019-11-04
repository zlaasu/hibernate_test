package pl.coderslab.author;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.book.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    public Author findOne(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Author author = authorRepository.findById(id).orElse(null);
        List<Book> books = new ArrayList<>();

        author.setBooks(books);
        authorRepository.save(author);

//        authorDao.deleteAuthorRelations(id);
        authorRepository.deleteById(id);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByEmailStartsWith(String string) {
        return authorRepository.findByEmailStartsWithQuery(string);
    }

    public List<Author> findByPeselStartsWith(String string) {
        return authorRepository.findByPeselStartsWith(string);
    }
}
