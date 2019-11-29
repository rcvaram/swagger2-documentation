package com.cvaram.blog.controller;

import com.cvaram.blog.beans.Book;
import com.cvaram.blog.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/books")
@RestController
@Api(tags = "Books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "This endpoint is used to get the all books details")
    @ApiResponses(value = {
          @ApiResponse(code = 400, message = "Bad request is received", response = Error.class),
          @ApiResponse(code = 500, message = "800000 - Server error", response = Error.class)
    })
    @GetMapping(produces = "application/json")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @ApiOperation(value = "This endpoint is used to get the specific book using book's ID ")
    @ApiResponses(value = {
          @ApiResponse(code = 400, message = " Bad request is received", response = Error.class),
          @ApiResponse(code = 500, message = " Server error", response = Error.class)
    })
    @GetMapping(value = "/{id}", produces = "application/json")
    public Book getBookById(@ApiParam(value = "The Id of the book", required = true) @PathVariable int id) {
        return bookService.getBookById(id);
    }

    @ApiOperation(value = "This endpoint is used to delete the specific book using book's ID ")
    @ApiResponses(value = {
          @ApiResponse(code = 400, message = " Bad request is received", response = Error.class),
          @ApiResponse(code = 500, message = " Server error", response = Error.class)
    })
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@ApiParam(value = "The Id of the book", required = true) @PathVariable int id) {
        bookService.deleteBook(id);
    }

    @ApiOperation(value = "This endpoint is used to post a new book")
    @ApiResponses(value = {
          @ApiResponse(code = 400, message = " Bad request is received", response = Error.class),
          @ApiResponse(code = 500, message = " Server error", response = Error.class)
    })
    @PostMapping(consumes = "application/json")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
