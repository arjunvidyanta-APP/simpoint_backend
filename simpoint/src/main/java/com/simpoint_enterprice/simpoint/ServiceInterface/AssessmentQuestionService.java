package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.QuestionResponseDTO;

import java.util.List;

public interface AssessmentQuestionService {

    List<QuestionResponseDTO> getQuestionsByAssessment(Long assessmentId);
    List<QuestionResponseDTO> getAllLinkedQuestions();

//    void linkQuestionToAssessment(Long questionId, Long assessmentId);
}
