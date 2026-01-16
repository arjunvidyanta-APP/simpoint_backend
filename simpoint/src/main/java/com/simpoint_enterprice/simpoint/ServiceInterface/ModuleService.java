package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;

import java.util.List;

public interface ModuleService {
    List<ModuleResponse> GetAllList();
    ModuleResponse GetById(Long id);
}
