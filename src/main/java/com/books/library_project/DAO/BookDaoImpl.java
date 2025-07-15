package com.books.library_project.DAO;

import com.books.library_project.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookDaoImpl implements BookDao {

    private EntityManager entityManager;
    public BookDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query=entityManager.createQuery("from Book",Book.class);
        return query.getResultList();
    }

    @Override
    public Book findByid(Integer id) {
        Book theBook=entityManager.find(Book.class,id);
        return theBook;
    }

    @Override
    public Book save(Book theBook) {
       Book newBook=entityManager.merge(theBook);
       return newBook;
    }
    @Override
    public void deleteById(Integer id) {
        Book book=entityManager.find(Book.class,id);
        entityManager.remove(book);
    }
}
