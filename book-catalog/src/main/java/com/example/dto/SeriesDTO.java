package com.example.dto;

import java.util.List;

/**
 * DTO representing series data returned via the API.
 */
public class SeriesDTO {
    private Long id;
    private String name;
    private List<BookDTO> books;

    /** @return ID */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *                 ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /** @return name */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *                 name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return books */
    public List<BookDTO> getBooks() {
        return books;
    }

    /**
     * @param books
     *                 books to set
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}