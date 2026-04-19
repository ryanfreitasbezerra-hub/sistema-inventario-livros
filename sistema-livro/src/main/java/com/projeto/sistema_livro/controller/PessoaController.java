package com.projeto.sistema_livro.controller;

import com.projeto.sistema_livro.model.Pessoa;
import com.projeto.sistema_livro.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin("*")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pessoa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return service.salvar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}