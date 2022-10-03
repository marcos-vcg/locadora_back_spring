package br.com.locadora_back_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadora_back_spring.model.Filme;
import br.com.locadora_back_spring.service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("")
    public List<Filme> listar() {
        return filmeService.buscarTodosOrdenadosPorNomeId();
    }

    @GetMapping("/{id}")
    public Filme buscar(@PathVariable("id") Long id) {
        return filmeService.buscarPorId(id);
    }

    @PostMapping("")
    public Filme inserir(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @PutMapping("")
    public Filme editar(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        filmeService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
