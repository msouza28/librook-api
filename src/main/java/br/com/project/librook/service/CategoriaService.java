package br.com.project.librook.service;

import br.com.project.librook.dto.CategoriaDto;
import br.com.project.librook.exception.ObjectNotFoundException;
import br.com.project.librook.exception.DataIntegrityException;
import br.com.project.librook.model.Categoria;
import br.com.project.librook.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){  //metodo utilizado no Controller para chamar Categoria por Id
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto nao encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){    //metodo utilizado no Controller para chamar uma lista de categorias

        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }


    public Categoria update(Integer id, CategoriaDto objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDescricao(objDto.getDescricao());


        return categoriaRepository.save(obj);
    }


    public void delete(Integer id) {

        findById(id);

        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Categoria nao pode ser deletada! Livros estao vinculados.");
        }
    }
}


