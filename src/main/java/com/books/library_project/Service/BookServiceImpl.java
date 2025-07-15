package com.books.library_project.Service;

import com.books.library_project.DAO.BookDao;
import com.books.library_project.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findByid(Integer id) {
        return bookDao.findByid(id);
    }

    @Override
    @Transactional
    public Book save(Book theBook) {
        return bookDao.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
         bookDao.deleteById(id);
    }
}
