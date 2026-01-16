package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.CourseResponse;
import com.simpoint_enterprice.simpoint.Model.Course;
import com.simpoint_enterprice.simpoint.ServiceInterface.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/course")
public class CoursesController {

    @Autowired
     private CourseService courseService;

    @GetMapping
    ResponseEntity<List<CourseResponse>>findAllCourses(){
           log.info("Get/Course -Fetch all courses");
           List<CourseResponse>course=courseService.getAllCourse();
           log.info("Get/Course- course size:{}",course.size());
           return ResponseEntity.ok(course);
      }

      @GetMapping("{id}")

    ResponseEntity<CourseResponse>findCourseById(@PathVariable Long id){
        log.info("Get/Course- Fetch course with id:{}",id);
        CourseResponse course= courseService.getCourseById(id);
        log.info("Get/course- Fetch course with id:{}",id);
        return ResponseEntity.ok(course);
      }


}
