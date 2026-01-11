package ru.castroy10.books.service;

import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.castroy10.books.entity.Book;
import ru.castroy10.books.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Book save(Book book) {
        Book saved = bookRepository.save(book);
        Hibernate.initialize(saved.getAuthor());
        Hibernate.initialize(saved.getGenre());
        return saved;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll().stream()
                             .sorted(Comparator.comparing(Book::getId))
                             .toList();
    }

    @Override
    @Transactional
    public Book update(Book book) {
        Book saved = bookRepository.save(book);
        Hibernate.initialize(saved.getAuthor());
        Hibernate.initialize(saved.getGenre());
        return saved;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
}

