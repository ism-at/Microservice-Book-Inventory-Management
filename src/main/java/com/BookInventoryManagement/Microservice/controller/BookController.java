package com.BookInventoryManagement.Microservice.controller;

import com.BookInventoryManagement.Microservice.model.Book;
import com.BookInventoryManagement.Microservice.view.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    //Single Entry public Book createBook(@RequestBody Book book) { return bookRepository.save(book); }
    public List<Book> createBooks(@RequestBody List<Book> books) {
        return (List<Book>) bookRepository.saveAll(books);
    }
    @GetMapping
    // public List<Book> getAllBooks() {return bookRepository.findAll();}
    public List<Book> getAllBooks() {
        Iterable<Book> booksIterable = bookRepository.findAll();
        List<Book> bookList = StreamSupport.stream(booksIterable.spliterator(), false)
                .collect(Collectors.toList());
        return bookList;
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book not found"
            );
        }
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            Book updatedBook = bookRepository.save(book);
            return updatedBook;
        }
        return null;  // Or handle the error appropriately
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

