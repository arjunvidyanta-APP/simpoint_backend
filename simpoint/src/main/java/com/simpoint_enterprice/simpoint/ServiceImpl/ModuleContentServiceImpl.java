package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.ModuleContentResponse;
import com.simpoint_enterprice.simpoint.Model.ModuleContent;
import com.simpoint_enterprice.simpoint.Repository.ModuleContentRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.ModuleContentService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ModuleContentServiceImpl implements ModuleContentService {
    @Autowired
    private ModuleContentRepository moduleContentRepository;

    //mapper
    ModuleContentResponse maptoModuleContent(ModuleContent content) {
        return ModuleContentResponse.builder()
                .contentId(content.getContentId())
                .moduleId(
                        content.getModule() != null
                                ? content.getModule().getId()
                                : null
                )
                .contentType(content.getContentType())
                .lessonId(
                        content.getLesson() != null
                                ? content.getLesson().getId()
                                : null
                )
                .assessmentId(
                        content.getAssessment() != null
                                ? content.getAssessment().getAssessmentId()
                                : null
                )
                .menuOrder(content.getMenuOrder())
                .build();

    }

    @Override
    public List<ModuleContentResponse> GetAllList() {

        log.info("Get all list");
        List<ModuleContent> moduleContentList = moduleContentRepository.findAll();
        log.info("ModuleContentList size:", moduleContentList.size());
        return moduleContentList.stream()
                .map(this::maptoModuleContent).toList();

    }

    @Override
    public ModuleContentResponse GetById(Long id) {
        log.info("ModuleContent found  with id:{}", id);
        ModuleContent moduleContent = moduleContentRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("ModuleContent not foudn with id:{}", id);
                    return new ResourceNotFoundException(
                            "moduleContent not found with id:" + id
                    );

                });
        log.info("moduleContent successfully  find with id");
        return maptoModuleContent(moduleContent);
    }
    @Override
    public List<ModuleContentResponse> getLessonsByModuleId(Long moduleId) {
        log.info("Fetching lessons for moduleId: {}", moduleId);

        return moduleContentRepository.findLessonsByModuleId(moduleId)
                .stream()
                .map(this::maptoModuleContent)
                .toList();
    }
}
