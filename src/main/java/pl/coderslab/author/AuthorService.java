package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.book.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author) {
        authorDao.save(author);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public Author findOne(Long id) {
        return authorDao.findOne(id);
    }

    public void delete(Long id) {
        Author author = authorDao.findOne(id);
        List<Book> books = new ArrayList<>();

        author.setBooks(books);
        authorDao.update(author);

//        authorDao.deleteAuthorRelations(id);
        authorDao.delete(id);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }
}
