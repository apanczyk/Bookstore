package tpo.bookstore.models;

import lombok.Data;

@Data
public class Book {

    private String title;
    private String authorsFName;
    private String authorsLName;
    private int year;

    public Book(String title, String authorsFName, String authorsLName, int year) {
        this.title = title;
        this.authorsFName = authorsFName;
        this.authorsLName = authorsLName;
        this.year = year;
    }
}
