package com.simpoint_enterprice.simpoint.Controller;


import com.simpoint_enterprice.simpoint.Dto.EditorResponse;
import com.simpoint_enterprice.simpoint.ServiceInterface.EditorService;
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
@RequestMapping("/editor")
public class EditorController {
    @Autowired
    private  EditorService editorService;

    @GetMapping
    ResponseEntity<List<EditorResponse>>getAllEditorList() {
        log.info("GET/Author -Fetch all Author");
        List<EditorResponse> editorResponses = editorService.getAllList();
        log.info("Fetch all Author List:{}", editorResponses.size());
        return ResponseEntity.ok(editorResponses);
    }

    @GetMapping("/{id}")
        ResponseEntity<EditorResponse>getEditorById(@PathVariable Long id){
            log.info("GET /Author/{} - Fetching category by id", id);
            EditorResponse editorResponse=editorService.getById(id);
            log.info("Get/Author/{} - Author Fetching successfull with id",id);
            return  ResponseEntity.ok(editorResponse);

        }

    }

