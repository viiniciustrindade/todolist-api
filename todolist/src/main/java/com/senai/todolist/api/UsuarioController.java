package com.senai.todolist.api;

import com.senai.todolist.domain.dto.usuario.UsuarioRequisicaoDto;
import com.senai.todolist.domain.dto.usuario.UsuarioRespostaDto;
import com.senai.todolist.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<UsuarioRespostaDto>> obterTodosUsuarios(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.listarUsuarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDto> obterUsuarioPorId(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.listarUsuarioPorId(id));
    }
    @PostMapping
    public ResponseEntity<UsuarioRespostaDto> criarUsuario(
            @RequestBody UsuarioRequisicaoDto requisicaoDto
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.criarUsuario(requisicaoDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRespostaDto> atualizarUsuario(
        @PathVariable Long id,
        @RequestBody UsuarioRequisicaoDto requisicaoDto
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.atualizarUsuario(requisicaoDto,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }
}
