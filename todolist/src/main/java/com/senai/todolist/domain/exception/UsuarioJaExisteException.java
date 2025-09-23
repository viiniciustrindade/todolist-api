package com.senai.todolist.domain.exception;

public class UsuarioJaExisteException extends RuntimeException{
    public UsuarioJaExisteException(String mensagem){
        super(mensagem);
    }
}
