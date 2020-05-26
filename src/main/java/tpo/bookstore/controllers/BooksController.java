package tpo.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tpo.bookstore.models.Book;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BooksController {

    @GetMapping("/books")
    public String books(Model model) {
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Harry Potter", "JK"));
        booksList.add(new Book("Percy Jackson", "Not JK"));

        model.addAttribute("books", booksList);

        return "books";
    }
}
