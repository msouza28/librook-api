package br.com.project.librook.dto;

import br.com.project.librook.model.Livro;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class LivroDto implements Serializable {

    private static final long serialVersionUID = 1L;

    public LivroDto (Livro obj) {
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
        this.nomeAutor = obj.getNomeAutor();
        this.texto = obj.getTexto();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String nomeAutor;
    private String texto;
}
