# Books

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5-purple)
![License](https://img.shields.io/badge/license-MIT-green)

**Books** — это веб-приложение для управления библиотекой, демонстрирующее современные практики разработки на Spring Boot. Проект реализует архитектуру **REST API** с фронтендом в виде **Single Page Application (SPA)**, написанным на чистом JavaScript и Bootstrap 5.

## Возможности

* **Create (Создание)**: Позволяет добавлять в систему новых авторов, регистрировать новые жанры и наполнять каталог книгами. При создании книги можно сразу связать её с существующим автором и выбрать подходящий жанр.
* **Read (Чтение)**: Обеспечивает просмотр как полных списков всех сущностей (например, «Все книги»), так и детальной информации по конкретной записи. Реализована быстрая загрузка данных, позволяющая сразу видеть связанные поля (автора книги или список книг жанра).
* **Update (Обновление)**: Дает возможность редактировать информацию о существующих записях. Можно изменить личные данные автора, переименовать жанр или актуализировать данные о книге (например, изменить название или привязать её к другому автору).
* **Delete (Удаление)**: Позволяет безвозвратно удалять устаревшие или ошибочные записи из базы данных. Операция проводится с учетом целостности данных, предотвращая появление «осиротевших» записей в связанных таблицах.
* **Управление связями**: В рамках CRUD-процесса поддерживается корректная работа отношений между сущностями. Система гарантирует, что при выполнении любых операций связи между книгами, их авторами и жанрами остаются актуальными и непротиворечивыми.

## Технологии

- **Язык**: Java 17
- **Фреймворк**: Spring Boot 4.x (Data JPA, Web, Validation)
- **База данных**: PostgreSQL
- **Фронтенд**: HTML5, JavaScript (ES6+), Bootstrap 5
- **Сборка**: Maven

## Структура проекта

```text
.
├── pom.xml                 # Конфигурация Maven
├── README.md               # Документация проекта
└── src
    ├── main
    │   ├── java/ru/castroy10/books
    │   │   ├── BooksApplication.java    # Точка входа
    │   │   ├── controller               # REST Контроллеры
    │   │   ├── dto                      # DTO (Data Transfer Objects)
    │   │   ├── entity                   # JPA Сущности
    │   │   ├── exception                # Глобальный обработчик ошибок
    │   │   ├── mapper                   # Маппинг DTO <-> Entity
    │   │   ├── repository               # Spring Data Репозитории
    │   │   └── service                  # Бизнес-логика
    │   └── resources
    │       ├── application.yml          # Конфигурация приложения
    │       └── templates                # Статические ресурсы
    │           └── index.html           # SPA страница
    └── test                             # Тесты
```

## Схема базы данных

Приложение использует реляционную базу данных. SQL скрипт создания схемы:

```sql
CREATE TABLE author (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birth_year INTEGER,
    nationality VARCHAR(100)
);

CREATE TABLE genre (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publication_year INTEGER,
    isbn VARCHAR(20) UNIQUE,
    author_id BIGINT NOT NULL REFERENCES author(id),
    genre_id BIGINT NOT NULL REFERENCES genre(id)
);
```

## Документация API

Приложение предоставляет RESTful API по пути `/api`.

### Авторы (Authors)
*   **GET** `/api/authors` - Получить список всех авторов.
*   **GET** `/api/authors/{id}` - Получить автора по ID.
*   **POST** `/api/authors` - Создать нового автора.
*   **PUT** `/api/authors/{id}` - Обновить существующего автора.
*   **DELETE** `/api/authors/{id}` - Удалить автора.

### Жанры (Genres)
*   **GET** `/api/genres` - Получить список всех жанров.
*   **GET** `/api/genres/{id}` - Получить жанр по ID.
*   **POST** `/api/genres` - Создать новый жанр.
*   **PUT** `/api/genres/{id}` - Обновить существующий жанр.
*   **DELETE** `/api/genres/{id}` - Удалить жанр.

### Книги (Books)
*   **GET** `/api/books` - Получить список всех книг.
*   **GET** `/api/books/{id}` - Получить книгу по ID.
*   **POST** `/api/books` - Создать новую книгу.
*   **PUT** `/api/books/{id}` - Обновить существующую книгу.
*   **DELETE** `/api/books/{id}` - Удалить книгу.

## Архитектура Фронтенда

Фронтенд реализован как **Single Page Application (SPA)** в одном файле `index.html`.

*   **HTML/Thymeleaf**: `index.html` отдается сервером как статическая точка входа.
*   **JavaScript**: Вся логика отображения, модальные окна и взаимодействие с API написаны на чистом JS.
    *   Использует `fetch()` для асинхронных запросов к `/api`.
    *   Динамически обновляет DOM таблицы при получении данных.
*   **Bootstrap 5**: Отвечает за верстку, адаптивность и стили компонентов (таблицы, кнопки, модальные окна, табы).

## Установка и запуск

1.  **Требования**:
    *   JDK 17+
    *   PostgreSQL

2.  **Настройка**:
    Проверьте настройки БД в `src/main/resources/application.yml`:
    ```yaml
    spring:
      datasource:
        url: jdbc:postgresql://localhost:5432/books
        username: postgres
        password: your_password
    ```

3.  **Запуск**:
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Использование**:
    Откройте `http://localhost:8080`.