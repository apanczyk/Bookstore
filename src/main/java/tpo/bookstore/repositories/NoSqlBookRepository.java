package tpo.bookstore.repositories;

import org.springframework.stereotype.Repository;
import tpo.bookstore.models.Book;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoSqlBookRepository implements BookRepository {

    @Override
    public List<Book> findAll(String name) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Balkon","Artur","Kowalski",2009));
        bookList.add(new Book("Tulipan","Arthur","Smith",2015));
        bookList.add(new Book("Adam Łucznik","Megan","Murphy",2000));
        bookList.add(new Book("Kartonowe pole","Olivier","Williams",2010));
        bookList.add(new Book("Batman","Charles","Conway",1999));
        bookList.add(new Book("Czerwony Smok","Jack","Taylor",1987));
        bookList.add(new Book("Szybki samochód","Robert","Nowak",1952));

        return bookList;
    }
}
