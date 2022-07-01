package br.com.project.librook.controller;

import br.com.project.librook.dto.CategoriaDto;
import br.com.project.librook.model.Categoria;
import br.com.project.librook.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController { // buscando categoria por id

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();

        // transformando uma lista de categoria em lista de categoriaDto
        //converter lista categoria: list.stream.map(para cada obj, instanciar new CategoriaDto(obj).collect(Collectors.toList()));
        List<CategoriaDto> listDto = list.stream().map(obj -> new CategoriaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}



