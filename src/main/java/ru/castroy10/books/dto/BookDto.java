package ru.castroy10.books.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookDto(
        Long id,
        @NotBlank(message = "Название книги не должно быть пустым")
        @Size(max = 255, message = "Название книги должно быть короче 255 символов")
        String title,
        @Max(value = 2100, message = "Год публикации не может быть больше 2100")
        Integer publicationYear,
        @Size(max = 20, message = "ISBN должен быть короче 20 символов")
        String isbn,
        @NotNull(message = "Автор должен быть указан")
        Long authorId,
        String authorName,
        @NotNull(message = "Жанр должен быть указан")
        Long genreId,
        String genreName
) {

}

