package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;
import com.simpoint_enterprice.simpoint.Dto.QuestionResponse;
import com.simpoint_enterprice.simpoint.Model.Modules;
import com.simpoint_enterprice.simpoint.Model.Question;
import com.simpoint_enterprice.simpoint.Repository.QuestionRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.QuestionService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    private QuestionResponse mapToQuestionResponse(Question question) {

        QuestionResponse response = new QuestionResponse();

        response.setQuestionId(question.getQuestionId());
        response.setQuestionTitle(question.getQuestionTitle());
        response.setQuestionContent(question.getQuestionContent());
        response.setQuestionType(question.getQuestionType());
        response.setAnswerType(question.getAnswerType().name());
        response.setAnswerData(question.getAnswerData());
        response.setStatus(question.getStatus().name());
        response.setMenuOrder(question.getMenuOrder());

        response.setCorrectMsg(question.getCorrectMsg());
        response.setIncorrectMsg(question.getIncorrectMsg());
        response.setCorrectSameText(question.getCorrectSameText());
        response.setHintEnabled(question.getHintEnabled());
        response.setHintMsg(question.getHintMsg());

        response.setQuestionCategory(question.getQuestionCategory());
        response.setPublishDate(question.getPublishDate());
        response.setLastUpdate(question.getLastUpdate());
        if (question.getCreatedBy() != null) {
            response.setCreatedById(question.getCreatedBy().getEditorId());
            response.setCreatedByName(question.getCreatedBy().getEditorName());

        }
        return response;
    }

    @Override
    public List<QuestionResponse> getAllQuestion() {
        log.info("Fetch all Questions");
        List<Question> list_of_question = questionRepository.findAll();
        log.info("All Question size: " + list_of_question.size());
        if (list_of_question.isEmpty()) {
            log.warn("question is blank");
        }
        return list_of_question.stream().map(this::mapToQuestionResponse).toList();
    }


    @Override
    public QuestionResponse getByIdQuestion(Long id) {
        log.info("Fetch question with id:{}", +id);
        Question list_of_questionById = questionRepository.findById(id)
                .orElseThrow(() -> {
                    return new ResourceNotFoundException(
                            "Question not found with id: " + id
                    );
                });
        log.info("Question found with id: {}", id);
        return mapToQuestionResponse(list_of_questionById);
    }
}
