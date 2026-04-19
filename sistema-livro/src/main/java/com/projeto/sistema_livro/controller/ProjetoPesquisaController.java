package com.projeto.sistema_livro.controller;

import com.projeto.sistema_livro.model.ProjetoPesquisa;
import com.projeto.sistema_livro.service.ProjetoPesquisaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos-pesquisa")
@CrossOrigin("*")
public class ProjetoPesquisaController {

    private final ProjetoPesquisaService service;

    public ProjetoPesquisaController(ProjetoPesquisaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProjetoPesquisa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ProjetoPesquisa buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public ProjetoPesquisa salvar(@RequestBody ProjetoPesquisa projetoPesquisa) {
        return service.salvar(projetoPesquisa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}