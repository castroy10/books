package ru.castroy10.books.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя автора не должно быть пустым")
    @Size(max = 255, message = "Имя автора должно быть короче 255 символов")
    @Column(name = "name", nullable = false)
    private String name;

    @Max(value = 2100, message = "Год рождения не может быть больше 2100")
    @Column(name = "birth_year")
    private Integer birthYear;

    @Size(max = 100, message = "Национальность должна быть короче 100 символов")
    @Column(name = "nationality")
    private String nationality;
}

