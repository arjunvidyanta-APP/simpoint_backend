package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Model.Category;
import com.simpoint_enterprice.simpoint.Repository.CategoryRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class categoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No categories found with category id: " + id));
    }

    @Transactional
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        existingCategory.setCategoryName(updatedCategory.getCategoryName());
        existingCategory.setDescription(updatedCategory.getDescription());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {

    }


}

