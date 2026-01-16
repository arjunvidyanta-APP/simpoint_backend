package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.QuestionResponseDTO;
import com.simpoint_enterprice.simpoint.Model.Assessment;
import com.simpoint_enterprice.simpoint.Model.AssessmentQuestionLink;
import com.simpoint_enterprice.simpoint.Model.Question;
import com.simpoint_enterprice.simpoint.Model.QuestionLinkId;
import com.simpoint_enterprice.simpoint.Repository.AssessmentQuestionLinkRepository;
import com.simpoint_enterprice.simpoint.Repository.AssessmentRepository;
import com.simpoint_enterprice.simpoint.Repository.QuestionRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.AssessmentQuestionService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AssessmentQuestionServiceImpl implements AssessmentQuestionService {
    @Autowired
    private  AssessmentQuestionLinkRepository linkRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AssessmentRepository assessmentRepository;


    // mapper
    private QuestionResponseDTO mapToDto(AssessmentQuestionLink link) {

        Question q = link.getQuestion();

        QuestionResponseDTO dto = new QuestionResponseDTO();
        dto.setQuestionId(q.getQuestionId());
        dto.setQuestionTitle(q.getQuestionTitle());
        dto.setQuestionContent(q.getQuestionContent());
        dto.setQuestionType(q.getQuestionType());

        if (q.getCreatedBy() != null) {
            dto.setEditorName(q.getCreatedBy().getEditorName());
        }

        return dto;
    }
    @Override
    public List<QuestionResponseDTO> getQuestionsByAssessment(Long assessmentId) {

        return linkRepository.findByAssessment_AssessmentId(assessmentId)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<QuestionResponseDTO> getAllLinkedQuestions() {
        log.info("Fetching all linked questions");

        return linkRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
