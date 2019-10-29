package pl.coderslab.author;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public Author findOne(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void delete(Long id) {
        Author author = findOne(id);
        if (author != null) {
            entityManager.remove(author);
        }
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Author p");

        return query.getResultList();
    }

    public void deleteAuthorRelations(Long id) {
        Query query = entityManager.createNativeQuery("DELETE FROM books_authors WHERE author_id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
