package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonResponse {
    private Long id;
    private LocalDateTime publishDate;
    private String lessonName;
    private String lessonContent;
    private String status;
    private String slug;
    private LocalDateTime lastUpdate;
    private String tags;
    private String guid;
    private String videoUrl;

}
