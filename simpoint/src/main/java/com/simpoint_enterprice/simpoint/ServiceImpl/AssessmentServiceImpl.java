package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simpoint_enterprice.simpoint.Dto.AnswerData;
import com.simpoint_enterprice.simpoint.Dto.AnswerOption;
import com.simpoint_enterprice.simpoint.Dto.AssessmentResponse;
import com.simpoint_enterprice.simpoint.Dto.QuestionResponse;
import com.simpoint_enterprice.simpoint.Model.Assessment;
import com.simpoint_enterprice.simpoint.Model.AssessmentQuestionLink;
import com.simpoint_enterprice.simpoint.Model.Question;
import com.simpoint_enterprice.simpoint.Repository.AssessmentRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.AssessmentService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
   private AssessmentRepository assessmentRepository;

    public double calculateScore(String answerDataJson, List<Long> selectedOptionIds) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            AnswerData answerData = objectMapper.readValue(answerDataJson, AnswerData.class);
            double score = 0;
            for (AnswerOption option : answerData.getOptions()) {
                if (selectedOptionIds.contains(option.getId()) && Boolean.TRUE.equals(option.getCorrect())) {
                    score += option.getPoints();
                }
            }
            return score;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // QUESTION MAPPER
    private QuestionResponse mapQuestion(AssessmentQuestionLink ql,List<Long> selectedOptionIds) {

        Question q = ql.getQuestion();
        QuestionResponse qr = new QuestionResponse();

        qr.setQuestionId(q.getQuestionId());
        qr.setQuestionTitle(q.getQuestionTitle());
        qr.setQuestionContent(q.getQuestionContent());
        qr.setQuestionScore(ql.getQuestionScore());

        // set all other properties
        qr.setQuestionType(q.getQuestionType());
        qr.setAnswerType(q.getQuestionType());

        qr.setAnswerData(q.getAnswerData());

//        qr.setStatus(q.getStatus());
        qr.setMenuOrder(q.getMenuOrder());
        qr.setCorrectMsg(q.getCorrectMsg());
        qr.setIncorrectMsg(q.getIncorrectMsg());
        qr.setCorrectSameText(q.getCorrectSameText());
        qr.setHintEnabled(q.getHintEnabled());
        qr.setHintMsg(q.getHintMsg());
//        qr.setQuestionCategory(q.getQuestionCategory() != null ? q.getQuestionCategory(). : null);
        qr.setPublishDate(q.getPublishDate());
        qr.setLastUpdate(q.getLastUpdate());
//        qr.setCreatedById(q.getCreatedBy() != null ? q.getCreatedBy().getId() : null);
//        qr.setCreatedByName(q.getCreatedBy() != null ? q.getCreatedBy().getName() : null);
        if (selectedOptionIds != null && !selectedOptionIds.isEmpty()) {
            qr.setUserScore(calculateScore(ql.getQuestion().getAnswerData(), selectedOptionIds));
        }

        return qr;
    }
    //mapper assessment

    private AssessmentResponse maptoAssess(Assessment assessment,  boolean includeQuestions, List<Long> selectedOptionIds) {

    AssessmentResponse ar = new AssessmentResponse();
    ar.setAssessmentId(assessment.getAssessmentId());
    ar.setAssessmentName(assessment.getAssessmentName());
    ar.setAssessmentContent(assessment.getAssessmentContent());
    ar.setGuid(assessment.getGuid());
    ar.setStatus(assessment.getStatus());
    ar.setLastUpdate(assessment.getLastUpdate());

    //  include questions only when required
    if (includeQuestions && assessment.getQuestionLinks() != null) {
        ar.setQuestions(
                assessment.getQuestionLinks()
                        .stream()
                        .map(ql -> mapQuestion(ql, selectedOptionIds))
                        .toList()
        );
    }

    return ar;
}

    @Override
    public List<AssessmentResponse> getAllList() {
        log.info("Fetch all assessment");
        List<Assessment> assessments = assessmentRepository.findAll();
        if (assessments.isEmpty()) {
            log.warn("No assessments found");
        }

        return assessments.stream()
                .map(a->maptoAssess(a,true,null))
                .toList();
    }

    @Override
    public AssessmentResponse getById(Long id,List<Long> selectedOptionIds) {
        log.info("Find assessment wit id:{}",id);
        Assessment assessment=assessmentRepository.findAssessmentWithQuestions(id)
                .orElseThrow(()->{
                        log.warn("assessment not found with this id:{}",id);
                        return new ResourceNotFoundException(
                                 "assessment not found with this id:"+id
                        );
                });
        log.info("Assessment successfully found  with id:{}",id);
        return maptoAssess(assessment,true,selectedOptionIds);


    }
}
