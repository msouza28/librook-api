package br.com.project.librook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;
    // um livro precisa do id da categoria
    private Categoria categoria;

}
