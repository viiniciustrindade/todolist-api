package com.senai.todolist.domain.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    USUARIO_JA_EXISTE(HttpStatus.CONFLICT),
    USUARIO_NAO_ENCONTRADO(HttpStatus.NOT_FOUND),
    CREDENCIAIS_INVALIDAS(HttpStatus.UNAUTHORIZED),
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);

    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
