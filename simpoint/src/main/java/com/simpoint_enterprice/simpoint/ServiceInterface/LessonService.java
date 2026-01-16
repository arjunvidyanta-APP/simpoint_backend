package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.LessonResponse;

import java.util.List;

public interface LessonService {

      List<LessonResponse> GetAllList();
      LessonResponse GetById(Long id);
}
