package com.simpoint_enterprice.simpoint.Repository;

import com.simpoint_enterprice.simpoint.Model.AssessmentQuestionLink;
import com.simpoint_enterprice.simpoint.Model.QuestionLinkId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentQuestionLinkRepository extends JpaRepository<AssessmentQuestionLink, QuestionLinkId> {
    List<AssessmentQuestionLink> findByAssessment_AssessmentId(Long assessmentId);
//
//    List<AssessmentQuestionLink> findByQuestion_QuestionId(Long questionId);
}
