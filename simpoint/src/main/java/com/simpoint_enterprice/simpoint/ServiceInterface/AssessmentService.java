package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.AssessmentResponse;
import com.simpoint_enterprice.simpoint.Repository.AssessmentRepository;

import java.util.List;

public interface AssessmentService {
    List<AssessmentResponse> getAllList();
    AssessmentResponse getById(Long id,List<Long> selectedOptionIds);
}
