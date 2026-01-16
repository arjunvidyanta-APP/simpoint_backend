package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleResponse {

    private Long id;
    private String moduleName;
    private String moduleDescription;

    private Long courseId;

    private Long menuOrder;
    private String status;

    private LocalDateTime publishDate;
    private LocalDateTime lastUpdate;

    private String guid;
    private String slug;
    private List<LessonResponse> lessons;
    private List<AssessmentResponse> assessments;
}
