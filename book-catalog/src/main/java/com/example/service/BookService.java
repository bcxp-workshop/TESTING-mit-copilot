package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.model.Series;
import com.example.repository.BookRepository;
import com.example.repository.SeriesRepository;

/**
 * Service for book-related business logic and operations.
 */
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final SeriesRepository seriesRepository;
    private final ModelMapper modelMapper;

    /**
     * Constructor for BookService
     *
     * @param bookRepository
     *                 book repository
     * @param seriesRepository
     *                 series repository
     * @param modelMapper
     *                 model mapper
     */
    public BookService(BookRepository bookRepository, SeriesRepository seriesRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.seriesRepository = seriesRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * List all books as DTOs.
     *
     * @return list of BookDTO
     */
    public List<BookDTO> listAllBooks() {
        return bookRepository.findAll()
                             .stream()
                             .map(this::toDTO)
                             .collect(Collectors.toList());
    }

    /**
     * Get a book DTO by its ID.
     *
     * @param id
     *                 book ID
     * @return BookDTO or null
     */
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id).map(this::toDTO).orElse(null);
    }

    /**
     * Search for books using different parameters.
     *
     * @param genre
     *                 genre filter
     * @param author
     *                 author filter
     * @param minPrice
     *                 min price filter
     * @param maxPrice
     *                 max price filter
     * @param available
     *                 available filter
     * @return filtered list of BookDTO
     */
    public List<BookDTO> searchBooks(String genre, String author, Double minPrice, Double maxPrice, Boolean available) {
        List<Book> books = bookRepository.findAll();
        return books.stream().filter(book -> {
                        boolean matches = true;
                        if (genre != null && !genre.isEmpty())
                            matches &= book.getGenre().equalsIgnoreCase(genre);
                        if (author != null && !author.isEmpty())
                            matches &= book.getAuthor().equalsIgnoreCase(author);
                        if (minPrice != null)
                            matches &= book.getPrice() >= minPrice;
                        if (maxPrice != null)
                            matches &= book.getPrice() <= maxPrice;
                        if (available != null)
                            matches &= book.isAvailable() == available;
                        return matches;
                    })
                    .map(this::toDTO)
                    .collect(Collectors.toList());
    }

    /**
     * Helper to map Book entity to BookDTO.
     *
     * @param book
     *                 Book entity
     * @return BookDTO
     */
    public BookDTO toDTO(Book book) {
        BookDTO dto = modelMapper.map(book, BookDTO.class);
        Series series = book.getSeries();
        dto.setSeriesName(series != null ? series.getName() : null);
        return dto;
    }

    public BookDTO createBook(BookDTO dto) {
        // Validate required fields
        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book title is missing.");
        }
        if (dto.getGenre() == null || dto.getGenre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Genre is missing.");
        }
        if (dto.getAuthor() == null || dto.getAuthor().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author is missing.");
        }
        if (dto.getPrice() == 0.0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price is zero.");
        }
        if (dto.getPrice() < 5.00 || dto.getPrice() > 100.00) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book price must be between 5.00 and 100.00.");
        }
        Series series = null;
        if (dto.getSeriesName() != null && !dto.getSeriesName().isBlank()) {
            series = seriesRepository.findByName(dto.getSeriesName());
            if (series == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Given series does not exist.");
            } else if (!isTitleUniqueInSeries(dto.getTitle(), series)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book title must be unique within the series.");
            }
        }
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setGenre(dto.getGenre());
        book.setPrice(dto.getPrice());
        book.setAvailable(dto.isAvailable());
        book.setAuthor(dto.getAuthor());
        book.setSeries(series);

        Book saved = bookRepository.save(book);
        return toDTO(saved);
    }

    /**
     * Check if a book title is unique within a series.
     */
    private boolean isTitleUniqueInSeries(String title, Series series) {
        if (series == null || series.getBooks() == null) {
            return true;
        }
        return series.getBooks().stream().noneMatch(b -> title.equalsIgnoreCase(b.getTitle()));
    }

    /**
     * Finds books by author (case-insensitive).
     *
     * @param author
     *                 Author name.
     * @return List of BookDTO.
     */
    public List<BookDTO> findBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books.stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * Calculate discounted price for a single book.
     *
     * @param bookId
     *                Book ID.
     * @return the discounted price.
     */
    public double getDiscountedBookPrice(Long bookId, double discountPercent) {
        Book book = bookRepository.findById(bookId).orElse(null);

        return PriceCalculator.calculateBookPrice(book, discountPercent);
    }

    /**
     * Calculate average price of all books.
     *
     * @return average price
     */
    public double getAverageBookPrice() {
        List<Book> books = bookRepository.findAll();
        return PriceCalculator.calculateAveragePrice(books);
    }

    /**
     * Find the most expensive book.
     *
     * @return most expensive book DTO
     */
    public BookDTO getMostExpensiveBook() {
        List<Book> books = bookRepository.findAll();
        return modelMapper.map(PriceCalculator.findMostExpensiveBook(books), BookDTO.class);
    }

    /**
     * Find the cheapest book.
     *
     * @return cheapest book DTO
     */
    public BookDTO getCheapestBook() {
        List<Book> books = bookRepository.findAll();
        return modelMapper.map(PriceCalculator.findCheapestBook(books), BookDTO.class);
    }
}