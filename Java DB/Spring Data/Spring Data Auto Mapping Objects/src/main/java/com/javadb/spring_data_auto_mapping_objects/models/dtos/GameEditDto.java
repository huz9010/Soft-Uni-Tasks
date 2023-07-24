package com.javadb.spring_data_auto_mapping_objects.models.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class GameEditDto {

    private Long id;
    private String title;
    private String trailerId;
    private String imageUrl;
    private Double size;
    private BigDecimal price;
    private String description;
    private LocalDate releaseDate;

    public GameEditDto() {
    }

    public GameEditDto(Long id, String title, String trailerId, String imageUrl, Double size, BigDecimal price, String description, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.trailerId = trailerId;
        this.imageUrl = imageUrl;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public void updateFields(Map<String, String> updatedValues) {
        for (String key : updatedValues.keySet()) {
            if (Objects.equals(key, "title")) {
                setTitle(updatedValues.get(key));
            } else if (Objects.equals(key, "price")) {
                setPrice(new BigDecimal(updatedValues.get(key)));
            } else if (Objects.equals(key, "size")) {
                setSize(Double.parseDouble(updatedValues.get(key)));
            } else if (Objects.equals(key, "trailer")) {
                setTrailerId(updatedValues.get(key));
            } else if (Objects.equals(key, "thumbnailURL")) {
                setImageUrl(updatedValues.get(key));
            } else if (Objects.equals(key, "description")) {
                setDescription(updatedValues.get(key));
            } else if (Objects.equals(key, "releaseDate")) {
                setReleaseDate(LocalDate.now());
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(String trailerId) {
        this.trailerId = trailerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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