package com.example.dto;

/**
 * DTO representing book data returned via the API.
 */
public class BookDTO {
    private Integer id;
    private String title;
    private String genre;
    private double price;
    private boolean available;
    private String author;
    private String seriesName;

    /** 
     * @param id
     *                 id to set 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /** @return ID */
    public Integer getId() {
        return id;
    }

    /** @return title */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *                 title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /** @return genre */
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

    /** @return price */
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

    /** @return available */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available
     *                 available to set
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /** @return author */
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

    /** @return series name */
    public String getSeriesName() {
        return seriesName;
    }

    /**
     * @param seriesName
     *                 series name to set
     */
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}