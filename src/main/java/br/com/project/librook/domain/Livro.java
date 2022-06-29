package br.com.project.librook.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String nomeAutor;
    private String texto;
    // um livro precisa do id da categoria
    //varios livros para uma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
