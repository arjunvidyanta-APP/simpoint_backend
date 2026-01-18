package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.LessonResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.LessonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.LESSON;
import static com.simpoint_enterprice.simpoint.EndPoint.ApiEndpoints.LESSON_ID;

@Slf4j
@RestController
@RequestMapping(LESSON)
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping
    ResponseEntity<List<LessonResponse>>getAllLesson(){
       log.info("Get/Lesson- Fetch all list");
       List<LessonResponse>list=lessonService.GetAllList();
       log.info("Get/Lesson- size of Lesson:{}",list.size());
       return ResponseEntity.ok(list);
    }
    @GetMapping(LESSON_ID)
    ResponseEntity<LessonResponse>getLessonById(@PathVariable Long id){
         log.info("Get/Lesson- Fetch Lesson wit id:{}",id);
         LessonResponse listId=lessonService.GetById(id);
         return ResponseEntity.ok(listId);
    }
}
