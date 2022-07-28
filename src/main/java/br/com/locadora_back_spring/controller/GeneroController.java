package br.com.locadora_back_spring.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.locadora_back_spring.model.Genero;
import br.com.locadora_back_spring.service.GeneroService;

@RestController
@RequestMapping("/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping("/{id}")
    public Genero genero(@PathVariable("id") Long id) {
        return generoService.buscarPorId(id);
    }

    @PostMapping("")
    public Genero salvar(@RequestBody Genero genero) {
        return generoService.salvar(genero);
    }

    @PutMapping("")
    public Genero editar(@RequestBody Genero genero) {
        return generoService.salvar(genero);
    }

    @GetMapping("")
    public List<Genero> listar() {
        return generoService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        generoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
