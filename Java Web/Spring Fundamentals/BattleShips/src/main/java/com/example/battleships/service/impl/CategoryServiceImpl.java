package com.example.battleships.service.impl;

import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.CategoryType;
import com.example.battleships.repository.CategoryRepository;
import com.example.battleships.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findByCategory(CategoryType category) {
        return this.categoryRepository.findByName(category);
    }
}
