package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.SubcategoryResponse;
import com.simpoint_enterprice.simpoint.Model.SubCategory;

import java.util.List;

public interface SubCategoryService {
//     List<SubCategory>getAllSubCategories();
//     SubCategory getCategoryById(Long id);
      List<SubcategoryResponse>getAllSubcategories();
      SubcategoryResponse getCategoryById(Long id);
}
