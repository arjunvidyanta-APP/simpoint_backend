package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicCategoryResponse {
    private Long id;
    private String topicName;
    private String topicDescription;
    private String shortCode;
    private String categoryName;
    private String subCategoryName;

}
