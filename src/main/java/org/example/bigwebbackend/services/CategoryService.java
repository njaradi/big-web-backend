package org.example.bigwebbackend.services;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.repositories.category.CategoryRepository;

import javax.inject.Inject;
import java.util.List;

public class CategoryService {
    @Inject
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {return this.categoryRepository.getAllCategories();}
    public Category createCategory(Category category) {return this.categoryRepository.createCategory(category);}

}
