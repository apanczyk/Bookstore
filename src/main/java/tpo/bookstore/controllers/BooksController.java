package tpo.bookstore.controllers;

import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tpo.bookstore.models.Book;
import tpo.bookstore.repositories.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class BooksController {

    @Autowired
    @Qualifier("jdbcBookRepository")
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(@RequestParam(name="sortBy", defaultValue = "titleUp") String sortBy
                        ,@RequestParam(name="search",  defaultValue = "") String search, Model model) {

        Comparator sortByWhat = sortBy.contains("title") ? Comparator.comparing(Book::getTitle)
                                : sortBy.contains("year") ? Comparator.comparing(Book::getYear)
                                : Comparator.comparing(Book::getAuthorsLName);

        List<Book> booksList = bookRepository.findAll(search).stream()
                .filter(x->x.getTitle().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());

        Collections.sort(booksList,sortByWhat);
        if(sortBy.contains("Down"))
            Collections.reverse(booksList);

        model.addAttribute("search", search);
        model.addAttribute("basic", sortBy);
        model.addAttribute("books", booksList);

        return "books";
    }
}
