package com.projeto.sistema_livro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtualizarUsuarioDTO {
    private Integer idUsuario;
    private String  nome;
    private String login;
    private String senha;
}
