package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.ModuleContentResponse;

import java.util.List;

public interface ModuleContentService {
    List<ModuleContentResponse>GetAllList();
    ModuleContentResponse GetById(Long id);
    List<ModuleContentResponse> getLessonsByModuleId(Long moduleId);
}
