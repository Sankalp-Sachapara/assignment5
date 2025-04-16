package com.cestar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cestar.model.Book;

/**
 * Data Access Object for Book entity handling database operations.
 */
@Repository
public class BookDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Insert a new book into the database
     * @param book the book to insert
     * @return number of rows affected
     */
    public int insert(Book book) {
        String sql = "INSERT INTO Book(name, author, price, genre) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), 
                                 book.getPrice(), book.getGenre());
    }
    
    /**
     * Retrieve all books from the database
     * @return list of all books
     */
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }
    
    /**
     * Retrieve a specific book by ID
     * @param id the book ID
     * @return the Book object
     */
    public Book getBookById(int id) {
    	try {
            String sql = "SELECT * FROM Book WHERE id=?";
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BookRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null; // Return null when book not found
        }
    }
    
    /**
     * Update an existing book
     * @param book the book with updated information
     * @return number of rows affected
     */
    public int update(Book book) {
    	Book existingBook = getBookById(book.getId());
        if (existingBook == null) {
            return 0; // Return 0 to indicate no record was updated
        }
        
        String sql = "UPDATE Book SET name=?, author=?, price=?, genre=? WHERE id=?";
        return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), 
                                 book.getPrice(), book.getGenre(), book.getId());
    }
    
    /**
     * Delete a book by ID
     * @param id the book ID to delete
     * @return number of rows affected
     */
    public int delete(int id) {
    	Book existingBook = getBookById(id);
        if (existingBook == null) {
            return 0; // Return 0 to indicate no record was deleted
        }
        
        String sql = "DELETE FROM Book WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }
    
    /**
     * RowMapper implementation for Book
     */
    private static final class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setPrice(rs.getDouble("price"));
            book.setGenre(rs.getString("genre"));
            return book;
        }
    }
}