package com.senai.todolist.domain.exception;

import org.springframework.http.HttpStatus;

public class UsuarioJaExisteException extends BusinessException{
    public UsuarioJaExisteException(String email) {
        super("Usuário com email " + email + " já existe.",
                ErrorCode.USUARIO_JA_EXISTE);
    }
}
