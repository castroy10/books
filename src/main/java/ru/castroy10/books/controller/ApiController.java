package ru.castroy10.books.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.castroy10.books.dto.AuthorDto;
import ru.castroy10.books.dto.BookDto;
import ru.castroy10.books.dto.GenreDto;
import ru.castroy10.books.entity.Author;
import ru.castroy10.books.entity.Book;
import ru.castroy10.books.entity.Genre;
import ru.castroy10.books.mapper.DtoMapper;
import ru.castroy10.books.service.AuthorService;
import ru.castroy10.books.service.BookService;
import ru.castroy10.books.service.GenreService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;
    private final DtoMapper mapper;

    @GetMapping("/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable Long id) {
        return authorService.findById(id)
                            .map(mapper::toDto)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto dto) {
        Author entity = mapper.toEntity(dto);
        entity.setId(null);
        Author saved = authorService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(saved));
    }

    @PutMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @Valid @RequestBody AuthorDto dto) {
        if (authorService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Author entity = mapper.toEntity(dto);
        entity.setId(id);
        Author updated = authorService.update(entity);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        if (authorService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        authorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/genres")
    public List<GenreDto> getAllGenres() {
        return genreService.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<GenreDto> getGenre(@PathVariable Long id) {
        return genreService.findById(id)
                           .map(mapper::toDto)
                           .map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/genres")
    public ResponseEntity<GenreDto> createGenre(@Valid @RequestBody GenreDto dto) {
        Genre entity = mapper.toEntity(dto);
        entity.setId(null);
        Genre saved = genreService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(saved));
    }

    @PutMapping("/genres/{id}")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable Long id, @Valid @RequestBody GenreDto dto) {
        if (genreService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Genre entity = mapper.toEntity(dto);
        entity.setId(id);
        Genre updated = genreService.update(entity);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/genres/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        if (genreService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        genreService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookService.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long id) {
        return bookService.findById(id)
                          .map(mapper::toDto)
                          .map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto dto) {
        Book entity = mapper.toEntity(dto);
        entity.setId(null);
        Book saved = bookService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(saved));
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto dto) {
        if (bookService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Book entity = mapper.toEntity(dto);
        entity.setId(id);
        Book updated = bookService.update(entity);
        return ResponseEntity.ok(mapper.toDto(updated));
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookService.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

