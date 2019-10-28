package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
        Author author = findOne(id);
        if (author != null) {
            authorDao.delete(id);
        }
    }
}
