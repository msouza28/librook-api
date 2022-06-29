package br.com.project.librook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Entity
public class Categoria implements Serializable{
     private static final long serialVersionUID = 1L;

     public Categoria(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    // uma categoria pode tem 0 ou 1* livros
   @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();



}
