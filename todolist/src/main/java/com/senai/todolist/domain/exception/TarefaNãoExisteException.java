package com.senai.todolist.domain.exception;

public class TarefaNãoExisteException extends BusinessException {
    public TarefaNãoExisteException(Long id) {
        super("A tarefa com id "+ id + "não existe.",ErrorCode.TAREFA_NAO_EXISTE);
    }
}
