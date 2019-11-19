package com.cvaram.blog.controller;

import com.cvaram.blog.beans.Book;
import com.cvaram.blog.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(produces = "application/json")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }

  @GetMapping(value = "/{id}", produces = "application/json")
  public Book getBookById(@PathVariable int id) {
    return bookService.getBookById(id);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
  }

  @PostMapping(consumes = "application/json")
  public Book createBook(@RequestBody Book book) {
    return bookService.createBook(book);
  }
}
