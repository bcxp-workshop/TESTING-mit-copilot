package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository for accessing Book entities from the database.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailable(boolean available);

    List<Book> findByGenre(String genre);

    List<Book> findByPriceBetween(double minPrice, double maxPrice);

    List<Book> findByAuthor(String author);
}