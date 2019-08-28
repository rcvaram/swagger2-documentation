package com.cvaram.blog.controller;

import com.cvaram.blog.beans.Book;
import com.cvaram.blog.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class HomeController {
    @Autowired
    private BookService bookService;

    @GetMapping(produces = "application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value="{id}", produces = "application/json")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping(value = "{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @PostMapping(consumes = "application/json")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

}
