package com.example.battleships.domain.model.service;

import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.CategoryType;

import java.time.LocalDate;

public class ShipServiceModel {

    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryType category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
