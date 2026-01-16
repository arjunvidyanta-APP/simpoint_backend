package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResponse {
    private Long questionId;
    private String questionTitle;
    private String questionContent;
    private String questionType;
    private String answerType;
    private String answerData;
    private String status;
    private Long menuOrder;

    private String correctMsg;
    private String incorrectMsg;

    private Boolean correctSameText;
    private Boolean hintEnabled;
    private String hintMsg;

    private Long questionCategory;
    private LocalDateTime publishDate;
    private LocalDateTime lastUpdate;
    private Long createdById;
    private String createdByName;
    private Integer questionScore;
    private Double userScore;
}
