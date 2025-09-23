package com.senai.todolist.domain.exception;

public class UsuarioNaoExisteException extends RuntimeException{
    public UsuarioNaoExisteException(String mensagem){
        super(mensagem);
    }

}
