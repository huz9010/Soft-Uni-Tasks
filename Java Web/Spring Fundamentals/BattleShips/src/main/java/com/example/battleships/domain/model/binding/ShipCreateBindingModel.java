package com.example.battleships.domain.model.binding;

import com.example.battleships.domain.entity.CategoryType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ShipCreateBindingModel {

    @NotBlank
    @Size(min = 2, max = 10)
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    private LocalDate created;

    @NotNull
    private CategoryType category;

    public ShipCreateBindingModel() {
    }

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
