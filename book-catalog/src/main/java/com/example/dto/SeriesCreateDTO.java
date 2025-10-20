package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO representing series data set via the API.
 */
public class SeriesCreateDTO {
    @Schema(description = "Series id", example = "1")
    private Integer id;

    @Schema(description = "Series name", example = "Scheibenwelt")
    private String name;

    /** @return ID */
    public Integer getId() {
        return id;
    }

    /** 
     * @param id
     *                 id to set
     */
    public void setId(Integer id) {
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
}