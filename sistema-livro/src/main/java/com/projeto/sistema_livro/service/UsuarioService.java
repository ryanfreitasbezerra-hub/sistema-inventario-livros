package com.projeto.sistema_livro.service;

import com.projeto.sistema_livro.dto.AtualizarUsuarioDTO;
import com.projeto.sistema_livro.model.Usuario;
import com.projeto.sistema_livro.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Usuario buscarPorLogin(String login) {
        return repository.findByLogin(login);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void atualizar(Integer id, AtualizarUsuarioDTO atualizarUsuarioDTO) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "User Not Found"
                        )
                );

        usuario.setNome(atualizarUsuarioDTO.getNome());
        usuario.setLogin(atualizarUsuarioDTO.getLogin());

        if(atualizarUsuarioDTO.getSenha() != null
                && !atualizarUsuarioDTO.getSenha().isBlank()) {
            usuario.setSenha(atualizarUsuarioDTO.getSenha());
        }

        repository.save(usuario);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}