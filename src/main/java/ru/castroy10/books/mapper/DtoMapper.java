package ru.castroy10.books.mapper;

import org.springframework.stereotype.Component;
import ru.castroy10.books.dto.AuthorDto;
import ru.castroy10.books.dto.BookDto;
import ru.castroy10.books.dto.GenreDto;
import ru.castroy10.books.entity.Author;
import ru.castroy10.books.entity.Book;
import ru.castroy10.books.entity.Genre;
import ru.castroy10.books.service.AuthorService;
import ru.castroy10.books.service.GenreService;

@Component
public class DtoMapper {

    private final AuthorService authorService;
    private final GenreService genreService;

    public DtoMapper(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
    }

    public Author toEntity(AuthorDto dto) {
        Author author = new Author();
        author.setId(dto.id());
        author.setName(dto.name());
        author.setBirthYear(dto.birthYear());
        author.setNationality(dto.nationality());
        return author;
    }

    public AuthorDto toDto(Author entity) {
        return new AuthorDto(
                entity.getId(),
                entity.getName(),
                entity.getBirthYear(),
                entity.getNationality()
        );
    }

    public Genre toEntity(GenreDto dto) {
        Genre genre = new Genre();
        genre.setId(dto.id());
        genre.setName(dto.name());
        genre.setDescription(dto.description());
        return genre;
    }

    public GenreDto toDto(Genre entity) {
        return new GenreDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription()
        );
    }

    public Book toEntity(BookDto dto) {
        Book book = new Book();
        book.setId(dto.id());
        book.setTitle(dto.title());
        book.setPublicationYear(dto.publicationYear());
        book.setIsbn(dto.isbn());
        if (dto.authorId() != null) {
            book.setAuthor(authorService.findById(dto.authorId()).orElse(null));
        }
        if (dto.genreId() != null) {
            book.setGenre(genreService.findById(dto.genreId()).orElse(null));
        }
        return book;
    }

    public BookDto toDto(Book entity) {
        return new BookDto(
                entity.getId(),
                entity.getTitle(),
                entity.getPublicationYear(),
                entity.getIsbn(),
                entity.getAuthor() != null ? entity.getAuthor().getId() : null,
                entity.getAuthor() != null ? entity.getAuthor().getName() : null,
                entity.getGenre() != null ? entity.getGenre().getId() : null,
                entity.getGenre() != null ? entity.getGenre().getName() : null
        );
    }
}

