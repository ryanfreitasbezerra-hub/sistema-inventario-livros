package com.projeto.sistema_livro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbPessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Integer pessoaId;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "data de nascimento")
    private LocalDate dataNascimento;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "pessoa_tipo_id")
    private Integer pessoaTipoId;

    @ManyToOne
    @JoinColumn(name = "atualizar_por")
    private Usuario atualizarPor;

    @Column(name = "data")
    private LocalDate data;


}
