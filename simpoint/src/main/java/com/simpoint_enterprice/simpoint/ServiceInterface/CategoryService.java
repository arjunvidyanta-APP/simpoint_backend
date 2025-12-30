package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category saveCategory(Category category);

    Category updateCategory(Long id, Category updatedCategory);

    void deleteCategory(Long id);
}
