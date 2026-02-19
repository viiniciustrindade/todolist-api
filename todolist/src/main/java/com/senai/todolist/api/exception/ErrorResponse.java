package com.senai.todolist.api.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        int status,
        String error,
        String code,
        String message,
        String path
) {

    public ErrorResponse(int status,
                         String error,
                         String code,
                         String message,
                         String path) {

        this(LocalDateTime.now(), status, error, code, message, path);
    }
}
