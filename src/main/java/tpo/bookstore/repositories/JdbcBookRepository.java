package tpo.bookstore.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tpo.bookstore.models.Book;

import java.util.List;

@Repository
public class JdbcBookRepository implements BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Book> findAll(String sortByWhat, String sortMethod) {
        return jdbcTemplate.query(
                "select * from Book",
                (rs, rowNum) ->
                        new Book(
                                rs.getString("title"),
                                rs.getString("authorFName"),
                                rs.getString("authorLName"),
                                rs.getInt("year")
                        )
        );
    }

    @Override
    public List<Book> findByName(String name) {
        return jdbcTemplate.query(
                "select * from books where title=?",new Object[] {name},
                (rs, rowNum) ->
                        new Book(
                                rs.getString("title"),
                                rs.getString("authorFName"),
                                rs.getString("authorLName"),
                                rs.getInt("year")
                        )
        );
    }
}
