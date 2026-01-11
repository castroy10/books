package ru.castroy10.books.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги не должно быть пустым")
    @Size(max = 255, message = "Название книги должно быть короче 255 символов")
    @Column(name = "title", nullable = false)
    private String title;

    @Max(value = 2100, message = "Год публикации не может быть больше 2100")
    @Column(name = "publication_year")
    private Integer publicationYear;

    @Size(max = 20, message = "ISBN должен быть короче 20 символов")
    @Column(name = "isbn", unique = true)
    private String isbn;

    @NotNull(message = "Автор должен быть указан")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    @ToString.Exclude
    private Author author;

    @NotNull(message = "Жанр должен быть указан")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    @ToString.Exclude
    private Genre genre;
}

