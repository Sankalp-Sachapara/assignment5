package com.cestar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cestar.dao.BookDao;
import com.cestar.model.Book;

/**
 * REST Controller for Book resource
 */
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookDao bookDao;
    
    /**
     * Get all books
     * @return list of all books
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookDao.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    /**
     * Get a specific book by ID
     * @param id the book ID
     * @return the Book object
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
    	try {
            Book book = bookDao.getBookById(id);
            if (book != null) {
                return new ResponseEntity<>(book, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Add a new book
     * @param book the book to add
     * @return the created book
     */
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        int result = bookDao.insert(book);
        if (result > 0) {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Update an existing book
     * @param id the book ID
     * @param book the updated book information
     * @return the updated book
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
    	 try {
    	        book.setId(id);
    	        int result = bookDao.update(book);
    	        if (result > 0) {
    	            return new ResponseEntity<>(book, HttpStatus.OK);
    	        } else {
    	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	        }
    	    } catch (Exception e) {
    	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	    }
    }
    
    /**
     * Delete a book
     * @param id the book ID to delete
     * @return no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
    	try {
            int result = bookDao.delete(id);
            if (result > 0) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}