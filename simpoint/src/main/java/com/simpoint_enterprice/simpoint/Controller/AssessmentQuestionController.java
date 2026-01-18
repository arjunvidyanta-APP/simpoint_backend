package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.QuestionResponseDTO;
import com.simpoint_enterprice.simpoint.ServiceInterface.AssessmentQuestionService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.ASSESSMENT_QUESTION;
import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.ASSESSMENT_QUESTION_BY_ASSESSMENT;

@RestController
@Slf4j
@RequestMapping(ASSESSMENT_QUESTION)
public class AssessmentQuestionController {


    @Autowired
    private AssessmentQuestionService assessmentQuestionService;


    /**
     * Get all Questions linked to an Assessment
     */
    @GetMapping(ASSESSMENT_QUESTION_BY_ASSESSMENT)
    ResponseEntity<List<QuestionResponseDTO>> getQuestionsByAssessment(@PathVariable Long assessmentId) {
        log.info("Get/Link- Fetch all Assessment with question Id");
        List<QuestionResponseDTO> QuestionResponsewithAssessment = assessmentQuestionService.getQuestionsByAssessment(assessmentId);
        log.info("Get/Link- Size of linkLIst: {}", assessmentId);
        return ResponseEntity.ok(QuestionResponsewithAssessment);
    }

    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> getAllLinkedQuestions() {

        log.info("Fetching all linked questions");

        List<QuestionResponseDTO> response =
                assessmentQuestionService.getAllLinkedQuestions();

        log.info("Total linked questions: {}", response.size());

        return ResponseEntity.ok(response);
    }
}
