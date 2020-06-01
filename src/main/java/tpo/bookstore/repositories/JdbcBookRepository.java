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
    public List<Book> findAll(String name) {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql,
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
