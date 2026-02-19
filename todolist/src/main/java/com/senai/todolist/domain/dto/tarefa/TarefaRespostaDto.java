package com.senai.todolist.domain.dto.tarefa;

public record TarefaRespostaDto(
        Long id,
        String nomeTarefa,
        String descricaoTarefa,
        int prioridade
) {
}
