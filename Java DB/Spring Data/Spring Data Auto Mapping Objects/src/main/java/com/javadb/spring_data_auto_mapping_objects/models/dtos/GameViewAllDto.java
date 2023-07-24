package com.javadb.spring_data_auto_mapping_objects.models.dtos;

import java.math.BigDecimal;

public class GameViewAllDto {

    private String title;
    private BigDecimal price;

    public GameViewAllDto() {
    }

    public GameViewAllDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
