package com.simpoint_enterprice.simpoint.Controller;


import com.simpoint_enterprice.simpoint.Dto.CategoryResponse;
import com.simpoint_enterprice.simpoint.Model.Category;
import com.simpoint_enterprice.simpoint.ServiceInterface.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Get all existing categories
//    @GetMapping
//    public ResponseEntity<List<Category>> getAllCategories() {
//        return ResponseEntity.ok(categoryService.getAllCategories());
//    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>>getAllCategories(){
        log.info("GET/Category -Fetch all categories");
        List<CategoryResponse>responses=categoryService.getAllCategories();
        log.info("Get/category- Total category found:{}",responses.size());
        return ResponseEntity.ok(responses);

    }

    // Get category by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
//        return ResponseEntity.ok(categoryService.getCategoryById(id));
//    }
     @GetMapping("/{id}")
     public ResponseEntity<CategoryResponse>getCategoryById(@PathVariable Long id){
         log.info("GET /category/{} - Fetching category by id", id);
         CategoryResponse response = categoryService.getCategoryById(id);
         log.info("GET /category/{} - Category fetched successfully", id);
        return ResponseEntity.ok(response);
     }
    // Create new Category (with or without subcategories)
//    @PostMapping
//    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
//        Category savedCategory = categoryService.saveCategory(category);
//        return ResponseEntity.ok(savedCategory);
//    }
     @PostMapping
     public ResponseEntity<CategoryResponse>creteCategory(@RequestBody Category category){
         log.info("POST /category - Creating category with name: {}",
                 category.getCategoryName());
        CategoryResponse saved=categoryService.saveCategory(category);
         log.info("POST /category - Category created successfully with id: {}",
                 saved.getCategoryId());
        return ResponseEntity.ok(saved);
     }

    //update existing category
//    @PutMapping("/{id}")
//    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
//        Category category = categoryService.updateCategory(id, updatedCategory);
//        return ResponseEntity.ok(category);
//    }
     @PutMapping("/{id}")
     public ResponseEntity<CategoryResponse>updateCategory(@PathVariable Long id,@RequestBody Category updateCategory){
         log.info("PUT /category/{} - Updating category", id);
        CategoryResponse category=categoryService.updateCategory(id,updateCategory);
         log.info("PUT /category/{} - Category updated successfully", id);
        return ResponseEntity.ok(category);
     }
    // Delete category by categoryId
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.warn("DELETE /category/{} - Deleting category", id);
        categoryService.deleteCategory(id);
        log.info("DELETE /category/{} - Category deleted successfully", id);
        return ResponseEntity.noContent().build();
    }

}
