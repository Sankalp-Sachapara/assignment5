package com.cestar.model;

/**
 * Model class representing a Book entity in the library.
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private double price;
    private String genre;
    
    // Constructors
    public Book() {}
    
    public Book(String name, String author, double price, String genre) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.genre = genre;
    }
    
    // Getters and Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + 
               ", price=" + price + ", genre=" + genre + "]";
    }
}