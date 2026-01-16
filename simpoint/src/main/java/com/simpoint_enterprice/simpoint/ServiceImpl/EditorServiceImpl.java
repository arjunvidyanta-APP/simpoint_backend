package com.simpoint_enterprice.simpoint.ServiceImpl;

import com.simpoint_enterprice.simpoint.Dto.EditorResponse;
import com.simpoint_enterprice.simpoint.Model.Editor;
import com.simpoint_enterprice.simpoint.Repository.EditorRepository;
import com.simpoint_enterprice.simpoint.ServiceInterface.EditorService;
import com.simpoint_enterprice.simpoint.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EditorServiceImpl implements EditorService {

    @Autowired
    private EditorRepository editorRepository;

    //mapper
    private EditorResponse mapToEditorResponse(Editor editor) {
        return new EditorResponse(
                editor.getEditorId(),
                editor.getEditorName(),
                editor.getEditorEmail(),
                editor.getFirstName(),
                editor.getLastName(),
                editor.getPhoneNumber()
        );
    }

    @Override
    public List<EditorResponse> getAllList() {
        log.info("Fetch All author List");
         List<Editor>editors =editorRepository.findAll();
         log.info("fetch all editor list:{}",editors.size());
         return editors.stream()
                 .map(this::mapToEditorResponse).toList();
    }

    @Override
    public EditorResponse getById(Long id) {
         log.info("Fetch author id:{}",id);
        Editor editor = editorRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Editor not found with id: {}", id);
                    return new ResourceNotFoundException(
                            "Editor not found with id: " + id
                    );
                });

        log.info("Editor found successfully with id: {}", id);

        return mapToEditorResponse(editor);
    }
}
