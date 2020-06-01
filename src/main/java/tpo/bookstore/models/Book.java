package tpo.bookstore.models;

import lombok.*;

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
    public String getTitle() {
        return title;
    }

    public String getAuthorsFName() {
        return authorsFName;
    }

    public String getAuthorsLName() {
        return authorsLName;
    }

    public int getYear() {
        return year;
    }
}
