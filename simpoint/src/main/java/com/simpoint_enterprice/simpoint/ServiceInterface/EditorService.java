package com.simpoint_enterprice.simpoint.ServiceInterface;

import com.simpoint_enterprice.simpoint.Dto.EditorResponse;
import com.simpoint_enterprice.simpoint.Model.Editor;

import java.util.List;

public interface EditorService {
     List<EditorResponse> getAllList();
     EditorResponse getById(Long id);

}
