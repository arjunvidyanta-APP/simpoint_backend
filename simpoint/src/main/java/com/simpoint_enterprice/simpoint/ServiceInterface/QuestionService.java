package com.simpoint_enterprice.simpoint.ServiceInterface;


import com.simpoint_enterprice.simpoint.Dto.QuestionResponse;

import java.util.List;

public interface QuestionService {
  List<QuestionResponse> getAllQuestion();
  QuestionResponse getByIdQuestion(Long id);
}
