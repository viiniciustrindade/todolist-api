package com.senai.todolist.service;

import com.senai.todolist.domain.dto.usuario.UsuarioRequisicaoDto;
import com.senai.todolist.domain.dto.usuario.UsuarioRespostaDto;
import com.senai.todolist.domain.exception.UsuarioJaExisteException;
import com.senai.todolist.domain.exception.UsuarioNaoExisteException;
import com.senai.todolist.domain.mapper.UsuarioMapper;
import com.senai.todolist.domain.model.Usuario;
import com.senai.todolist.infraecstruture.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioRespostaDto criarUsuario(UsuarioRequisicaoDto requisicaoDto) {
        if(usuarioRepository.existsByNome(requisicaoDto.nome())){
            throw new UsuarioJaExisteException("O usuário ja foi cadastrado!");
        }
        return usuarioMapper.toRespostaDto(usuarioRepository.save(usuarioMapper.toEntity(requisicaoDto)));
    }

    @Override
    public List<UsuarioRespostaDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()){
            Collections.emptyList();
        }

        return usuarios.stream()
                .map(usuarioMapper::toRespostaDto)
                .toList();
    }

    @Override
    public UsuarioRespostaDto atualizarUsuario(UsuarioRequisicaoDto requisicaoDto, Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não econtrado!"));
        Usuario usuarioAtualizado = usuarioMapper.toUpdateDto(requisicaoDto,usuario);

        return usuarioMapper.toRespostaDto(usuarioRepository.save(usuarioAtualizado));
    }

    @Override
    public UsuarioRespostaDto listarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não econtrado!"));

        return usuarioMapper.toRespostaDto(usuario);
    }

    @Override
    public void deletarUsuario(Long id) {
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }

        throw new UsuarioNaoExisteException("Usuário não encontrado!");
    }
}
