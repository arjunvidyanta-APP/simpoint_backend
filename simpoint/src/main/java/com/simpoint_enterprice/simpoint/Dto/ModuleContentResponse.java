package com.simpoint_enterprice.simpoint.Dto;

import com.simpoint_enterprice.simpoint.Model.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ModuleContentResponse {
    private Long contentId;
    private Long moduleId;

    private ContentType contentType;

    private Long lessonId;
    private Long assessmentId;

    private Long menuOrder;
}
