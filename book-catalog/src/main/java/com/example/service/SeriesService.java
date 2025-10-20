package com.example.service;

import com.example.dto.BookDTO;
import com.example.dto.SeriesCreateDTO;
import com.example.dto.SeriesDTO;
import com.example.model.Book;
import com.example.model.Series;
import com.example.repository.SeriesRepository;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for series-related business logic and operations.
 */
@Service
public class SeriesService {
    private final SeriesRepository seriesRepository;
    private final ModelMapper modelMapper;

    /**
     * Constructor for SeriesService
     *
     * @param seriesRepository
     *                 repository for series
     * @param modelMapper
     *                 model mapper
     */
    public SeriesService(SeriesRepository seriesRepository, ModelMapper modelMapper) {
        this.seriesRepository = seriesRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * List all series as DTOs.
     *
     * @return list of SeriesDTO
     */
    public List<SeriesDTO> listAllSeries() {
        return seriesRepository.findAll().stream()
                               .map(series -> modelMapper.map(series, SeriesDTO.class))
                               .collect(Collectors.toList());
    }

    /**
     * Get a series DTO by its ID.
     *
     * @param id
     *                 ID of the series
     * @return SeriesDTO or null
     */
    public SeriesDTO getSeriesById(Long id) {
        return seriesRepository.findById(id)
                               .map(series -> modelMapper.map(series, SeriesDTO.class))
                               .orElse(null);
    }

    /**
     * Get available books in a series by series ID.
     *
     * @param seriesId
     *                 ID of the series
     * @return list of available BookDTOs
     */
    public List<BookDTO> getAvailableBooksBySeries(Long seriesId) {
        Series series = seriesRepository.findById(seriesId)
                                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Series not found"));
        return series.getBooks().stream()
                     .filter(Book::isAvailable)
                     .map(book -> modelMapper.map(book, BookDTO.class))
                     .toList();
    }

    /**
     * Create a new series from a SeriesCreateDTO.
     *
     * @param seriesCreateDTO
     *                 DTO containing series data
     * @return created SeriesDTO
     */
    public SeriesDTO createSeries(SeriesCreateDTO seriesCreateDTO) {
        if (seriesRepository.findById(seriesCreateDTO.getId()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Series id must be unique.");
        }
        if (seriesCreateDTO.getName() == null || seriesCreateDTO.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Series name must be provided.");
        }
        if (seriesRepository.findByName(seriesCreateDTO.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Series name must be unique.");
        }
        Series series = new Series();
        series.setId(seriesCreateDTO.getId());
        series.setName(seriesCreateDTO.getName());

        Series saved = seriesRepository.save(series);
        return modelMapper.map(saved, SeriesDTO.class);
    }
}