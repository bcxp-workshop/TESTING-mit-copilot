package com.example.controller;

import com.example.dto.BookDTO;
import com.example.dto.SeriesCreateDTO;
import com.example.dto.SeriesDTO;
import com.example.service.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for book series endpoints.
 */
@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private final SeriesService seriesService;

    /**
     * Constructor.
     * @param seriesService injected service
     */
    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    /**
     * Get all book series.
     * @return list of SeriesDTO
     */
    @GetMapping
    public List<SeriesDTO> getAllSeries() {
        return seriesService.listAllSeries();
    }

    /**
     * Get a series by ID.
     * @param id series ID
     * @return SeriesDTO
     */
    @GetMapping("/{id}")
    public SeriesDTO getSeriesById(@PathVariable Long id) {
        SeriesDTO series = seriesService.getSeriesById(id);
        if (series == null) {
            throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND, "Series not found");
        }
        return series;
    }

    /**
     * Endpoint: Get all books for a series (as BookDTO).
     * @param id series ID
     * @return list of BookDTO
     */
    @GetMapping("/{id}/books")
    public List<BookDTO> getBooksBySeries(@PathVariable Long id) {
        SeriesDTO series = seriesService.getSeriesById(id);
        if (series == null) {
            throw new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND, "Series not found");
        }
        return series.getBooks();
    }
    /**
     * Endpoint: Get all available books for a series (as BookDTO).
     * @param seriesId series ID
     * @return list of available BookDTO
     */
    @GetMapping("/{seriesId}/books/available")
    public List<BookDTO> getAvailableBooksForSeries(@PathVariable Long seriesId) {
        return seriesService.getAvailableBooksBySeries(seriesId);
    }

    /**
     * Create a new book series.
     * @param seriesCreateDTO series data
     * @return created SeriesDTO
     */
    @PostMapping
    public SeriesDTO createSeries(@RequestBody SeriesCreateDTO seriesCreateDTO) {
        return seriesService.createSeries(seriesCreateDTO);
    }
}