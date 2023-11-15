package com.example.battleships.service;


import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.CategoryType;

public interface CategoryService {
    Category findByCategory(CategoryType category);
}
