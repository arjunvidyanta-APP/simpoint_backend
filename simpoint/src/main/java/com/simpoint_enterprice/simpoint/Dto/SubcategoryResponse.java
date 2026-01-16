package com.simpoint_enterprice.simpoint.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubcategoryResponse {
    private Long id;
    private String subcategoryName;
    private String subcategoryDescription;
    private String categoryName;
    private List<TopicCategoryResponse>topicCategories;

}
