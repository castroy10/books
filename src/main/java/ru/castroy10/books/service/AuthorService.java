package ru.castroy10.books.service;

import ru.castroy10.books.entity.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);
    Optional<Author> findById(Long id);
    List<Author> findAll();
    Author update(Author author);
    void delete(Long id);
}

