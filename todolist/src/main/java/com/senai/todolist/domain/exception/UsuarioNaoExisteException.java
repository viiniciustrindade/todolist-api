package com.senai.todolist.domain.exception;

import org.springframework.http.HttpStatus;

public class UsuarioNaoExisteException extends BusinessException{
    public UsuarioNaoExisteException(String email) {
        super("Usuário com email " + email + " não encontrado.",
                ErrorCode.USUARIO_NAO_ENCONTRADO);
    }
}
