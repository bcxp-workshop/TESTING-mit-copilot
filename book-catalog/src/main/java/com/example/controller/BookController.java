package com.example.controller;

import com.example.dto.BookDTO;
import com.example.service.BookService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * REST controller for book endpoints.
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    /**
     * Constructor for BookController
     *
     * @param bookService
     *                 service for book logic
     */
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Returns all books.
     *
     * @return list of BookDTO
     */
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.listAllBooks();
    }

    /**
     * Returns a book by its ID.
     *
     * @param id
     *                 book ID
     * @return BookDTO
     */
    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable Long id) {
        BookDTO book = bookService.getBookById(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found for id: " + id);
        }
        return book;
    }

    /**
     * Search books by query parameters.
     *
     * @param genre
     *                 filter genre
     * @param author
     *                 filter author
     * @param minPrice
     *                 minimum price
     * @param maxPrice
     *                 maximum price
     * @param available
     *                 availability status
     * @return filtered list
     */
    @GetMapping("/search")
    public List<BookDTO> searchBooks(
                    @RequestParam(required = false) String genre,
                    @RequestParam(required = false) String author,
                    @RequestParam(required = false) Double minPrice,
                    @RequestParam(required = false) Double maxPrice,
                    @RequestParam(required = false) Boolean available
    ) {
        return bookService.searchBooks(genre, author, minPrice, maxPrice, available);
    }

    /**
     * Create a new book.
     *
     * @param bookDTO
     *                 book data
     * @return created BookDTO
     */
    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    /**
     * Find books by author.
     *
     * @param author
     *                author name
     * @return list of BookDTO
     */
    @GetMapping("/author/{author}")
    public List<BookDTO> getBooksByAuthor(@PathVariable String author) {
        return bookService.findBooksByAuthor(author);
    }

    /**
     * Get discounted price for a book.
     *
     * @param id
     *                 book ID
     * @param discount
     *                 discount percentage (e.g., 0.1 for 10%)
     * @return discounted price
     */
    @GetMapping("/{id}/discounted-price")
    public double getDiscountedBookPrice(@PathVariable Long id, @RequestParam double discount) {
        return bookService.getDiscountedBookPrice(id, discount);
    }

    @GetMapping("/average-price")
    public double getAveragePrice() {
        return bookService.getAverageBookPrice();
    }

    @GetMapping("/most-expensive")
    public BookDTO getMostExpensiveBook() {
        return bookService.getMostExpensiveBook();
    }

    @GetMapping("/cheapest")
    public BookDTO getCheapestBook() {
        return bookService.getCheapestBook();
    }
}