package ru.castroy10.books.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthorDto(
        Long id,
        @NotBlank(message = "Имя автора не должно быть пустым")
        @Size(max = 255, message = "Имя автора должно быть короче 255 символов")
        String name,
        @Max(value = 2100, message = "Год рождения не может быть больше 2100")
        Integer birthYear,
        @Size(max = 100, message = "Национальность должна быть короче 100 символов")
        String nationality
) {

}

