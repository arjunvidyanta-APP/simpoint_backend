package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseResponse {
    private Long id;

    private Long topicId;
    private Long createdBy;
    private Long lastEditedBy;
    private String CategoryName;
    private String SubCategoryName;
    private String TopicCategoryName;

    private LocalDateTime publishDate;
    private String courseDescription;
    private String courseTitle;
    private String status;
    private String slug;
    private LocalDateTime lastUpdate;
    private String guid;
    private Long courseDuration;
    private LocalDateTime startDate;
    private LocalDateTime enrollBy;
    private LocalDateTime endDate;
    private String certification;
    private String accreditedBy;
    private String tags;
    private String sectionIdentifier;
    private String shortCode;
    List<ModuleResponse> module;
}
