package com.projeto.sistema_livro.repository;

import com.projeto.sistema_livro.model.ProjetoPesquisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoPesquisaRepository extends JpaRepository<ProjetoPesquisa, Integer> {
}
