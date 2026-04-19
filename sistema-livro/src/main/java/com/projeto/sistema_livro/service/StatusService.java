package com.projeto.sistema_livro.service;

import com.projeto.sistema_livro.model.Status;
import com.projeto.sistema_livro.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    public List<Status> listarTodos() {
        return repository.findAll();
    }

    public Optional<Status> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Status salvar(Status status) {
        return repository.save(status);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}
