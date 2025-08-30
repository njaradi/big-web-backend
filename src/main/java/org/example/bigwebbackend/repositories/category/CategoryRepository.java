package org.example.bigwebbackend.repositories.category;

import org.example.bigwebbackend.entites.Category;
import org.example.bigwebbackend.entites.Comment;
import org.example.bigwebbackend.entites.Event;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getAllCategories();
    public Category createCategory(Category category);
}
