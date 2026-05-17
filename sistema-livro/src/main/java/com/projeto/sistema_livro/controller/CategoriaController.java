package com.projeto.sistema_livro.controller;

import com.projeto.sistema_livro.model.Categoria;
import com.projeto.sistema_livro.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria) {
        return service.salvar(categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}