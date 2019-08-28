package com.cvaram.blog.services;
import com.cvaram.blog.beans.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

@Service
public class BookService {

    private List<Book> books;

    @PostConstruct
    void init() {
        this.books = new ArrayList<>();

        Book cisco = new Book(1, "cisco networks", "computer networks", 1023);
        books.add(cisco);

        Book learnJava = new Book(2, "learn java", "Programming languages", 3434);
        books.add(learnJava);

        Book kate = new Book(3, "Kate", "Ethical hacking", 3334);
        books.add(kate);
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book getBookById(int id) {
        return this.books
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Book createBook(Book book) {
        OptionalInt maxId = this.books.stream().mapToInt(Book::getId).max();
        if (maxId.isPresent()) {
            book.setId(maxId.getAsInt()+1);
        }

        return book;
    }

    public void deleteBook(int id) {
        for (Book book : this.books) {
            if(book.getId() == id) {
                this.books.remove(book);
                return;
            }
        }
    }
}
