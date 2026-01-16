package com.simpoint_enterprice.simpoint.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorResponse {

    private Long editorId;
    private String editorName;
    private String editorEmail;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
