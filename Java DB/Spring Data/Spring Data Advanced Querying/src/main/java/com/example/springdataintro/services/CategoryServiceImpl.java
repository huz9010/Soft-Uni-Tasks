package com.example.springdataintro.services;

import com.example.springdataintro.enitities.Category;
import com.example.springdataintro.repositories.CategoryRepository;
import com.example.springdataintro.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final String CATEGORY_FILE_PATH = "src/main/resources/categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORY_FILE_PATH))
                .stream().filter(row -> !row.isEmpty())
                .forEach(row -> {
                    Category category = new Category(row);
                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories() {
        int categoriesCount = ThreadLocalRandom.current().nextInt(1, 3);

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < categoriesCount; i++) {
            long id = ThreadLocalRandom.current().nextLong(1, categoryRepository.count() + 1);
            categories.add(categoryRepository.findById(id).orElse(null));
        }
        return categories;
    }
}
