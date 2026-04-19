package com.projeto.sistema_livro.controller;

import com.projeto.sistema_livro.dto.LoginDTO;
import com.projeto.sistema_livro.model.Usuario;
import com.projeto.sistema_livro.repository.UsuarioRepository;
import com.projeto.sistema_livro.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    public AuthController(UsuarioRepository usuarioRepository,  UsuarioService usuarioService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO data) {

        Usuario user = usuarioRepository.findByLogin(data.getEmail());

        if(user == null || !user.getSenha().equals(data.getSenha())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais Inválidas");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Login realizado com sucesso!");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario data) throws Exception {

        Usuario registeredUser  = usuarioRepository.findByLogin(data.getLogin());

        if(registeredUser != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já cadastrado!");
        }

        try{
            Usuario userToRegister = usuarioService.salvar(data);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuário cadastrado com sucesso!");
    }
}
