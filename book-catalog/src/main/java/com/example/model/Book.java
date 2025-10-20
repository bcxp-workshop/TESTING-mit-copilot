package com.example.model;

import jakarta.persistence.*;

/**
 * Entity representing a Book in the catalog.
 */
@Entity
public class Book {
    @Id
    private Integer id;

    private String title;
    private String genre;
    private double price;
    private boolean available;
    private String author;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    /** @return ID of the book */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *                 ID to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** @return title of the book */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *                 book title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return genre of the book */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre
     *                 genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /** @return price of the book */
    public double getPrice() {
        return price;
    }

    /**
     * @param price
     *                 price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /** @return availability status */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available
     *                 availability to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /** @return author name */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     *                 author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /** @return Series in which the book appears */
    public Series getSeries() {
        return series;
    }

    /**
     * @param series
     *                 series to set
     */
    public void setSeries(Series series) {
        this.series = series;
    }
}