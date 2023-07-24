package com.javadb.spring_data_auto_mapping_objects.models.dtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.javadb.spring_data_auto_mapping_objects.constants.ErrorMessages.*;

public class GameAddDto {

    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailUrl;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto() {
    }

    public GameAddDto(String title, BigDecimal price, Double size, String trailer, String thumbnailUrl, String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Z][A-Za-z\\d\\W]{2,99}", message = INVALID_TITLE)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0", message = INVALID_PRICE)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Min(value = 0, message = INVALID_SIZE)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    //@Pattern(regexp = "https://www.youtube.com[A-Za-z\\w\\W]+")
    @Size(min = 11, max = 11, message = INVALID_TRAILER)
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Pattern(regexp = "^(http|https)://[\\w\\W]*", message = INVALID_IMAGE_URL)
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Size(min = 20)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
