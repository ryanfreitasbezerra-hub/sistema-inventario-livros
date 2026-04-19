package com.projeto.sistema_livro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbProjetosPesquisa")
public class ProjetoPesquisa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_pesquisa_id")
    private Integer projetoPesquisaId;

    @Column(name = "descrição", nullable = false, length = 200)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "pesquisador_id")
    private Pessoa pesquisador;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "data de início")
    private LocalDate dataInicio;

    @Column(name = "data final")
    private LocalDate dataFinal;

    @Column(name = "_em")
    private LocalDateTime em;

    @ManyToOne
    @JoinColumn(name = "atualizar_por")
    private Usuario atualizarPor;

}
