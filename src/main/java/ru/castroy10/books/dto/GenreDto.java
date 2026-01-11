package ru.castroy10.books.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GenreDto(
        Long id,
        @NotBlank(message = "Название жанра не должно быть пустым")
        @Size(max = 100, message = "Название жанра должно быть короче 100 символов")
        String name,
        String description
) {

}

