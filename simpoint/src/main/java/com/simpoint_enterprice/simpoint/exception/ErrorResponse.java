package com.simpoint_enterprice.simpoint.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int status;          // 404, 500, etc
    private String message;
    private LocalDateTime timestamp;
}
