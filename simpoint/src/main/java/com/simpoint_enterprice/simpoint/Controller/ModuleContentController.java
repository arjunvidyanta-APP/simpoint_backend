package com.simpoint_enterprice.simpoint.Controller;

import com.simpoint_enterprice.simpoint.Dto.ModuleContentResponse;
import com.simpoint_enterprice.simpoint.Dto.ModuleResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.ModuleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/moduleContent")
public class ModuleContentController {
    @Autowired
    private ModuleContentService moduleContentService;

    @GetMapping
    ResponseEntity<List<ModuleContentResponse>> GetAllList() {
        log.info("Get/FetchAll- Fetch ALL Module content");
        List<ModuleContentResponse> moduleContent = moduleContentService.GetAllList();
        log.info("Get/Fetch- size of module Content:{}", moduleContent.size());
        return ResponseEntity.ok(moduleContent);
    }

    @GetMapping("/{id}")
    ResponseEntity<ModuleContentResponse> GetListById(@PathVariable  Long id) {
        log.info("Get/Fetch- Fetch All Module content with:{}", id);
        ModuleContentResponse moduleContetById = moduleContentService.GetById(id);
        log.info("Get/Fetch- Module Content find with id:{}", id);
        return ResponseEntity.ok(moduleContetById);
    }
}
