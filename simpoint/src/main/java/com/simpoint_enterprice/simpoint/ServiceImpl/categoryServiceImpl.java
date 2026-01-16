package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.CategoryResponse;
import com.simpoint_enterprice.simpoint.Dto.SubcategoryResponse;
import com.simpoint_enterprice.simpoint.Dto.TopicCategoryResponse;
import com.simpoint_enterprice.simpoint.Model.Category;
import com.simpoint_enterprice.simpoint.Model.SubCategory;
import com.simpoint_enterprice.simpoint.Model.TopicCategory;
import com.simpoint_enterprice.simpoint.Repository.CategoryRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.CategoryService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class categoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;

    // Topic Mapper
    // =========================
    private TopicCategoryResponse mapToTopicResponse(TopicCategory topic) {
        TopicCategoryResponse response = new TopicCategoryResponse();

        response.setId(topic.getId());
        response.setTopicName(topic.getTopicName());
        response.setTopicDescription(topic.getTopicDescription());
        response.setShortCode(topic.getShortCode());

        // map subcategory name
        if (topic.getSubCategory() != null) {
            response.setSubCategoryName(
                    topic.getSubCategory().getSubcategoryName()
            );

            // map category name
            if (topic.getSubCategory().getCategory() != null) {
                response.setCategoryName(
                        topic.getSubCategory().getCategory().getCategoryName()
                );
            }
        }

        return response;
    }
// Subcategory mapper
    private SubcategoryResponse mapToSubcategoryResponse(SubCategory subCategory){
        SubcategoryResponse response = new SubcategoryResponse();
        response.setId(subCategory.getId());
        response.setSubcategoryName(subCategory.getSubcategoryName());
        response.setSubcategoryDescription(subCategory.getSubcategoryDescription());

        if (subCategory.getCategory() != null) {
            response.setCategoryName(
                    subCategory.getCategory().getCategoryName()
            );
        }

        if (subCategory.getTopicCategories() != null &&
                !subCategory.getTopicCategories().isEmpty()) {

            List<TopicCategoryResponse> topics =
                    subCategory.getTopicCategories()
                            .stream()
                            .map(this::mapToTopicResponse)
                            .toList();

            response.setTopicCategories(topics);
        }

        return response;

    }
    // CategoryMapper mapper
  private CategoryResponse mapToCategoryResponse(Category category){
        List<SubcategoryResponse>subcategoryResponses=
                 category.getSubCategories()==null
                 ? Collections.emptyList()
                         :category.getSubCategories()
                         .stream()
                         .map(this::mapToSubcategoryResponse)
                         .collect(Collectors.toList());

        return new CategoryResponse(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getDescription(),
                subcategoryResponses
        );

  }
//    @Override
//    public List<Category> getAllCategories() {
//        return categoryRepository.findAll();
//    }
@Override
public List<CategoryResponse> getAllCategories() {
        log.info("fetching all categories");
        List<Category>categories=categoryRepository.findAll();
        if(categories.isEmpty()){
            log.warn("No Category found in databases");
        }
    return categories.stream().map(this::mapToCategoryResponse)
            .collect(Collectors.toList());
}

//    @Override
//    public Category getCategoryById(Long id) {
//        return categoryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("No categories found with category id: " + id));
//    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        log.info("Fetching category with id: {}",id);

        Category category=categoryRepository.findById(id)
                .orElseThrow(() ->{
                    log.error("category not found with id:{}",id);
                    return new ResourceNotFoundException(
                            "category not found with id:" +id
                    );
                });
        log.debug("category fetch successfully:{}",category.getCategoryName());
        return mapToCategoryResponse(category);

    }
//    @Transactional
//    @Override
//    public Category saveCategory(Category category) {
//        return categoryRepository.save(category);
//    }
@Transactional
@Override
public CategoryResponse saveCategory(Category category) {
        log.info("saving category with name: {}",category.getCategoryName());
     Category savecategory=categoryRepository.save(category);
     log.info("category saved successfully with id: {}",savecategory.getCategoryId());
     return  mapToCategoryResponse(savecategory);
}

    @Override
    public CategoryResponse updateCategory(Long id, Category updateCategory) {

        log.info("updating category with id:{}",id);
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("can not update.Category not found with id:{}",id);
                    return new ResourceNotFoundException(
                       "category not found with id:" +id
                    );
                });

        existingCategory.setCategoryName(updateCategory.getCategoryName());
        existingCategory.setDescription(updateCategory.getDescription());

        Category savedCategory = categoryRepository.save(existingCategory);
        log.info("category updated successfully: {}",id);
        return mapToCategoryResponse(savedCategory);
    }

//    @Override
//    public Category updateCategory(Long id, Category updatedCategory) {
//        Category existingCategory = categoryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
//        existingCategory.setCategoryName(updatedCategory.getCategoryName());
//        existingCategory.setDescription(updatedCategory.getDescription());
//        return categoryRepository.save(existingCategory);
//    }


    @Override
    public void deleteCategory(Long id) {
        log.info("Deleting category with id: {}", id);

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Cannot delete. Category not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Category not found with id: " + id
                    );
                });

        categoryRepository.delete(category);

        log.info("Category deleted successfully with id: {}", id);
    }

    }




