package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.LessonResponse;
import com.simpoint_enterprice.simpoint.Model.Lesson;
import com.simpoint_enterprice.simpoint.Repository.LessonRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.LessonService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    //mapper
    LessonResponse MaptoLesson(Lesson lesson) {
        LessonResponse response = new LessonResponse();
        response.setId(lesson.getId());
        response.setLessonName(lesson.getLessonName());
        response.setLessonContent(lesson.getLessonContent());
        response.setStatus(lesson.getStatus().name());
        response.setSlug(lesson.getSlug());
        response.setPublishDate(lesson.getPublishDate());
        response.setLastUpdate(lesson.getLastUpdate());
        response.setTags(lesson.getTags());
        response.setGuid(lesson.getGuid());
        response.setVideoUrl(lesson.getVideoUrl());
        return response;

    }

    @Override
    public List<LessonResponse> GetAllList() {
        log.info("Fetch All Lesson");
        List<Lesson> list = lessonRepository.findAll();
        if (list.isEmpty()) {
            log.warn("list is empty");
        }
        log.info("Total list Find:{}", list.size());
        return list.stream()
                .map(this::MaptoLesson)
                .toList();
    }

    @Override
    public LessonResponse GetById(Long id) {
        log.info("Fetch Lesson with id:{}", id);
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Lesson not found with id:{}", id);
                    return new ResourceNotFoundException(
                            "Lesson not found with id:" + id
                    );
                });


        return MaptoLesson(lesson);
    }
}
