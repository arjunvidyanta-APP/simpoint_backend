package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.AssessmentResponse;
import com.simpoint_enterprice.simpoint.Dto.LessonResponse;
import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;
import com.simpoint_enterprice.simpoint.Model.Assessment;
import com.simpoint_enterprice.simpoint.Model.Lesson;
import com.simpoint_enterprice.simpoint.Repository.ModuleRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.ModuleService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simpoint_enterprice.simpoint.Model.Modules;

import java.util.List;

@Service
@Slf4j
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    // Assessment mapper
    private AssessmentResponse mapAssessment(Assessment assessment){
        AssessmentResponse as=new AssessmentResponse();
        as.setAssessmentId(assessment.getAssessmentId());
        as.setAssessmentName(assessment.getAssessmentName());
        as.setAssessmentContent(assessment.getAssessmentContent());
        as.setStatus(assessment.getStatus());
        as.setSlug(assessment.getSlug());
        as.setGuid(assessment.getGuid());
        as.setPublishDate(assessment.getPublishDate());
        as.setLastUpdate(assessment.getLastUpdate());
        return as;
    }
    // Lesson mapper
    private LessonResponse mapLesson(Lesson lesson) {
        LessonResponse lr = new LessonResponse();
        lr.setId(lesson.getId());
        lr.setLessonName(lesson.getLessonName());
        lr.setLessonContent(lesson.getLessonContent());
        lr.setPublishDate(lesson.getPublishDate());
        lr.setLastUpdate(lesson.getLastUpdate());
        lr.setStatus(lesson.getStatus().name());
        lr.setSlug(lesson.getSlug());
        lr.setTags(lesson.getTags());
        lr.setGuid(lesson.getGuid());
        lr.setVideoUrl(lesson.getVideoUrl());
        return lr;
    }
    //Module Mapper
    private ModuleResponse moduleMap(Modules modules) {
        ModuleResponse response = new ModuleResponse();
        response.setId(modules.getId());
        response.setModuleName(modules.getModuleName());
        response.setModuleDescription(modules.getModuleDescription());
        response.setMenuOrder(modules.getMenuOrder());
        response.setStatus(modules.getStatus().name());
        response.setPublishDate(modules.getPublishDate());
        response.setLastUpdate(modules.getLastUpdate());
        response.setGuid(modules.getGuid());
        response.setSlug(modules.getSlug());
        if (modules.getCourse() != null) {
            response.setCourseId(modules.getCourse().getId());
        }
       // Lesson
        if(modules.getModuleContents()!=null){
           response.setLessons(
                   modules.getModuleContents().stream()
                           .filter(mc -> mc.getLesson() != null)
                           .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
                           .map(mc -> mapLesson(mc.getLesson()))
                           .toList()
           );
       }
       //assessment
        response.setAssessments(
                modules.getModuleContents().stream()
                        .filter(mc -> mc.getAssessment() != null)
                        .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
                        .map(mc -> mapAssessment(mc.getAssessment()))
                        .toList()
        );

       return response;

    }

    @Override
    public List<ModuleResponse> GetAllList() {
        log.info("Fetch all Module");
        List<Modules> modules = moduleRepository.findAll();
        if (modules.isEmpty()) {
            log.warn("no module find");
        }
        return modules.stream()
                .map(this::moduleMap).toList();

    }

    @Override
    public ModuleResponse GetById(Long id) {
        log.info("Fetching Module with id: {}", id);

        Modules module = moduleRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Module not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Module not found with id: " + id
                    );
                });

        log.info("Module found with id: {}", id);
        return moduleMap(module);
    }
}
