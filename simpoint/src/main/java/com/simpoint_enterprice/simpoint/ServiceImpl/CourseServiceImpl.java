package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.AssessmentResponse;
import com.simpoint_enterprice.simpoint.Dto.CourseResponse;
import com.simpoint_enterprice.simpoint.Dto.LessonResponse;
import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;
import com.simpoint_enterprice.simpoint.Model.Assessment;
import com.simpoint_enterprice.simpoint.Model.Course;
import com.simpoint_enterprice.simpoint.Model.Lesson;
import com.simpoint_enterprice.simpoint.Model.Modules;
import com.simpoint_enterprice.simpoint.Repository.CourseRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.CourseService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;


    // Assessment mapper
    private AssessmentResponse mapAssessment(Assessment assessment) {
        AssessmentResponse as = new AssessmentResponse();
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
    // mapper
//    private CourseResponse mapToCourseResponse(Course course) {
//
//         CourseResponse response =new CourseResponse();
//        response.setId(course.getId());
//        response.setPublishDate(course.getPublishDate());
//        response.setCourseDescription(course.getCourseDescription());
//        response.setCourseTitle(course.getCourseTitle());
//        response.setStatus(course.getStatus().name());
//        response.setSlug(course.getSlug());
//        response.setLastUpdate(course.getLastUpdate());
//        response.setGuid(course.getGuid());
//        response.setCourseDuration(course.getCourseDuration());
//        response.setStartDate(course.getStartDate());
//        response.setEnrollBy(course.getEnrollBy());
//        response.setEndDate(course.getEndDate());
//        response.setCertification(course.getCertificationStatus().name());
//        response.setAccreditedBy(course.getAccreditedBy());
//        response.setTags(course.getTags());
//        response.setSectionIdentifier(course.getSectionIdentifier());
//        response.setShortCode(course.getShortCode());
//        response.setCreatedBy(
//                course.getCreatedBy()!=null?course.getCreatedBy().getEditorId():null
//        );
//        // get Topic Id
//        response.setTopicId(
//                course.getTopicCategory()!=null?course.getTopicCategory().getId():null
//        );
//        // accrediated
//        response.setAccreditedBy(course.getAccreditedBy()!=null? course.getAccreditedBy():null);
//        //last updated
//        response.setLastEditedBy(course.getLastEditedBy()!=null? course.getLastEditedBy().getEditorId():null);
//        // topic and category and subcategory name
//        if(course.getTopicCategory()!=null){
//            response.setTopicCategoryName(course.getTopicCategory().getTopicName());
//        }
//        if(course.getTopicCategory().getSubCategory()!=null){
//            response.setSubCategoryName(course.getTopicCategory().getSubCategory().getSubcategoryName());
//        }
//        if(course.getTopicCategory().getSubCategory().getCategory()!=null){
//            response.setCategoryName(course.getTopicCategory().getSubCategory().getCategory().getCategoryName());
//        }
//        //List of Modules
//        if(course.getModules()!=null){
//            response.setModule(
//                    course.getModules().stream().map(m -> {
//                        ModuleResponse mr = new ModuleResponse();
//                        mr.setId(m.getId());
//                        mr.setModuleName(m.getModuleName());
//                        mr.setModuleDescription(m.getModuleDescription());
//                        mr.setMenuOrder(m.getMenuOrder());
//                        mr.setStatus(m.getStatus().name());
//                        mr.setCourseId(m.getCourse()!=null?m.getCourse().getId():null);
//                        mr.setPublishDate(m.getPublishDate()!=null?m.getPublishDate():null);
//                        mr.setSlug(m.getSlug()!=null?m.getSlug():null);
//                        return mr;
//                    }).toList()
//            );
//        }

    //        return response;
//    }
//    private CourseResponse mapToCourseResponse(Course course) {
//
//        CourseResponse response = new CourseResponse();
//        response.setId(course.getId());
//        response.setPublishDate(course.getPublishDate());
//        response.setCourseDescription(course.getCourseDescription());
//        response.setCourseTitle(course.getCourseTitle());
//        response.setStatus(course.getStatus().name());
//        response.setSlug(course.getSlug());
//        response.setLastUpdate(course.getLastUpdate());
//        response.setGuid(course.getGuid());
//        response.setCourseDuration(course.getCourseDuration());
//        response.setStartDate(course.getStartDate());
//        response.setEnrollBy(course.getEnrollBy());
//        response.setEndDate(course.getEndDate());
//        response.setCertification(course.getCertificationStatus().name());
//        response.setAccreditedBy(course.getAccreditedBy());
//        response.setTags(course.getTags());
//        response.setSectionIdentifier(course.getSectionIdentifier());
//        response.setShortCode(course.getShortCode());
//        response.setCreatedBy(
//                course.getCreatedBy() != null ? course.getCreatedBy().getEditorId() : null
//        );
//
//        // Topic and category info
//        if (course.getTopicCategory() != null) {
//            response.setTopicId(course.getTopicCategory().getId());
//            response.setTopicCategoryName(course.getTopicCategory().getTopicName());
//            if (course.getTopicCategory().getSubCategory() != null) {
//                response.setSubCategoryName(course.getTopicCategory().getSubCategory().getSubcategoryName());
//                if (course.getTopicCategory().getSubCategory().getCategory() != null) {
//                    response.setCategoryName(course.getTopicCategory().getSubCategory().getCategory().getCategoryName());
//                }
//            }
//        }
//
//        // Last edited info
//        response.setLastEditedBy(course.getLastEditedBy() != null ? course.getLastEditedBy().getEditorId() : null);
//
//        // List of Modules with Lessons and Assessments
//        if (course.getModules() != null) {
//            response.setModule(
//                    course.getModules().stream().map(m -> {
//                        ModuleResponse mr = new ModuleResponse();
//                        mr.setId(m.getId());
//                        mr.setModuleName(m.getModuleName());
//                        mr.setModuleDescription(m.getModuleDescription());
//                        mr.setMenuOrder(m.getMenuOrder());
//                        mr.setStatus(m.getStatus().name());
//                        mr.setCourseId(m.getCourse() != null ? m.getCourse().getId() : null);
//                        mr.setPublishDate(m.getPublishDate());
//                        mr.setLastUpdate(m.getLastUpdate());
//                        mr.setGuid(m.getGuid());
//                        mr.setSlug(m.getSlug());
//
//                        // Include Lessons
//                        if (m.getModuleContents() != null) {
//                            mr.setLessons(
//                                    m.getModuleContents().stream()
//                                            .filter(mc -> mc.getLesson() != null)
//                                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
//                                            .map(mc -> mapLesson(mc.getLesson()))
//                                            .toList()
//                            );
//
//                            // Include Assessments
//                            mr.setAssessments(
//                                    m.getModuleContents().stream()
//                                            .filter(mc -> mc.getAssessment() != null)
//                                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
//                                            .map(mc -> mapAssessment(mc.getAssessment()))
//                                            .toList()
//                            );
//                        }
//
//                        return mr;
//                    }).toList()
//            );
//        }
//
//        return response;
//    }

    //    private CourseResponse mapToCourseResponse(Course course) {
//
//        CourseResponse response = new CourseResponse();
//        response.setId(course.getId());
//        response.setCourseTitle(course.getCourseTitle());
//        response.setCourseDescription(course.getCourseDescription());
//        response.setStatus(course.getStatus().name());
//        response.setSlug(course.getSlug());
//        response.setPublishDate(course.getPublishDate());
//        response.setLastUpdate(course.getLastUpdate());
//        response.setGuid(course.getGuid());
//        response.setCourseDuration(course.getCourseDuration());
//        response.setStartDate(course.getStartDate());
//        response.setEnrollBy(course.getEnrollBy());
//        response.setEndDate(course.getEndDate());
//        response.setCertification(course.getCertificationStatus().name());
//        response.setAccreditedBy(course.getAccreditedBy());
//        response.setTags(course.getTags());
//        response.setSectionIdentifier(course.getSectionIdentifier());
//        response.setShortCode(course.getShortCode());
//        response.setCreatedBy(course.getCreatedBy() != null ? course.getCreatedBy().getEditorId() : null);
//        response.setLastEditedBy(course.getLastEditedBy() != null ? course.getLastEditedBy().getEditorId() : null);
//
//        // Topic and Category Info
//        if (course.getTopicCategory() != null) {
//            response.setTopicId(course.getTopicCategory().getId());
//            response.setTopicCategoryName(course.getTopicCategory().getTopicName());
//            if (course.getTopicCategory().getSubCategory() != null) {
//                response.setSubCategoryName(course.getTopicCategory().getSubCategory().getSubcategoryName());
//                if (course.getTopicCategory().getSubCategory().getCategory() != null) {
//                    response.setCategoryName(course.getTopicCategory().getSubCategory().getCategory().getCategoryName());
//                }
//            }
//        }
//
//        // Modules with Lessons and Assessments
//        if (course.getModules() != null) {
//            response.setModule(
//                    course.getModules().stream().map(m -> {
//                        ModuleResponse mr = new ModuleResponse();
//                        mr.setId(m.getId());
//                        mr.setModuleName(m.getModuleName());
//                        mr.setModuleDescription(m.getModuleDescription());
//                        mr.setMenuOrder(m.getMenuOrder());
//                        mr.setStatus(m.getStatus().name());
//                        mr.setCourseId(m.getCourse() != null ? m.getCourse().getId() : null);
//                        mr.setPublishDate(m.getPublishDate());
//                        mr.setLastUpdate(m.getLastUpdate());
//                        mr.setGuid(m.getGuid());
//                        mr.setSlug(m.getSlug());
//
//                        // Lessons
//                        if (m.getModuleContents() != null) {
//                            mr.setLessons(
//                                    m.getModuleContents().stream()
//                                            .filter(mc -> mc.getLesson() != null)
//                                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
//                                            .map(mc -> mapLesson(mc.getLesson()))
//                                            .toList()
//                            );
//
//                            // Assessments
//                            mr.setAssessments(
//                                    m.getModuleContents().stream()
//                                            .filter(mc -> mc.getAssessment() != null)
//                                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
//                                            .map(mc -> mapAssessment(mc.getAssessment()))
//                                            .toList()
//                            );
//                        }
//
//                        return mr;
//                    }).toList()
//            );
//        }
//
//        return response;
//    }
    private CourseResponse mapToCourseResponse(Course course) {

        CourseResponse response = new CourseResponse();
        response.setId(course.getId());
        response.setCourseTitle(course.getCourseTitle());
        response.setCourseDescription(course.getCourseDescription());
        response.setStatus(course.getStatus().name());
        response.setSlug(course.getSlug());
        response.setPublishDate(course.getPublishDate());
        response.setLastUpdate(course.getLastUpdate());
        response.setGuid(course.getGuid());
        response.setCourseDuration(course.getCourseDuration());
        response.setStartDate(course.getStartDate());
        response.setEnrollBy(course.getEnrollBy());
        response.setEndDate(course.getEndDate());
        response.setCertification(course.getCertificationStatus().name());
        response.setAccreditedBy(course.getAccreditedBy());
        response.setTags(course.getTags());
        response.setSectionIdentifier(course.getSectionIdentifier());
        response.setShortCode(course.getShortCode());
        response.setCreatedBy(course.getCreatedBy() != null ? course.getCreatedBy().getEditorId() : null);
        response.setLastEditedBy(course.getLastEditedBy() != null ? course.getLastEditedBy().getEditorId() : null);

        // Topic and Category Info
        if (course.getTopicCategory() != null) {
            response.setTopicId(course.getTopicCategory().getId());
            response.setTopicCategoryName(course.getTopicCategory().getTopicName());
            if (course.getTopicCategory().getSubCategory() != null) {
                response.setSubCategoryName(course.getTopicCategory().getSubCategory().getSubcategoryName());
                if (course.getTopicCategory().getSubCategory().getCategory() != null) {
                    response.setCategoryName(course.getTopicCategory().getSubCategory().getCategory().getCategoryName());
                }
            }
        }

        // Modules with Lessons and Assessments
        if (course.getModules() != null) {
            response.setModule(
                    course.getModules().stream()
                            .sorted((m1, m2) -> m1.getMenuOrder().compareTo(m2.getMenuOrder()))
                            .map(this::moduleMap) // use moduleMap for each module
                            .toList()
            );
        }

        return response;
    }

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

        // Lessons in this module
        if (modules.getModuleContents() != null) {
            response.setLessons(
                    modules.getModuleContents().stream()
                            .filter(mc -> mc.getLesson() != null)
                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
                            .map(mc -> mapLesson(mc.getLesson()))
                            .toList()
            );
        }

        // Assessments in this module
        if (modules.getModuleContents() != null) {
            response.setAssessments(
                    modules.getModuleContents().stream()
                            .filter(mc -> mc.getAssessment() != null)
                            .sorted((a, b) -> a.getMenuOrder().compareTo(b.getMenuOrder()))
                            .map(mc -> mapAssessment(mc.getAssessment()))
                            .toList()
            );
        }

        return response;
    }

    @Override
    public List<CourseResponse> getAllCourse() {
        log.info("Fetch all Course");
        List<Course> course = courseRepository.findAllWithRelations();
        log.info("Total courses found: {}", course.size());
        return course.stream()
                .map(this::mapToCourseResponse)
                .toList();

    }

    @Override
    public CourseResponse getCourseById(Long id) {
        log.info("Fetching course with id: {}", id);
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Course not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Course not found with id: " + id
                    );
                });

        log.info("Course found with id: {}", id);

        return mapToCourseResponse(course);
    }
}
