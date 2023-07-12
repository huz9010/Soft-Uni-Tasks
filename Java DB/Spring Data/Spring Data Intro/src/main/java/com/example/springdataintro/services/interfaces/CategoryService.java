package com.example.springdataintro.services.interfaces;

import com.example.springdataintro.enitities.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;
    Set<Category> getRandomCategories();
}
