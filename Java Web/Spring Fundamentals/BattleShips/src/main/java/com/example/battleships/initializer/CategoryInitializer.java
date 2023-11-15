package com.example.battleships.initializer;

import com.example.battleships.domain.entity.CategoryType;
import com.example.battleships.domain.entity.Category;
import com.example.battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategoryInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryType.values())
                    .map(Category::new)
                    .toList();

            this.categoryRepository.saveAll(categories);
        }
    }
}
