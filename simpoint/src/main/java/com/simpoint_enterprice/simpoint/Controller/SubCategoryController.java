package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.SubcategoryResponse;
import com.simpoint_enterprice.simpoint.Model.Category;
import com.simpoint_enterprice.simpoint.Model.SubCategory;
import com.simpoint_enterprice.simpoint.ServiceInterface.SubCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ResourceBundle;

import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.SUBCATEGORY;
import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.SUBCATEGORY_ID;

@Slf4j
@RestController
@RequestMapping(SUBCATEGORY)
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    //    @GetMapping
//    public ResponseEntity<List<SubCategory>>getAllCategories(){
//
//        return ResponseEntity.ok(subCategoryService.getAllSubCategories());
//    }
    @GetMapping
    public ResponseEntity<List<SubcategoryResponse>> getAllCategories() {
        log.info("Get/subcategories- Fetching all subcategories");
        return ResponseEntity.ok(subCategoryService.getAllSubcategories());
    }

    // Get category by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<SubCategory>getSubcategoryById(@PathVariable Long id){
//        return ResponseEntity.ok(subCategoryService.getCategoryById(id));
//    }
    @GetMapping(SUBCATEGORY_ID)
    public ResponseEntity<SubcategoryResponse> getSubcategoryById(@PathVariable Long id) {
        log.info("Get/subcategory -Fetch subcategory by id: {}", id);
        return ResponseEntity.ok(subCategoryService.getCategoryById(id));
    }
}
