package com.senai.todolist.service.tarefa;

import com.senai.todolist.domain.dto.tarefa.TarefaRequisicaoDto;
import com.senai.todolist.domain.dto.tarefa.TarefaRespostaDto;
import com.senai.todolist.domain.mapper.TarefaMapper;
import com.senai.todolist.domain.model.Tarefa;
import com.senai.todolist.domain.model.Usuario;
import com.senai.todolist.infraecstruture.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    private final TarefaMapper tarefaMapper;

    public TarefaRespostaDto criarTarefa(TarefaRequisicaoDto tarefaRequisicaoDto,
                                         Usuario usuario){
        Tarefa tarefa = tarefaMapper.toEntity(tarefaRequisicaoDto);
        tarefa.setUsuario(usuario);

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return tarefaMapper.toRespostaDto(tarefaSalva);
    }

    public Page<TarefaRespostaDto> buscarTodasAsTarefas(
            Usuario usuario,Pageable pageable) {

        Page<Tarefa> pagina = tarefaRepository.findByUsuario(usuario,pageable);

        return pagina.map(tarefaMapper::toRespostaDto);
    }
}
