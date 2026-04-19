package com.projeto.sistema_livro.service;

import com.projeto.sistema_livro.model.ProjetoPesquisa;
import com.projeto.sistema_livro.repository.ProjetoPesquisaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoPesquisaService {

    private final ProjetoPesquisaRepository repository;

    public ProjetoPesquisaService(ProjetoPesquisaRepository repository) {
        this.repository = repository;
    }

    public List<ProjetoPesquisa> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProjetoPesquisa> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public ProjetoPesquisa salvar(ProjetoPesquisa projetoPesquisa) {
        return repository.save(projetoPesquisa);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}