package ru.castroy10.books.service;

import ru.castroy10.books.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    Book update(Book book);
    void delete(Long id);
}

