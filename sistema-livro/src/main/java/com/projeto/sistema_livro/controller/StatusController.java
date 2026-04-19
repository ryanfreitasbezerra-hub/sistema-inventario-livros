package com.projeto.sistema_livro.controller;

import com.projeto.sistema_livro.model.Status;
import com.projeto.sistema_livro.service.StatusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin("*")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<Status> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Status buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id).orElseThrow();
    }

    @PostMapping
    public Status salvar(@RequestBody Status status) {
        return service.salvar(status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}