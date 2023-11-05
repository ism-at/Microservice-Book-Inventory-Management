package com.BookInventoryManagement.Microservice.view;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookInventoryManagement.Microservice.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
