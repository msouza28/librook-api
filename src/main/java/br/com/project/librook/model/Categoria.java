package br.com.project.librook.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

     @NotEmpty(message = "Campo NOME é requerido")
     @Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;
    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "O campo DESCRIÇÃO deve ter entre 3 e 200 caracteres")
    private String descricao;

    // uma categoria pode tem 0 ou 1* livros
   @OneToMany(mappedBy = "categoria")
    private List<Livro> livros = new ArrayList<>();



}
