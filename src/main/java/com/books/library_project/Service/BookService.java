package com.books.library_project.Service;

import com.books.library_project.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book findByid(Integer id);
    public Book save(Book theBook);
    public void deleteById(Integer id);
}
