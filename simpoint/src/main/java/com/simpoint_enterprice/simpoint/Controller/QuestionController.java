package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.QuestionResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    ResponseEntity<List<QuestionResponse>> getByAllQuestion() {
        log.info("Get/Question- Fetch all Question");
        List<QuestionResponse> questionList = questionService.getAllQuestion();
        log.info("Get/Question- size of questionList:{}", questionList.size());
        return ResponseEntity.ok(questionList);
    }

    @GetMapping("/{id}")
    ResponseEntity<QuestionResponse> getByIdQuestion(@PathVariable Long id) {
        log.info("Get/Question- Fetch Question with id: {}", id);
        QuestionResponse questionById = questionService.getByIdQuestion(id);
        return ResponseEntity.ok(questionById);
    }
}
