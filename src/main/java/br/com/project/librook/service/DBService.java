package br.com.project.librook.service;

import br.com.project.librook.domain.Categoria;
import br.com.project.librook.domain.Livro;
import br.com.project.librook.repository.CategoriaRepository;
import br.com.project.librook.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class DBService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void instanciaBaseDeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livros de Informática");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Livros de Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

        Livro liv1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
        Livro liv2 = new Livro(null, "Engenharia de Software", "Loius V. Gerstner", "Lorem ipsum", cat1);
        Livro liv3 = new Livro(null, "The Time Machine", "H.G.Wells", "Lorem ipsum", cat2);
        Livro liv4 = new Livro(null, "The War of The Worlds", "H.G.Wells", "Lorem ipsum", cat2);
        Livro liv5 = new Livro(null, "Viola Davis, Em busca de mim", "Viola Davis", "Lorem ipsum", cat3);

        cat1.getLivros().addAll(Arrays.asList(liv1, liv2));
        cat2.getLivros().addAll(Arrays.asList(liv3, liv4));
        cat3.getLivros().addAll(Arrays.asList(liv5));

        categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        livroRepository.saveAll(Arrays.asList(liv1,liv2,liv3,liv4,liv5));

    }


}
