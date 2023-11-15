package com.example.battleships.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    public Category() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    @Column(columnDefinition = "text")
    private String description;

    public Category(CategoryType name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public CategoryType getName() {
        return name;
    }

    public void setName(CategoryType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
