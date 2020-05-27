package tpo.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tpo.bookstore.models.Book;
import tpo.bookstore.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BooksController {

    @Autowired
    @Qualifier("jdbcBookRepository")
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<Book> booksList = bookRepository.findAll("name","name");
        model.addAttribute("books", booksList);

        return "books";
    }
}
