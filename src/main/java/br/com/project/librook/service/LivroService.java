package br.com.project.librook.service;

import br.com.project.librook.exception.ObjectNotFoundException;
import br.com.project.librook.model.Livro;
import br.com.project.librook.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    public Livro findById(Integer id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(()
                -> new ObjectNotFoundException("Objeto nao encontrado! Id:" + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }
}
