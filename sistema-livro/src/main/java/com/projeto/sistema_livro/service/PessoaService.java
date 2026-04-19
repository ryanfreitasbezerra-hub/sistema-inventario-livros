package com.projeto.sistema_livro.service;

import com.projeto.sistema_livro.model.Pessoa;
import com.projeto.sistema_livro.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}