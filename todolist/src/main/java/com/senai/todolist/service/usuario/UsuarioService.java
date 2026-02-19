package com.senai.todolist.service.usuario;

import com.senai.todolist.domain.dto.usuario.cadastro.UsuarioRequisicaoDto;
import com.senai.todolist.domain.model.Usuario;
import com.senai.todolist.infraecstruture.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registrarUsuario(UsuarioRequisicaoDto usuarioRequisicaoDto) {
        Usuario usuario = new Usuario(
                usuarioRequisicaoDto.nome(),
                usuarioRequisicaoDto.email(),
                passwordEncoder.encode(usuarioRequisicaoDto.senha())
        );

        usuarioRepository.save(usuario);
    }
}
