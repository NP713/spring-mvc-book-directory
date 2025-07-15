package com.books.library_project.controller;

import com.books.library_project.Service.BookService;
import com.books.library_project.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookContoller {
    private BookService bookService;
    public BookContoller(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/list")
    public String list(Model model){
        List<Book> books=bookService.findAll();
        model.addAttribute("books", books);
        return "book/book-list";
    }
    @GetMapping("/addBooks")
    public String addBooks(Model model){
        model.addAttribute("book", new Book());
        return "book/add-book";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("book") Book book){
        bookService.save(book);
        return "redirect:/books/list";
    }
    @GetMapping("/update")
    public String update(Model model,@RequestParam("bookId") int id){
        Book book=bookService.findByid(id);
        model.addAttribute("book", book);
        return "book/add-book";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int id){
        bookService.deleteById(id);
        return "redirect:/books/list";
    }
}
