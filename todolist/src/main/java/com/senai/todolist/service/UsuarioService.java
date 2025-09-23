package com.senai.todolist.service;

import com.senai.todolist.domain.dto.usuario.UsuarioRequisicaoDto;
import com.senai.todolist.domain.dto.usuario.UsuarioRespostaDto;
import com.senai.todolist.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsuarioService {
    UsuarioRespostaDto criarUsuario(UsuarioRequisicaoDto requisicaoDto);
    List<UsuarioRespostaDto> listarUsuarios();
    UsuarioRespostaDto atualizarUsuario(UsuarioRequisicaoDto requisicaoDto, Long id);
    UsuarioRespostaDto listarUsuarioPorId(Long id);
    void deletarUsuario(Long id);
}
