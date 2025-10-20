package com.example.model;

import jakarta.persistence.*;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entity representing a Book Series.
 */
@Entity
public class Series {
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "series")
    @Schema(hidden = true)
    private List<Book> books;

    /** @return ID of the series */
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

    /** @return name of the series */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *                 series name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /** @return list of books in the series */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books
     *                 books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}