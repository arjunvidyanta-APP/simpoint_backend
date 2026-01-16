package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.CategoryResponse;
import com.simpoint_enterprice.simpoint.Model.Category;

import java.util.List;

public interface CategoryService {
//    List<Category> getAllCategories();
      List<CategoryResponse>getAllCategories();
//    Category getCategoryById(Long id);
      CategoryResponse getCategoryById(Long id);
//    Category saveCategory(Category category);
      CategoryResponse saveCategory(Category category);
//    Category updateCategory(Long id, Category updatedCategory);
      CategoryResponse updateCategory(Long id,Category updateCategory);
    void deleteCategory(Long id);
}
