package ru.castroy10.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.castroy10.books.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}

