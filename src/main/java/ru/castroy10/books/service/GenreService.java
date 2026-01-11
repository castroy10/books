package ru.castroy10.books.service;

import ru.castroy10.books.entity.Genre;
import java.util.List;
import java.util.Optional;

public interface GenreService {
    Genre save(Genre genre);
    Optional<Genre> findById(Long id);
    List<Genre> findAll();
    Genre update(Genre genre);
    void delete(Long id);
}

