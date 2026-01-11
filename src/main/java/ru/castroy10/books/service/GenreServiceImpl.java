package ru.castroy10.books.service;

import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.castroy10.books.entity.Genre;
import ru.castroy10.books.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    @Transactional
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public Optional<Genre> findById(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Genre::getId))
                .toList();
    }

    @Override
    @Transactional
    public Genre update(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}

