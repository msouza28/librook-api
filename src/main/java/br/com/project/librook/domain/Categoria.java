package br.com.project.librook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Integer id;
    private String nome;
    private String descricao;
    // uma categoria pode tem 0 ou 1* livros
    private List<Livro> livros = new ArrayList<>();

}
