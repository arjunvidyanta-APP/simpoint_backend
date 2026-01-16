package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourse();
    CourseResponse getCourseById(Long id);
}
