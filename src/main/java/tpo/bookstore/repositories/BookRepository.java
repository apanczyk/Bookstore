package tpo.bookstore.repositories;

import tpo.bookstore.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll(String name);
}
