package ru.castroy10.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.castroy10.books.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

