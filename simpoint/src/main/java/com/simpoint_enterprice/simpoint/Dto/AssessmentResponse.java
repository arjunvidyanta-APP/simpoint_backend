package com.simpoint_enterprice.simpoint.Dto;

import com.simpoint_enterprice.simpoint.Model.AssessmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentResponse {
    private Long assessmentId;
    private String assessmentName;
    private String assessmentContent;
    private AssessmentStatus status;
    private String slug;
    private String guid;
    private LocalDateTime publishDate;
    private LocalDateTime lastUpdate;
    private List<QuestionResponse> questions;
}
