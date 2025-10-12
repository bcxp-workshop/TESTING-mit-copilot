package com.example.service;

import com.example.dto.BookDTO;
import com.example.model.Book;
import com.example.repository.BookRepository;
import com.example.repository.SeriesRepository;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Test
    void testListAllBooksReturnsExpectedResult() {
        BookRepository repo = mock(BookRepository.class);
        SeriesRepository repoSeries = mock(SeriesRepository.class);
        ModelMapper mapper = new ModelMapper();
        BookService service = new BookService(repo, repoSeries, mapper);

        Book book = new Book();
        book.setTitle("Test Buch");
        book.setAuthor("Max Mustermann");
        when(repo.findAll()).thenReturn(List.of(book));

        List<BookDTO> result = service.listAllBooks();
        assertEquals(1, result.size());
        assertEquals("Test Buch", result.get(0).getTitle());
    }

    @Test
    void testFindBooksByAuthorReturnsEmptyForUnknownAuthor() {
        BookRepository repo = mock(BookRepository.class);
        SeriesRepository repoSeries = mock(SeriesRepository.class);
        ModelMapper mapper = new ModelMapper();
        BookService service = new BookService(repo, repoSeries, mapper);

        when(repo.findByAuthor("Unbekannt")).thenReturn(List.of());

        List<BookDTO> result = service.findBooksByAuthor("Unbekannt");
        assertTrue(result.isEmpty());
    }

    @Test
    void testToDTOMapsPropertiesCorrectly() {
        ModelMapper mapper = new ModelMapper();
        SeriesRepository repoSeries = mock(SeriesRepository.class);
        BookService service = new BookService(mock(BookRepository.class), repoSeries, mapper);

        Book book = new Book();
        book.setId(42L);
        book.setTitle("Geheimnisvogel");
        book.setAuthor("Erika Mustermann");
        book.setGenre("Roman");
        book.setAvailable(true);
        book.setPrice(29.99);

        BookDTO dto = service.toDTO(book);

        assertEquals(42L, dto.getId());
        assertEquals("Geheimnisvogel", dto.getTitle());
        assertEquals("Erika Mustermann", dto.getAuthor());
        assertEquals("Roman", dto.getGenre());
        assertTrue(dto.isAvailable());
        assertEquals(29.99, dto.getPrice());
    }
}